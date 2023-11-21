package com.danilo.dto;

import lombok.AccessLevel;
import lombok.Setter;

public class UserDTO {

    private String name;
    private String lastName;

    @Setter(value = AccessLevel.NONE)
    private String CPF;
    private Number phone;
    private String address;
    private String city;
    private String state;
    private Number zipCode;

    // ----------------------------------------   CONSTRUCTOR   --------------------------------------------------------
    public UserDTO(String name, String lastName, String CPF, Number phone, String address, String city, String state, Number zipCode) {
        this.name = name;
        this.lastName = lastName;
        this.CPF = CPF;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // ----------------------------------------   GETTERS AND SETTERS   ------------------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Number getPhone() {
        return phone;
    }

    public void setPhone(Number phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Number getZipCode() {
        return zipCode;
    }

    public void setZipCode(Number zipCode) {
        this.zipCode = zipCode;
    }

    // --------------------------------------------- HASHCODE/EQUALS ---------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO userDTO)) return false;

        return getCPF().equals(userDTO.getCPF());
    }

    @Override
    public int hashCode() {
        return getCPF().hashCode();
    }

    // --------------------------------------------  TO STRING   -------------------------------------------------------

    @Override
    public String toString() {
        return "UserDTO | UsuarioDTO{" +
                "Name | Nome='" + name + '\'' +
                ", lastName | Ultimo Nome='" + lastName + '\'' +
                ", CPF='" + CPF + '\'' +
                ", Phone | Telefone=" + phone +
                ", address | Endereço='" + address + '\'' +
                ", City | Cidade='" + city + '\'' +
                ", State | Estado='" + state + '\'' +
                ", ZipCode | Código Postal=" + zipCode +
                '}';
    }
}
