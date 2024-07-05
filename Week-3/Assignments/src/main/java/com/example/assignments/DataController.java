package com.example.assignments;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @GetMapping("/data")
    public String getData(@RequestParam(required = false) String number) {
        // http://localhost:3000/data
        if (number == null) {
            return "Lack of Parameter";
        }
        // for number=non-integer value
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return "Wrong Parameter";
        }
        // for number=integer, return sum of a sequence
        long sum;
        long num = Integer.parseInt(number);
        sum = num * (num + 1) / 2;
        return String.valueOf(sum);
    }
}
