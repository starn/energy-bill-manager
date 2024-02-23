package fr.starn.energybillmanager.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CalendarUtilsTest {
    @Autowired
    CalendarUtils calendarUtils;

    @Test
    void shouldReturn28WhenGetLastDayOfFeb2022() {
        Date date = calendarUtils.getLastDayOfMonth(1, 2022);
        assertEquals(1, date.getMonth());
        assertEquals(28, date.getDate());
    }

    @Test
    void shouldReturn1WhenGetFirstDayOfFeb2022() {
        Date date = calendarUtils.getFirstDayOfMonth(1, 2022);
        assertEquals(1, date.getMonth());
        assertEquals(1, date.getDate());
    }
}