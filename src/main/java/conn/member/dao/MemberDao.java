package conn.member.dao;

import conn.member.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

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

    /** db 대체인 map 에 회원 정보 삽입*/
    public void memberInsert(Member member) {
        this.dbMap.put(member.getMemId(), member); // 회원 등록
    }

    /**
     * db 대체인 map 에 회원 정보 선택*/
    public Member memberSelect(String memId) {
        if(!this.dbMap.containsKey(memId)) { // 회원 정보가 없다면
            return null;
        }else{ // 회원 정보가 있다면
            return this.dbMap.get(memId);
        }
    }

    public void memberUpdate(Member member) {

    }

    public void memberDelete(String memId) {
        this.dbMap.remove(memId); // 회원 정보 삭제
    }
}
