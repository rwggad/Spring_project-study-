package conn.member.dao;

import conn.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * xml파일에 명시하지 않고 스프링 컨테이너로 Bean 생성방법 */
//@Service
//@Component
@Repository
public class MemberDao implements IMemberDao{

    /**
     * DB 대체로 Map 사용*/
    private HashMap<String, Member> dbMap;

    public MemberDao() {
        this.dbMap = new HashMap<String, Member>();
    }

    /**
     * db 대체인 map에 회원 정보 삽입*/
    public void memberInsert(String memId, String memPw, String memMail, String memPhone1, String memPhone2, String memPhone3) {
        Member newMember = new Member();
        newMember.setMemId(memId);
        newMember.setMemPw(memPw);
        newMember.setMemMail(memMail);
        newMember.setMemPhone1(memPhone1);
        newMember.setMemPhone2(memPhone2);
        newMember.setMemPhone3(memPhone3);
        this.dbMap.put(memId, newMember);

        // 멤버 정보 전체 출력
        Set<String> keys = dbMap.keySet();
        Iterator<String> iterator = keys.iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            Member mem = dbMap.get(key);
            System.out.print("memberId:" + mem.getMemId() + "\t");
            System.out.print("|memberPw:" + mem.getMemPw() + "\t");
            System.out.print("|memberMail:" + mem.getMemMail() + "\t");
            System.out.print("|memberPhone:" + mem.getMemPhone1() + " - " +
                    mem.getMemPhone2() + " - " +
                    mem.getMemPhone3() + "\n");
        }
    }

    /**
     * db 대체인 map에 회원 정보 선택*/
    public Member memberSelect(String memId, String memPw) {
        Member member = this.dbMap.get(memId);

        return member;
    }

    public void memberUpdate() {

    }

    public void memberDelete() {

    }
}
