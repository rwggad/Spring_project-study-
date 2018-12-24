package com.rwggad.conn.PetClinic.ClinicModel;

import com.rwggad.conn.PetClinic.ClinicModel.Base.Person;

import java.util.List;

public class Owner extends Person{
    private String address;
    private String city;
    private String phoneNUmber;
    private List<Pet> pets;

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

    public String getPhoneNUmber() {
        return phoneNUmber;
    }

    public void setPhoneNUmber(String phoneNUmber) {
        this.phoneNUmber = phoneNUmber;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
