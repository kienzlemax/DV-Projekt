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
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.EventReminder;
import com.google.api.services.calendar.model.Events;

public class CalenderUtil {

    // definiert die den Abstand zw. Erinnerung und Termin im Kalender in Minuten
	final static int reminderDuration = 60*24;


    /**
     * Gibt die Startzeit des Termins zurück
     *
     * @param  dateInput  das Datum als Text eingabe im Format dd.MM.yyyy
     * @return   das Datum formatiert im richtigen Objekt für die Kalender Eventanlage
     * @author @davidjl21
     */
    public static EventDateTime generateStartEventDateTime(String dateInput) {

        // Eingabeformats des Datums
        DateFormat dateFormatInput = new SimpleDateFormat("dd.MM.yyyy");
        // Ausgabeformat des Datums
        DateFormat dateFormatOutput = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        try {
            // konvertiert das Datum aus einem String in ein Objekt vom Typ Date
            date = dateFormatInput.parse(dateInput);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        String startDateStr = dateFormatOutput.format(date);

        // Out of the 6 methods for creating a DateTime object with no time element,
        // only the String version works
        DateTime startDateTime = new DateTime(startDateStr);

        // Must use the setDate() method for an all-day event (setDateTime() is used for
        // timed events)
        EventDateTime startEventDateTime = new EventDateTime().setDate(startDateTime);

        return startEventDateTime;
    }

    /**
     * Gibt die Endzeit des Termins zurück
     * Die Funktion rechnet genau 24h (86400000 => in Millisekunden)
     *
     * @param  dateInput  das Datum als Text eingabe im Format dd.MM.yyyy
     * @return   das Datum formatiert im richtigen Objekt für die Kalender Eventanlage
     * @author @davidjl21
     */
    public static EventDateTime generateEndEventDateTimePlusOneDay(String dateInput) {
        // Eingabeformats des Datums
        DateFormat dateFormatInput = new SimpleDateFormat("dd.MM.yyyy");
        // Ausgabeformat des Datums
        DateFormat dateFormatOutput = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        try {
            // konvertiert das Datum aus einem String in ein Objekt vom Typ Date
            date = dateFormatInput.parse(dateInput);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        // 86400000 entspricht 24h * 60min * 60sek * 1000 mSek
        date = new Date(date.getTime() + 86400000);
        String endDateStr = dateFormatOutput.format(date);

        // Out of the 6 methods for creating a DateTime object with no time element,
        // only the String version works
        DateTime endDateTime = new DateTime(endDateStr);

        // Must use the setDate() method for an all-day event (setDateTime() is used for
        // timed events)
        EventDateTime endEventDateTime = new EventDateTime().setDate(endDateTime);

        return endEventDateTime;
    }

    /**
    * Generiert das Reminder Objekt, der an das Event Objekt angehängt wird
    *
    * @return   Reminder 
    * @author @davidjl21
    */
    public static Event.Reminders generateReminders() {

        Event.Reminders reminders = new Event.Reminders();
        // Deaktiviert den Standardreminder des Kalenders
        reminders.setUseDefault(false);

        EventReminder reminder = new EventReminder();
        // Setzt den Modus der Erinnerung
        // Möglich zw. Popup und SMS
        reminder.setMethod("popup");
        // nutzt den vordefinierten REminderzeitraum
        reminder.setMinutes(reminderDuration);

        // das Reminderobjekt für ein EVent setzt sich aus diesem Objekt zusammen
        List<EventReminder> listEventReminder = new ArrayList<EventReminder>();
        listEventReminder.add(reminder);
        reminders.setOverrides(listEventReminder);

        return reminders;
    }
}
