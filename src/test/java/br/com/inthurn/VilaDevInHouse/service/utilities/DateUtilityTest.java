package br.com.inthurn.VilaDevInHouse.service.utilities;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DateUtilityTest {

    private DateUtility dateUtility;

    @Test
    public void shoulReturnNullIfValueIsNotGiven(){
        String shouldBeNull = DateUtility.dateFormatter((Date) null);
        assertNull(shouldBeNull);
    }

//    @Test
//    public void SouldReturnFormattedDateWhenDateIsGiven(){
//        Date date = new Date(System.currentTimeMillis());
//        assertEquals("2022-02-20", date);
//
//    }

}
