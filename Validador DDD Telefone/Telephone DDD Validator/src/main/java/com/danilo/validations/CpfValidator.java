package com.danilo.validations;

import br.com.caelum.stella.validation.CPFValidator;

public class CpfValidator {
    public static boolean isCpfValid(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        return cpfValidator.invalidMessagesFor(cpf).isEmpty();
    }
}
