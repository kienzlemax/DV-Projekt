import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.Calendar.CalendarList;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.EventReminder;
import com.google.api.services.calendar.model.Events;

public class CalenderWrapper {
	
    private static final String APPLICATION_NAME = "Google Calendar API fuer DV Todo App";

    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    /** Pfad für die Token */
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    // Definiert den Zugriff der API auf den Calender
    // CalendarScopes.CALENDAR erlaubt sowohl schreibenden als auch lesenden Zugriff auf den freigegeben Kalender
    private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR);
    // Definiert den Pfad in dem die Credentials liegen
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     * 
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException, FileNotFoundException {
        // Load client secrets.
        InputStream in = CalendarIntegration.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
        // returns an authorized Credential object.
        return credential;
    }
	/**
     * Erzeugt ein Kalender Objekt für die bfrage
     * 
     * @return An Calendar Object
     * @throws IOException If the credentials.json file cannot be found.
     * @author @davidjl21
     */
    public static Calendar generateConnection() {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        return service;

    }
	
    /**
     * Erzeugt das Event und speichert es im Kalender
     *
     * @param  service  das Datum als Text eingabe im Format dd.MM.yyyy
     * @param  eventTitle  
     * @return   die Event ID - diese muss gespeichert werden um eine nachfolgende Änderung an dem Event sicherzustellen
     * @author @davidjl21
     */
	public static String createEvent(Calendar service, String eventTitle )  {

        // Enspricht dem allgemein genutzten deutschen Datumsformat, z.B.:
        // 19.06.2022
        final String regex = "(\\d{2}.\\d{2}.\\d{4})";

        // kombiniert das definierte Format mit zusätzlichen Optionen für Regex
        // In diesem Fall: Aktivierung von mehreren Zeilen
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        // Wendet das Muster auf den übergebenen Titel an
        final Matcher matcher = pattern.matcher(eventTitle);

        String foundDateString = new String();

        // Wenn ein Datum im Titel (Todo) gefunden wird, wird ein Event angelegt
        if (matcher.find()) {
            foundDateString = matcher.group(1);

            System.out.printf("Date found in Summary: %s - creating Event...\n", foundDateString);

            Event event = new Event()
                    .setSummary(eventTitle);

            // Erzeugt und setzt das Start- und Enddatum
            EventDateTime startEventDateTime = CalenderUtil.generateStartEventDateTime(foundDateString);
            EventDateTime endEventDateTime = CalenderUtil.generateEndEventDateTimePlusOneDay(foundDateString);
            event.setStart(startEventDateTime);
            event.setEnd(endEventDateTime);

            // erzeugt und setzt die Reminder
            Event.Reminders reminders = CalenderUtil.generateReminders();
            event.setReminders(reminders);

            // Definiert den Kalender in dem das Event angelegt werden soll
            // primary ist der Schlüssel für den Standardkalender 
            String calendarId = "primary";
            event = service.events().insert(calendarId, event).execute();

            // Loggt die Informationen des Events in die Konsole
            System.out.printf("Event created:\n+ Start: %s\n+ ID: %s\n+ Link: %s\n", event.getStart(), event.getId(),
                    event.getHtmlLink());
            return event.getId();
        } else {
            System.out.println("Kein Datum gefunden - kein Event wird angelegt.");
            return "";
        }
	}
	
    /**
     * Passt die den Eventtitel (Summary) an
     *
     * @param  service  Kalendar Objekt
     * @param  eventId  die ID des Events welches angepasst werden soll
     * @param  summary  Der TExt der geändert werden soll
     * @return   -
     * @author @davidjl21
     */
	public static void updateEventSummary(Calendar service, String eventId, String summary)  {
        // Ruft das Event über die übergebene Event Id ab
        Event event = service.events().get("primary", eventId).execute();

        // Überschreibt die Summary (Event Title)
        event.setSummary(summary);

        // Passt das Event mit den neu gesetzten Summary (Event Titel) an
        Event updatedEvent = service.events().update("primary", event.getId(), event).execute();

        // Loggt die Informationen des Events in die Konsole
        System.out.printf("Event updated:\n+ Start: %s\n+ ID: %s\n+ Link: %s\n", updatedEvent.getStart(),
                updatedEvent.getId(),
                updatedEvent.getHtmlLink());
    }
	
}
