package com.example.app.controllers;

import com.example.app.services.EarlyBirdDiscountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/api/discount")
public class DiscountController {

    public EarlyBirdDiscountService earlyBirdDiscountService;

    public DiscountController(EarlyBirdDiscountService earlyBirdDiscountService) {
        this.earlyBirdDiscountService = earlyBirdDiscountService;
    }

    @GetMapping
    public ResponseEntity<?> getDiscount(@RequestParam String bookingDate, @RequestParam String eventDate) {

        try {
            Date date1 = null;
            Date date2 = null;
            try {
                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                date1 = myFormat.parse(eventDate);
                date2 = myFormat.parse(bookingDate);
            } catch (ParseException e) {
                log.error("Error al crear fechas {}", e.getMessage());
                return new ResponseEntity<>("Error al crear fechas", HttpStatus.BAD_REQUEST);
            }

            int value = earlyBirdDiscountService.calculateDiscount(date2, date1);

            return new ResponseEntity<>(value, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error de Exception {}", e.getMessage());
            return new ResponseEntity<>("Error de Exception", HttpStatus.BAD_REQUEST);
        }


    }
}
