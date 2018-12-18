package conn.Model.ClinicModel;

import conn.Model.ClinicModel.Base.Name;
import conn.Model.ClinicModel.Base.PetType;


public class Pet extends Name {
    private String birthDay; // 동물 생일
    private PetType petType; // 동물 종류
    private Owner Owner; // 주인 정보

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public conn.Model.ClinicModel.Owner getOwner() {
        return Owner;
    }

    public void setOwner(conn.Model.ClinicModel.Owner owner) {
        Owner = owner;
    }
}
