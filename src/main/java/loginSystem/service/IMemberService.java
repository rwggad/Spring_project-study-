package loginSystem.service;

import loginSystem.Member;

public interface IMemberService {
    Boolean memberRegister(Member member);
    Member memberLogin(Member member);
    Member memberModify(Member member);
    void memberRemove(Member member);
    Member memberSearch(Member member);
}
