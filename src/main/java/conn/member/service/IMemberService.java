package conn.member.service;

import conn.member.Member;

public interface IMemberService {
    void memberRegister(Member member);
    Member memberSearch(String memId, String memPw);
    void memberModify();
    void memberRemove();
}
