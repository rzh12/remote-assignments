package com.example.assignments;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookieController {

    // Endpoint: /myName
    @GetMapping("/myName")
    public ResponseEntity<String> myName(@CookieValue(name = "userName", defaultValue = "") String userName) {
        // Check if the userName cookie is present
        if (!userName.isEmpty()) {
            // Show the userName
            return ResponseEntity.ok(String.format("Your name: %s", userName));
        }

        // If the cookie is not present, return an HTML form for the user to enter the name
        String htmlForm = "<form action='/trackName'>" +
                          "Enter your name: <input type='text' name='name'>" +
                          // The name attribute of the input field is set to 'name', which is the key to be used
                          "<input type='submit' value='Submit'>" +
                          "</form>";
        return ResponseEntity.ok(htmlForm);
    }

    // Endpoint: /trackName
    @GetMapping("/trackName")
    // Create a ResponseCookie object
    public ResponseEntity<Void> trackName(@RequestParam String name) {
        // The 'name' parameter contains the value submitted by the user in the form
        ResponseCookie cookie = ResponseCookie.from("userName", name)
                                              // Set the name of the cookie to "userName"
                                              // Set the value of the cookie to the value of the 'name' parameter
                                              .httpOnly(true)
                                              .path("/")
                                              .maxAge(86400) // 1 day
                                              .build();
        // Set the cookie in the response header and redirect to /myName
        return ResponseEntity.status(HttpStatus.FOUND) // redirecting
                             .header(HttpHeaders.SET_COOKIE, cookie.toString())
                             .header(HttpHeaders.LOCATION, "/myName")
                             .build();
    }
}

