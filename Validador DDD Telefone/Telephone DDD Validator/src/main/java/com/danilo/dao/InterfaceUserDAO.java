package com.danilo.dao;

import com.danilo.dto.UserDTO;

import java.util.Collection;

public interface InterfaceUserDAO {

    Boolean registerUser(UserDTO userDTO);

    void editUser(UserDTO user);

    void removeCPF(String cpf);

    UserDTO consultCPF(String cpf);

    Collection<UserDTO> listUsers();

}
