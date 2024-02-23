package fr.starn.energybillmanager.utils;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class CalendarUtils {
    public Date getFirstDayOfMonth(int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    public Date getLastDayOfMonth(int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }
}
