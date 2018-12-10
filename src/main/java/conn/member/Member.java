package conn.member;

import java.util.List;

/**
 * 사용자 정보를 저장하는 class*/
public class Member {
    private String memId; // 사용자 아이디
    private String memPw; // 사용자 패스워드
    private String memMail; // 사용자 이메일
    private List<MemPhone> memPhones; // 사용자 폰번호들..
    private int memAge; // 사용자 나이
    private boolean memAdult; // 사용자가 어른인가?
    private String memGender; // 사용자 성별
    private String[] memFSports; // 사용자가 좋아하는 스포츠

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemPw() {
        return memPw;
    }

    public void setMemPw(String memPw) {
        this.memPw = memPw;
    }

    public String getMemMail() {
        return memMail;
    }

    public void setMemMail(String memMail) {
        this.memMail = memMail;
    }

    public List<MemPhone> getMemPhones() {
        return memPhones;
    }

    public void setMemPhones(List<MemPhone> memPhones) {
        this.memPhones = memPhones;
    }

    public int getMemAge() {
        return memAge;
    }

    public void setMemAge(int memAge) {
        this.memAge = memAge;
    }

    public boolean isMemAdult() {
        return memAdult;
    }

    public void setMemAdult(boolean memAdult) {
        this.memAdult = memAdult;
    }

    public String getMemGender() {
        return memGender;
    }

    public void setMemGender(String memGender) {
        this.memGender = memGender;
    }

    public String[] getMemFSports() {
        return memFSports;
    }

    public void setMemFSports(String[] memFSports) {
        this.memFSports = memFSports;
    }
}
