package conn.member.service;

import conn.member.Member;

public interface IMemberService {
    Boolean memberRegister(Member member);
    Member memberLogin(Member member);
    Member[] memberModify(Member member);
    Boolean memberRemove(Member member);
}
