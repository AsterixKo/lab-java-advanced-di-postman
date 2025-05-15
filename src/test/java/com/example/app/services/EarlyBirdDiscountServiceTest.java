package com.example.app.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EarlyBirdDiscountServiceTest {
    @Autowired
    private EarlyBirdDiscountService earlyBirdDiscountService;

    @Test
    public void testDatesTest() throws ParseException {

        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
        String inputString1 = "15-05-2025";
        String inputString2 = "15-06-2025";


        Date date1 = myFormat.parse(inputString1);
        Date date2 = myFormat.parse(inputString2);
        long value = earlyBirdDiscountService.getDifferenceDays(date2, date1);
        System.out.println(value);


    }

    @Test
    public void calculateDiscountTest() throws ParseException {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
        String now = "15-05-2025";
        String bookingDate = "12-06-2025";


        Date date1 = myFormat.parse(now);
        Date date2 = myFormat.parse(bookingDate);
        int value = earlyBirdDiscountService.calculateDiscount(date2, date1);
        System.out.println(value);
    }
}
