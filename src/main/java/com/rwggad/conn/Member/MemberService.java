package com.rwggad.conn.Member;

import com.rwggad.conn.Member.LoginModel.Member;
import com.rwggad.conn.Member.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberService {

    @Autowired
    MemberDao dao;

    /** 회원 등록*/
    public int Register(Member member) {
        // id가 중복되어 있다면(이미 db 안에 있다면) -1 return
        return dao.insert(member) > 0 ? 1 : -1;
    }

    /** 회원 로그인*/
    public int Login(Member member){
        Member tryMember = dao.select(member);
        // db 내에 아이디 존재하면서 사용자가 입력한 비밀번호와 db 비밀번호가 같을 때
        if(tryMember != null) {
            if(tryMember.getMemPw().equals(member.getMemPw())){
                return 1;
            }
        }
        return -1;
    }

    /** 회원 검색 */
    public Member Search(Member member) {
        return  dao.select(member);
    }

    /** 회원 정보 수정*/
    public int Modify(Member member) {
        dao.update(member);
        return 1;
    }

    /** 회원 삭제*/
    public int Remove(Member member) {
        Member tryMember = dao.select(member);
        if(tryMember != null){ // db에 사용자 정보가 존재하고
            if(tryMember.getMemPw().equals(member.getMemPw())){ // db PW 값과 사용자가  입력한 PW 값이 같을 경우
                dao.delete(member); // db 에서 삭제
                return 1;
            }
        }
        return -1;
    }
}
