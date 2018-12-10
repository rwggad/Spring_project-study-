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

    public void memberRegister(String memId, String memPw, String memMail, String memPhone1, String memPhone2, String memPhone3) {
        System.out.println("memberRegister()");
        System.out.println("memId : " + memId);
        System.out.println("memPw : " + memPw);
        System.out.println("memMail : " + memMail);
        System.out.println("memPhone : " + memPhone1 + " - " + memPhone2 + " - " + memPhone3);

        dao.memberInsert(memId, memPw, memMail, memPhone1, memPhone2, memPhone3);
    }

    public Member memberSearch(String memId, String memPw) {
        System.out.println("memberSearch()");
        System.out.println("memId : " + memId);
        System.out.println("memPw : " + memPw);

        return dao.memberSelect(memId, memPw);
    }

    public void memberModify() {

    }

    public void memberRemove() {

    }
}
