package com.danilo.service;

import com.danilo.dao.InterfaceUserDAO;
import com.danilo.dao.UserMapDao;
import com.danilo.dto.UserDTO;

import javax.swing.*;
import java.util.Set;

public class UserRegistrationService {

    public static InterfaceUserDAO InterfaceUserDAORegistrationService;


    public static void run() {
        InterfaceUserDAORegistrationService = new UserMapDao();

        String optionUser = MessagingInterfaceServiceUser.inputMessage();

        while (!validOption(optionUser)) {

            // Opção de Saída
            if (exitUserOption(optionUser)) {
                exitSystem();
            }

            optionUser = MessagingInterfaceServiceUser.inputMessage();
        }

        // Opção de Registro
        while (validOption(optionUser)){

            if (exitUserOption(optionUser)) {
                exitSystem();
            } else if (registrationUserOption(optionUser)) {

                String dataUser = MessagingInterfaceServiceUser.inputMessageData();
                registerUser(dataUser);
            } else if (consultUserOption(optionUser)) {
                 String dataUserConsult = MessagingInterfaceServiceUser.inputMessageConsultData();
                 consultUser(dataUserConsult);
            } else if (removeUserOption(optionUser)) {
                String dataUserConsult = MessagingInterfaceServiceUser.inputMessageConsultData();
                removeUser(dataUserConsult);
            }
            optionUser = MessagingInterfaceServiceUser.inputMessage();
        }
    }
    // ? ----------------------------------   Método de Registro de Usuário   ------------------------------------------
    private static void registerUser(String dataUser) {

        String[] dataUserSplit = dataUser.split(",");

        String name = dataUserSplit[0];
        String lastName = dataUserSplit[1];
        String cpf = dataUserSplit[2];
        String phone = dataUserSplit[3];
        String address = dataUserSplit[4];
        String city = dataUserSplit[5];
        String state = dataUserSplit[6];
        String zipCode = dataUserSplit[7];

        if (name.isEmpty() || lastName.isEmpty() || cpf.isEmpty() || phone.isEmpty() ||
                address.isEmpty() || city.isEmpty() || state.isEmpty() || zipCode.isEmpty()) {

            MessagingInterfaceServiceUser.InvalidMessage("Invalid data, please try again ! | Dados inválidos, por favor tente novamente !");
        } else {
            int convertPhone = Integer.parseInt(phone);
            int convertZipCode = Integer.parseInt(zipCode);

            UserDTO user = new UserDTO(name, lastName, cpf, convertPhone, address, city, state, convertZipCode);

            InterfaceUserDAORegistrationService.registerUser(user);

            JOptionPane.showMessageDialog(null,
                    "Usuário cadastrado com sucesso ! | User registered successfully ! --> " + user.toString(),
                    "Sucesso | Usuário cadastrado",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }


    //? ----------------------------------   Método de Consulta de Usuário   -------------------------------------------

    private static void consultUser(String dataUserConsult) {
        String cpf = MessagingInterfaceServiceUser.messageCPF();
        UserDTO user = InterfaceUserDAORegistrationService.consultCPF(cpf);

        if (user == null) {
            JOptionPane.showMessageDialog(null,
                    "Usuário não encontrado ! | User not found !",
                    "Erro | Usuário não encontrado",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Usuário encontrado ! | User found ! --> " + user.toString(),
                    "Sucesso | Usuário encontrado",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //? ------------------------------------ Método de Remoção de Usuário   --------------------------------------------

    public static void removeUser(String cpf) {
        UserDTO userRemover = InterfaceUserDAORegistrationService.consultCPF(cpf);

        if (userRemover == null) {
            JOptionPane.showMessageDialog(null,
                    "Usuário não encontrado ! | User not found !",
                    "Erro | Usuário não encontrado",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            InterfaceUserDAORegistrationService.removeCPF(cpf);
            JOptionPane.showMessageDialog(null,
                    "Usuário removido com sucesso ! | User removed successfully ! --> CPF: " + cpf,
                    "Sucesso | Usuário removido",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // ? ----------------------------------   Método de Registro de Usuário   ------------------------------------------

    private static void editUser() {
        String consultCPF = MessagingInterfaceServiceUser.messageCPF();
        UserDTO userEdit = InterfaceUserDAORegistrationService.consultCPF(consultCPF);

        if (userEdit == null) {
            JOptionPane.showMessageDialog(null,
                    "Usuário não encontrado !",
                    "Erro | Usuário não encontrado",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            String name = MessagingInterfaceServiceUser.messageName();
            String lastName = MessagingInterfaceServiceUser.messageLastName();
            String phone = MessagingInterfaceServiceUser.messagePhone();
            String address = MessagingInterfaceServiceUser.messageAddress();
            String city = MessagingInterfaceServiceUser.messageCity();
            String state = MessagingInterfaceServiceUser.messageState();
            String zipCode = MessagingInterfaceServiceUser.messageZipCode();

            int convertPhone = Integer.parseInt(phone);
            int convertZipCode = Integer.parseInt(zipCode);

            userEdit.setName(name);
            userEdit.setLastName(lastName);
            userEdit.setPhone(convertPhone);
//            userEdit.getAddress(address);
//            userEdit.getCity(city);
//            userEdit.getState(state);
//            userEdit.getZipCode(zipCode);



            InterfaceUserDAORegistrationService.editUser(userEdit);

            JOptionPane.showMessageDialog(null,
                    "Usuário editado com sucesso !",
                    "Sucesso | Usuário editado",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }


    //! ----------------------------------   Método de Saída do Sistema   ----------------------------------------------
    private static void exitSystem() {
        JOptionPane.showMessageDialog(null,
                "Tanks for using our system ! | Obrigado por utilizar o sistema !",
                "Exit | Sair",
                JOptionPane.INFORMATION_MESSAGE);
    }


    //! -------------------------------------   Validadores de Opções de Menu   ----------------------------------------

    // Validador de opções de menu
    private static boolean validOption(String optionUser) {
        return Set.of("1", "2", "3", "4", "5").contains(optionUser);
    }

    // Validador de Opção de Registro
    private static boolean registrationUserOption(String optionUser) {
        return optionUser.equals("1");
    }

    // Validador de Opção de Consulta
    private static boolean consultUserOption(String optionUser) {
        return optionUser.equals("2");
    }

    // Validador de opção de Remoção
    private static boolean removeUserOption(String optionUser) {
        return optionUser.equals("3");
    }

    // Validador de Opção de Edição
    private static boolean editUserOption(String optionUser) {
        return optionUser.equals("4");
    }

    // Validador de Opção de Saída
    private static boolean exitUserOption(String optionUser) {
        return optionUser.equals("5");
    }
}
