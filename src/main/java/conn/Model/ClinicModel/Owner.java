package conn.Model.ClinicModel;

import java.util.Set;

/** 방문자 정보.. (동물 주인 정보)*/
public class Owner {
    private int Id;
    private String address; // 주소
    private String city; // 사는 도시
    private String telephone; // 연락처

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
