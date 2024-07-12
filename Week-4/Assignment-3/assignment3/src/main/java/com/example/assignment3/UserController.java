package com.example.assignment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showForm() {
        return "redirect:/index.html"; // Redirects to index.html
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam("email") String email,
                         @RequestParam("password") String password) {
        // Check if the email is already used.
        boolean emailUsed = userService.checkEmail(email);

        if (!emailUsed) {
            // If email is not used, creates a new user.
            userService.addUser(email, password);
            return "redirect:/member.html"; // Redirects to member.html
        }
        // Redirects back to the signup page with an error message if the email is used.
        return "redirect:/index.html?error=emailUsed";
    }

    @PostMapping("/signin")
    public String signIn(@RequestParam("email") String email,
                         @RequestParam("password") String password) {
        // Checks if the credential is valid.
        boolean validUser = userService.validateUser(email, password);

        if (validUser) {
            return "redirect:/member.html"; // Redirects to member.html if credential is valid
        }

        return "redirect:/index.html?error=invalidCredentials"; // Redirects back to index.html if sign-in fails
    }
}
