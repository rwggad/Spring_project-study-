package conn.member.service;

import conn.member.Member;
import conn.member.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


/**
 * xml파일에 명시하지 않고 스프링 컨테이너로 Bean 생성방법 */
//@Service
//@Component
@Repository
public class MemberService implements IMemberService{

    @Autowired
    MemberDao dao;

    /** 회원 등록 Service*/
    public void memberRegister(Member member) {
        System.out.println("memberRegister()");
        dao.memberInsert(member); // dao 에 회원 정보 전달
    }

    /** 회원 검색 Service*/
    public Member memberSearch(String memId, String memPw) {
        System.out.println("memberSearch()");
        Member member = dao.memberSelect(memId, memPw);
        if(member != null){
            return member;
        } else{
            return null;
        }
    }

    /** 회원 정보 변경 Service*/
    public void memberModify() {
        System.out.println("memberModify()");
    }

    /** 회원 정보 삭제 Service*/
    public void memberRemove() {
        System.out.println("memberRemove()");
    }
}
