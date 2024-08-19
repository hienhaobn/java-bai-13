package org.example;

import org.example.exception.BirthDayException;
import org.example.exception.EmailException;
import org.example.exception.FullNameException;
import org.example.exception.PhoneException;

public class EmployeeValidator {
    public static void validateFullName(String fullName) throws FullNameException {
        if (fullName == null || fullName.isEmpty()) {
            throw new FullNameException("Full name cannot be empty.");
        }
    }

    public static void validateBirthDate(String birthDate) throws BirthDayException {
        if (!birthDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new BirthDayException("Birth date must be in the format dd/MM/yyyy.");
        }
    }

    public static void validatePhone(String phone) throws PhoneException {
        if (!phone.matches("\\d{10,11}")) {
            throw new PhoneException("Phone number must be 10 or 11 digits.");
        }
    }

    public static void validateEmail(String email) throws EmailException {
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new EmailException("Invalid email format.");
        }
    }
}
