package com.rwggad.conn.Model.ClinicModel;

import com.rwggad.conn.Model.ClinicModel.Base.Id;

public class Visits extends Id {
    private int petId;
    private String date;
    private String description;

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
