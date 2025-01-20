/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.langcen.util;

import java.util.regex.Pattern;

/**
 *
 * @author Shaurya
 */
public class LangCenValid {
    private static final Pattern STUDENT_PATTERN = Pattern.compile("^[a-zA-Z\\s]+$");
    private static final Pattern STUDENT_ID_PATTERN = Pattern.compile("^\\d{4}$");
    private static final Pattern COURSE_PATTERN = Pattern.compile("^(English|Japanese|Nepali)$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^(98|97)\\d{8}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");  // Email regex pattern

    /**
     * Validates if a string is null or empty.
     *
     * @param value the string to validate
     * @return true if the string is null or empty, otherwise false
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Validates if the student name contains only alphabets and spaces.
     *
     * @param student the student name to validate
     * @return true if valid, otherwise false
     */
    public static boolean isValidStudent(String student) {
        return !isNullOrEmpty(student) && STUDENT_PATTERN.matcher(student).matches();
    }

    /**
     * Validates if the student ID is exactly 7 digits.
     *
     * @param studentId the student ID to validate
     * @return true if valid, otherwise false
     */
    public static boolean isValidStudentId(String studentId) {
        return !isNullOrEmpty(studentId) && STUDENT_ID_PATTERN.matcher(studentId).matches();
    }

    /**
     * Validates if the course is one of the allowed options (English, Japanese, Nepali).
     *
     * @param course the course to validate
     * @return true if valid, otherwise false
     */
    public static boolean isValidCourse(String course) {
        return !isNullOrEmpty(course) && COURSE_PATTERN.matcher(course).matches();
    }

    /**
     * Validates if the contact number starts with 98 and has 10 digits in total.
     *
     * @param phone the phone number to validate
     * @return true if valid, otherwise false
     */
    public static boolean isValidPhone(String phone) {
        return !isNullOrEmpty(phone) && PHONE_PATTERN.matcher(phone).matches();
    }

    /**
     * Validates if the email is in the correct format.
     *
     * @param email the email to validate
     * @return true if valid, otherwise false
     */
    public static boolean isValidEmail(String email) {
        return !isNullOrEmpty(email) && EMAIL_PATTERN.matcher(email).matches();
    }


    /**
     * Generic field validation utility that checks for non-empty and specific criteria.
     *
     * @param value      the field value to validate
     * @param isCriteria the specific criteria to validate against
     * @return true if both non-empty and criteria validation pass, otherwise false
     */
    public static boolean validateField(String value, boolean isCriteria) {
        return !isNullOrEmpty(value) && isCriteria;
    }   
}

