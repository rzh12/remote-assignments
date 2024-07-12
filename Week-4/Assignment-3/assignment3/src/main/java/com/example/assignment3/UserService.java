package com.example.assignment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(String email, String password) {
        // Generate the next unique ID for a new user.
        Integer id = getNextId();
        // SQL statement to insert a new user into the database.
        String sql = "INSERT INTO assignment.user (id, email, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, id, email, password);
    }
    // Check for email
    public boolean checkEmail(String email) {
        String sql = "SELECT COUNT(*) FROM assignment.user WHERE email = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{email}, Integer.class);
        return count != null && count > 0;
    }
    // Check for credential
    public boolean validateUser(String email, String password) {
        String sql = "SELECT COUNT(*) FROM assignment.user WHERE email = ? AND password = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{email, password}, Integer.class);
        return count != null && count > 0;
    }
    // Get the next id
    private Integer getNextId() {
        String sql = "SELECT COALESCE(MAX(id), 0) + 1 FROM assignment.user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
