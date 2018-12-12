package loginSystem.service;

import loginSystem.Member;
import loginSystem.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * xml파일에 명시하지 않고 스프링 컨테이너로 Bean 생성방법 */
//@Service
//@Component
@Repository
public class MemberService implements IMemberService{

    @Autowired
    MemberDao dao;

    /** 회원 등록 Service*/
    public Boolean memberRegister(Member member) {
        System.out.println("memberRegister()");
        Member mem = dao.memberSelect(member);
        if(mem == null) { // dbMap 에 저장된 회원 정보가 없다는 뜻. (신규 회원)
            dao.memberInsert(member);
            return true;
        }else{ // 이미 등록된 회원
            return false;
        }
    }

    /** 회원 로그인 Service*/
    public Member memberLogin(Member member) {
        System.out.println("memberSearch()");
        Member mem = dao.memberSelect(member);
        if(mem != null){ // 회원정보가 있고
            if(mem.getMemPw().equals(member.getMemPw())){ // 비밀번호가 맞다면..
                return mem;
            }else{
                return null;
            }
        } else{
            return null;
        }
    }

    /** 회원 정보 변경 Service*/
    public Member memberModify(Member member) {
        System.out.println("memberModify()");
        return  dao.memberUpdate(member);
    }

    /** 회원 정보 삭제 Service*/
    public void memberRemove(Member member) {
        System.out.println("memberRemove()");
        dao.memberDelete(member);
    }

    /** 회원 정보 검색*/
    public Member memberSearch(Member member){
        return dao.memberSelect(member);
    }
}
