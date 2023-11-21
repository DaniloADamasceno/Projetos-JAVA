package com.danilo.dao;

import com.danilo.dto.UserDTO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserMapDao implements InterfaceUserDAO {
    private Map<String, UserDTO> userMaps;   // A Chave é o CPF e o valor é o usuário

    // ----------------------------------------   CONSTRUCTOR   --------------------------------------------------------
    public UserMapDao() {
        this.userMaps = new HashMap<>();
    }

    // ----------------------------------------   METHODS   ------------------------------------------------------------
    @Override
    public Boolean registerUser(UserDTO userDTO) {
        if (userMaps.containsKey(userDTO.getCPF()))
            return false;

        this.userMaps.put(userDTO.getCPF(), userDTO);
        return true;
    }

    // EDITAR USUARIO
    @Override
    public void editUser(UserDTO userDTO) {
        UserDTO userEdit = this.userMaps.get(userDTO.getCPF());

        if (userEdit != null) {
            userEdit.setName(userDTO.getName());
            userEdit.setLastName(userDTO.getLastName());
            userEdit.setCPF(userDTO.getCPF());
            userEdit.setPhone(userDTO.getPhone());
            userEdit.setAddress(userDTO.getAddress());
            userEdit.setCity(userDTO.getCity());
            userEdit.setState(userDTO.getState());
            userEdit.setZipCode(userDTO.getZipCode());
        }
    }

    // REMOVER CPF
    @Override
    public void removeCPF(String cpf) {
        UserDTO consultCPF = this.userMaps.get(cpf);

        if (consultCPF != null) {
            this.userMaps.remove(cpf);
        }
    }

    // CONSULTAR CPF
    @Override
    public UserDTO consultCPF(String cpf) {
        return this.userMaps.get(cpf);

    }

    // LISTAR USUARIOS
    @Override
    public Collection<UserDTO> listUsers() {
        return this.userMaps.values();
    }

    // --------------------------------------------- HASHCODE/EQUALS ---------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserMapDao that)) return false;

        return Objects.equals(userMaps, that.userMaps);
    }

    @Override
    public int hashCode() {
        return userMaps != null ? userMaps.hashCode() : 0;
    }
}
