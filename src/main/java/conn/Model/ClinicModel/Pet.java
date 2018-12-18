package conn.Model.ClinicModel;

/** Pet 정보 */
public class Pet {
    private String birthDate; // 생일
    private String type; // 동물 타입
    private Owner owner; // 동물 주인

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
