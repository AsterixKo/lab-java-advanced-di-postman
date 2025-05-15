package com.example.app.services;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Slf4j
public class EarlyBirdDiscountService {

    public int calculateDiscount(Date bookingDate, Date eventDate) {
        long diff = getDifferenceDays(eventDate, bookingDate);
        log.info("diff={}", diff);
        if (diff <= 30) {
            return 15;
        }
        return 100;
    }

    public long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

}
