package conn.member.service;

import conn.member.Member;

public interface IMemberService {
    Boolean memberRegister(Member member);
    Member memberLogin(String memId, String memPw);
    void memberModify(Member member);
    Boolean memberRemove(String memId);
}
