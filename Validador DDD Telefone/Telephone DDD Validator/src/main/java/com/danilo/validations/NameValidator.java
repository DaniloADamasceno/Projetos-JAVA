package com.danilo.validations;

import java.util.regex.Pattern;

public class NameValidator {
    private static boolean isNameValid(String name, String lastName) {
        if (!(name != null || lastName != null)) return false;
        return matchingName(name, lastName);
    }


    // -------------------------------------------   MATCHING NAMEs  ---------------------------------------------------

    public static boolean matchingName(String firstName, String lastName){
        Pattern pattern = Pattern.compile("^(?U)[\\p{L}'`\\-]+(?: [\\p{L}'`\\-]+)*$");
        return pattern.matcher(firstName).matches()
                && pattern.matcher(lastName).matches();
    }
}