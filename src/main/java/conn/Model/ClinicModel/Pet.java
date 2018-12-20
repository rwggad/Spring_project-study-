package conn.Model.ClinicModel;

import conn.Model.ClinicModel.Base.Name;
import conn.Model.ClinicModel.Base.PetType;
import conn.Model.ClinicModel.Owner;


public class Pet extends Name {
    private String birthDay; // 동물 생일
    private PetType petType; // 동물 종류
    private Owner owner; // 주인 정보

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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
