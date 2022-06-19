import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
// import com.google.api.services.calendar.model.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Calendar;
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
	
	/** Application name. */
    private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";
    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    /** Directory to store authorization tokens for this application. */
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     * 
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
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
	
	public static Calendar generateConnection() throws GeneralSecurityException, IOException {
		 // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        
        return service;

	}
	
//	public static String createEvent( String eventTitle ) throws IOException {
//
//        // 19.06.2022
//        final String regex = "(\\d{2}.\\d{2}.\\d{4})";
//
//        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
//        final Matcher matcher = pattern.matcher(eventTitle);
//
//        String foundDateString = new String();
//
//        if (matcher.find()) {
//            foundDateString = matcher.group(1);
//
//            System.out.printf("Date found in Summary: %s - creating Event...\n", foundDateString);
//
//            Event event = new Event()
//                    .setSummary(eventTitle);
//
//            EventDateTime startEventDateTime = CalenderUtil.generateStartEventDateTime(foundDateString);
//            EventDateTime endEventDateTime = CalenderUtil.generateEndEventDateTimePlusOneDay(foundDateString);
//            event.setStart(startEventDateTime);
//            event.setEnd(endEventDateTime);
//
//            Event.Reminders reminders = CalenderUtil.generateReminders();
//            event.setReminders(reminders);
//
//            String calendarId = "primary";
//            event = service.events().insert(calendarId, event).execute();
//            System.out.printf("Event created:\n+ Start: %s\n+ ID: %s\n+ Link: %s\n", event.getStart(), event.getId(),
//                    event.getHtmlLink());
//            return event.getId();
//        } else {
//            System.out.println("Kein Datum gefunden - kein Event wird angelegt.");
//            return "";
//        }
//	}
	
	public static String createEvent(Calendar service, String eventTitle ) throws IOException {

        // 19.06.2022
        final String regex = "(\\d{2}.\\d{2}.\\d{4})";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(eventTitle);

        String foundDateString = new String();

        if (matcher.find()) {
            foundDateString = matcher.group(1);

            System.out.printf("Date found in Summary: %s - creating Event...\n", foundDateString);

            Event event = new Event()
                    .setSummary(eventTitle);

            EventDateTime startEventDateTime = CalenderUtil.generateStartEventDateTime(foundDateString);
            EventDateTime endEventDateTime = CalenderUtil.generateEndEventDateTimePlusOneDay(foundDateString);
            event.setStart(startEventDateTime);
            event.setEnd(endEventDateTime);

            Event.Reminders reminders = CalenderUtil.generateReminders();
            event.setReminders(reminders);

            String calendarId = "primary";
            event = service.events().insert(calendarId, event).execute();
            System.out.printf("Event created:\n+ Start: %s\n+ ID: %s\n+ Link: %s\n", event.getStart(), event.getId(),
                    event.getHtmlLink());
            return event.getId();
        } else {
            System.out.println("Kein Datum gefunden - kein Event wird angelegt.");
            return "";
        }
	}
	
	public static void updateEventSummary(Calendar service, String eventId, String summary) throws IOException {
        // Retrieve the event from the API
        Event event = service.events().get("primary", eventId).execute();

        // Make a change
        event.setSummary(summary);

        // Update the event
        Event updatedEvent = service.events().update("primary", event.getId(), event).execute();

        System.out.printf("Event updated:\n+ Start: %s\n+ ID: %s\n+ Link: %s\n", updatedEvent.getStart(),
                updatedEvent.getId(),
                updatedEvent.getHtmlLink());
    }
	
	}
