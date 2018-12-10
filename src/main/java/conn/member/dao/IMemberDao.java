package conn.member.dao;

import conn.member.Member;

public interface IMemberDao {
    void memberInsert(Member member);
    Member memberSelect(Member member);
    Member memberUpdate(Member member);
    void memberDelete(Member member);
}
