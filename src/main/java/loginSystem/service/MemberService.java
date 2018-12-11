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
        Member isNewMember = dao.memberSelect(member);
        if(isNewMember == null) { // dbMap 에 저장된 회원 정보가 없다는 뜻. (신규 회원)
            dao.memberInsert(member);
            return true;
        }else{ // 이미 등록된 회원
            return false;
        }
    }

    /** 회원 로그인 Service*/
    public Member memberLogin(Member member) {
        System.out.println("memberSearch()");
        Member ckMember = dao.memberSelect(member);
        if(ckMember != null){ // 회원정보가 있고
            if(ckMember.getMemPw().equals(member.getMemPw())){ // 비밀번호가 맞다면..
                return ckMember;
            }else{
                return null;
            }
        } else{
            return null;
        }
    }

    /** 회원 정보 변경 Service*/
    public Member[] memberModify(Member member) {
        System.out.println("memberModify()");

        Member memBef = dao.memberSelect(member);
        Member memAft = dao.memberUpdate(member);

        return new Member[]{memBef, memAft};
    }

    /** 회원 정보 삭제 Service*/
    public Boolean memberRemove(Member member) {
        System.out.println("memberRemove()");
        Member ckMember = dao.memberSelect(member);
        if(ckMember != null){ // 삭제 하려는 회원 정보가 존재 할 때
            dao.memberDelete(member);
            return true;
        }else{ // 존재 하지 않는 회원
            return false;
        }
    }
}
