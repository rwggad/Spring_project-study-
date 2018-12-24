package conn.Model.ClinicModel.Base;

public class PetType extends Id{
    private String name; // 동물 타입

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
