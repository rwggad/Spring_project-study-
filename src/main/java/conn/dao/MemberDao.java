package conn.dao;

import conn.Model.Member;
import conn.interfaces.IMemberDao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.HashMap;


/**
 * xml파일에 명시하지 않고 스프링 컨테이너로 Bean 생성방법
 */
//@Service
//@Component
@Repository
public class MemberDao implements IMemberDao {

    /**
     * HashMap -> JDBC 변경한다 */

    /**
     * 오라클과 연결 설정 (드라이버 연결)
     */
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String id = "root";
    private String pw = "root";
    private Connection conn = null;
    private PreparedStatement pstmt;
    private ResultSet resultSet;

    /*
    private HashMap<String, Member> memberdb;
    public MemberDao() {
        this.memberdb = new HashMap<String, Member>();
    }
    */
    public Member select(Member member) {
        Member selectMember = null;
        try {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url, id, pw);

            pstmt = conn.prepareStatement("SELECT * FROM Member WHERE memId = ?");
            pstmt.setString(1, member.getMemId());
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) { // 찾으려는 아이디 값이 있을 경우
                selectMember = new Member();
                selectMember.setMemId(resultSet.getString(1));
                selectMember.setMemPw(resultSet.getString(2));
                selectMember.setMemMail(resultSet.getString(3));
            }
            return selectMember;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return selectMember; // 없을 경우 null 을 반환한다.
    }

    public int insert(Member member) {
        if (select(member) == null) { // 삽입하려는 아이디가 db에 없을 때 삽입
            try {
                Class.forName(driver);
                this.conn = DriverManager.getConnection(url, id, pw);

                pstmt = conn.prepareStatement("INSERT INTO Member VALUES (?, ?, ?)");
                pstmt.setString(1, member.getMemId());
                pstmt.setString(2, member.getMemPw());
                pstmt.setString(3, member.getMemMail());
                return pstmt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    pstmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return -1; // 이미 있는 아이디 이다.
    }

    public int update(Member member) {
        try {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url, id, pw);

            pstmt = conn.prepareStatement("UPDATE Member SET memId = ?, memPw = ?, memMail = ? WHERE memId = ?");
            pstmt.setString(1, member.getMemId());
            pstmt.setString(2, member.getMemPw());
            pstmt.setString(3, member.getMemMail());
            pstmt.setString(4, member.getMemId());
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1; // error
    }

    public int delete(Member member) {
        try {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url, id, pw);

            pstmt = conn.prepareStatement("DELETE FROM Member WHERE memId = ?");
            pstmt.setString(1, member.getMemId());
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1; //error
    }
}
