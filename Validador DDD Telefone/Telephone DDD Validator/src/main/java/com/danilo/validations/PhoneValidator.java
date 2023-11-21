package com.danilo.validations;

import com.danilo.enums.CodeDDDArea;

import java.util.Arrays;

public class PhoneValidator {
    public static boolean isValid(String phone) {

        if (!checkCharacters(phone)) {
            return false;
        }

        // Verifica se o número de telefone tem 10 ou 11 dígitos
        int ddd = phone.length() == 11  ? Integer.parseInt(phone.substring(0, 2)) :
                Integer.parseInt(phone.substring(2, 3));

        // Verifica se o DDD é válido
        CodeDDDArea dddCodeArea = Arrays.stream(CodeDDDArea.values())
                .filter(enumCodeDDDArea -> Arrays.asList(enumCodeDDDArea.getDDD()).contains(ddd))
                .findFirst()
                .orElse(null);
        return dddCodeArea != null;
    }

    // -------------------------------------------   CHECK CHARACTERS   ------------------------------------------------
    private static boolean checkCharacters(String phone) {

        // Verifica se o número de telefone tem 10 ou 11 dígitos
        if (phone.length() != 11 || phone.length() != 10 || phone.charAt(0) == '0') {
            return false;
        }

        // Caracteres não aceitos
        String charactersNotAccepted = "^\\d+$";
        if (phone.matches(charactersNotAccepted)) {
            return false;
        }

        // Caso o número comece com 9, mas não tenha 11 dígitos, retorna false
        String starsWithNineAfterDDD = "^(?!9.{2}).{11}$\n";
        if (phone.matches(starsWithNineAfterDDD)) {
            return false;
        }

        String areAllTheSameCharacters = "^(\\d)\\1*$";
        return !phone.matches(areAllTheSameCharacters);
    }
}
