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
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.EventReminder;
import com.google.api.services.calendar.model.Events;

public class CalenderUtil {
	final static int reminderDuration = 60*24;

    public static EventDateTime generateStartEventDateTime(String dateInput) {

        DateFormat dateFormatInput = new SimpleDateFormat("dd.MM.yyyy");
        DateFormat dateFormatOutput = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        try {
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

    public static EventDateTime generateEndEventDateTimePlusOneDay(String dateInput) {
        DateFormat dateFormatInput = new SimpleDateFormat("dd.MM.yyyy");
        DateFormat dateFormatOutput = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        try {
            date = dateFormatInput.parse(dateInput);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

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

    public static Event.Reminders generateReminders() {

        Event.Reminders reminders = new Event.Reminders();
        reminders.setUseDefault(false);

        EventReminder reminder = new EventReminder();
        reminder.setMethod("popup");
        reminder.setMinutes(reminderDuration);

        List<EventReminder> listEventReminder = new ArrayList<EventReminder>();
        listEventReminder.add(reminder);
        reminders.setOverrides(listEventReminder);

        return reminders;
    }
}
