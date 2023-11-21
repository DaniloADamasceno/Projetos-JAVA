package com.danilo.entities;

public class User {
    private String name;
    private String phone;
    private String address;
    private String city;
    private String state;
    private Integer zipCode;
    private String CPF;

    // ---------------------------------------------   CONSTRUCTOR   ---------------------------------------------------
    public User(String name, String phone, String address, String city, String state, Integer zipCode, String CPF) {
        this.name = String.valueOf(name.trim());
        this.phone = String.valueOf(phone.trim());
        this.address = String.valueOf(address.trim());
        this.city = String.valueOf(city.trim());
        this.state = String.valueOf(state.trim());
        this.zipCode = zipCode;
        this.CPF = String.valueOf(CPF.trim());
    }

    // --------------------------------------------  GETTERS/SETTERS   -------------------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    // --------------------------------------------- HASHCODE/EQUALS ---------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        return getCPF().equals(user.getCPF());
    }

    @Override
    public int hashCode() {
        return getCPF().hashCode();
    }

    // ---------------------------------------------   TOSTRING   ------------------------------------------------------

    @Override
    public String toString() {
        return "User | Usuário {" +
                "Name | Nome ='" + name + '\'' +
                ", Phone | Telefone ='" + phone + '\'' +
                ", Address | Endereço ='" + address + '\'' +
                ", City | Cidade ='" + city + '\'' +
                ", State | Estado ='" + state + '\'' +
                ", ZipCode | Código Postal =" + zipCode +
                ", CPF='" + CPF + '\'' +
                '}';
    }
}

