package com.danilo.service;

import javax.swing.*;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class MessagingInterfaceServiceUser {

    // Método de Mensagem Invalida
    public static void InvalidMessage(String message) {

        JOptionPane.showConfirmDialog(null,
                message,
                "InvalidData | Dados Inválidos",
                INFORMATION_MESSAGE);
    }

    // Método de Mensagem de Opções
    public static String inputMessage() {
        return JOptionPane.showInputDialog(null,
                "Type 1 to register, 2 to consult, 3 to remove, 4 to edit or 5 to exit" + "\n" +
                        "Digite 1 para cadastrar, 2 para consultar, 3 para remover, 4 para editar ou 5 para SAIR",
                "Phone Number Validation Program | Programa de Validação de Número de Telefone",
                INFORMATION_MESSAGE);
    }

    // Método de Mensagens de Inserção de Dados
    public static String inputMessageData() {
        return JOptionPane.showInputDialog(null,
                "Enter the customer data separated by a comma, as in the example: First name, Last name, CPF, Phone number, City, State and CEP" + "\n" +
                        "Digite os dados do cliente separados por vírgula, como no exemplo: Primeiro nome, Último nome, CPF, Número de telefone, Cidade, Estado e CEP" + "\n" +
                        "Exemplo: Danilo, Silva, 12345678910, 11999999999, São Paulo, SP, 12345678",
                "Phone Number Validation Program | Programa de Validação de Número de Telefone",
                INFORMATION_MESSAGE);
    }

    // Método mensagem de CPF
    public static String messageCPF() {
        return JOptionPane.showInputDialog(null,
                "Enter the CPF of the user you want to consult:" + "\n" +
                        " | Digite o CPF do usuário que deseja consultar: ",
                "Consult CPF | Consultar CPF",
                INFORMATION_MESSAGE);
    }

    // Método mensagem de Consulta de Dados
    public static String inputMessageConsultData() {
        return JOptionPane.showInputDialog(null,
                " Type the CPF: " + "\n" +
                        " | Digite o CPF: ",
                "ConsultingData | Consulta de Dados",
                INFORMATION_MESSAGE);
    }



    // Método mensagem de nome
    public static String messageName() {
        return JOptionPane.showInputDialog(null,
                "Enter the Name of the user:" + "\n" +
                        " | Digite o Nome do usuário: ",
                "Message Name | Mensagem de Nome",
                INFORMATION_MESSAGE);
    }

    // Método mensagem de Sobrenome
    public static String messageLastName() {
        return JOptionPane.showInputDialog(null,
                "Enter the Last Name of the user:" + "\n" +
                        " | Digite o Sobrenome do usuário: ",
                "Message E-mail | Mensagem de E-mail",
                INFORMATION_MESSAGE);
    }

    // Método mensagem de Telefone
    public static String messagePhone() {
        return JOptionPane.showInputDialog(null,
                "Enter the Phone of the user:" + "\n" +
                        " | Digite o Telefone do usuário: ",
                "Message Phone | Mensagem de Telefone",
                INFORMATION_MESSAGE);
    }

    // Método mensagem de Endereço
    public static String messageAddress() {
        return JOptionPane.showInputDialog(null,
                "Enter the Address of the user:" + "\n" +
                        " | Digite o Endereço do usuário: ",
                "Message Address | Mensagem de Endereço",
                INFORMATION_MESSAGE);
    }

    // Método mensagem de Cidade
    public static String messageCity() {
        return JOptionPane.showInputDialog(null,
                "Enter the City of the user:" + "\n" +
                        " | Digite a Cidade do usuário: ",
                "Message City | Mensagem de Cidade",
                INFORMATION_MESSAGE);
    }

    // Método mensagem de Estado
    public static String messageState() {
        return JOptionPane.showInputDialog(null,
                "Enter the State of the user:" + "\n" +
                        " | Digite o Estado do usuário: ",
                "Message State | Mensagem de Estado",
                INFORMATION_MESSAGE);
    }

    // Método mensagem de CEP
    public static String messageZipCode() {
        return JOptionPane.showInputDialog(null,
                "Enter the Zip Code of the user:" + "\n" +
                        " | Digite o CEP do usuário: ",
                "Message Zip Code | Mensagem de CEP",
                INFORMATION_MESSAGE);
    }


}
