package org.example;
/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Newton
 */
import java.util.Scanner;
import java.util.regex.Pattern;
public class Exersise27 {
    static String data = "";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the first name: ");
        String fn = scan.nextLine();
        System.out.print("Enter the last name: ");
        String ln = scan.nextLine();
        System.out.print("Enter the ZIP code: ");
        String zip = scan.nextLine();
        System.out.print("Enter the employee ID: ");
        String eID = scan.nextLine();

        validateInput(fn, ln, zip, eID);
    }

    public static void validateInput(String fn, String ln, String zip, String eID) {
        boolean f = validateFirstName(fn);
        boolean l = validateLastName(ln);
        boolean idFlag = validateEmployeeID(eID);
        boolean zipFlag = validateZipCode(zip);
        if (f && l && zipFlag && idFlag) {
            data = "There were no errors found.";
        }
        System.out.println(data);
    }

    public static boolean validateFirstName(String fn) {
        boolean status = true;
        // check length of first name be at least 2 characters
        if (fn.length() < 2) {
            data = data + "The first name must be at least 2 characters long.";
            status = false;
        }
        if (fn.length() == 0) {
            data = data + "The first name must be filled in.";
            status = false;
        }
        return status;
    }

    // This method validate lastName
    public static boolean validateLastName(String ln) {
        boolean status = true;
        // check length of first name be at least 2 characters
        if (ln.length() < 2) {
            data = data + "The last name must be at least 2 characters long.";
            status = false;
        }
        if (ln.length() == 0) {
            System.out.println("The last name must be filled in.");
            status = false;
        }
        return status;
    }

    // This method validate zip
    public static boolean validateZipCode(String zip) {
        boolean status = true;
        try {
            int number = Integer.parseInt(zip);
            if (zip.length() != 5) {
                data = data + "The zipcode must be a 5 digit number.";
                status = false;
            }
        } catch (Exception e) {
            data = data + "The zipcode must be a 5 digit number.";
            status = false;
        }
        return status;
    }

    // This method validate employeeID
    public static boolean validateEmployeeID(String employeeID) {
        String pattern = "[a-zA-Z]{2}[-]{1}[0-9]{4}";// two letters, a hyphen, and four numbers.
        if (!Pattern.matches(pattern, employeeID)) {
            data = data + "The employee ID must be in the format of AA-1234.";
            return false;
        }
        return true;
    }
}