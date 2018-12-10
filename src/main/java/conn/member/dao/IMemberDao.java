package conn.member.dao;

import conn.member.Member;

public interface IMemberDao {
    void memberInsert(Member member);
    Member memberSelect(String memId);
    void memberUpdate(Member member);
    void memberDelete(String memId);
}
