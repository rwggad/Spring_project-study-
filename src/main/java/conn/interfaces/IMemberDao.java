package conn.interfaces;

import conn.Model.Member;

public interface IMemberDao {
    Member select(Member member);
    int insert(Member member);
    int update(Member member);
    int delete(Member member);
}
