package conn.interfaces.Login;

import conn.Model.LoginModel.Member;

public interface IMemberService {
    int Register(Member member);
    int Login(Member member);
    Member Search(Member member);
    int Modify(Member member);
    int Remove(Member member);
}
