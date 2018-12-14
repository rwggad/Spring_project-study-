package conn.dao;

import conn.Model.Member;
import conn.interfaces.IMemberDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MemberDao implements IMemberDao {

    private HashMap<String, Member> memberdb;

    public MemberDao() {
        this.memberdb = new HashMap<String, Member>();
    }

    public Member select(Member member) {
        if(memberdb.containsKey(member.getMemId())){ // 찾으려는 아이디 값이 있을 경우
            return this.memberdb.get(member.getMemId());
        }else{ // 없을 경우
            return null;
        }
    }

    public int insert(Member member) {
        if(!memberdb.containsValue(member.getMemId())){ // 삽입하려는 아이디가 db에 없을 때 삽입
            this.memberdb.put(member.getMemId(), member);
            return 1;
        }else{ // 이미 있는 아이디일 경우
            return -1;
        }
    }

    public int update(Member member) {
        this.memberdb.put(member.getMemId(),member);
        return 1;
    }

    public int delete(Member member) {
        this.memberdb.remove(member.getMemId());
        return 1;
    }
}
