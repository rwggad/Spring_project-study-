package conn.dao;

import conn.Model.Member;
import conn.interfaces.IMemberDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * xml파일에 명시하지 않고 스프링 컨테이너로 Bean 생성방법
 */
//@Service
//@Component
@Repository
public class MemberDao implements IMemberDao {
    /**
     * 오라클과 연결 설정 (드라이버 연결)
     */
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String id = "root";
    private String pw = "root";
    /**
     * jdbc 통신을 할때, 드라이버 연결 통신 해제 기능을 알아서 해주는 spring에서 제공하는 모듈
     * (원래는 개발자가 직접 일일히 해서 중복코드도 많고 번거러웠다)
     *      private Connection conn = null;
     *     private PreparedStatement pstmt;
     *     private ResultSet rs;
     *     ..
     *
     *          try {
     *                 Class.forName(driver);
     *                 this.conn = DriverManager.getConnection(url, id, pw);
     *                 pstmt = conn.prepareStatement("INSERT INTO Member VALUES (?, ?, ?)");
     *                 ....
     *
     *                 return pstmt.executeUpdate();
     *             } catch (Exception e) {
     *                 e.printStackTrace();
     *             } finally {
     *                 try {
     *                     pstmt.close();
     *                 } catch (Exception e) {
     *                     e.printStackTrace();
     *                 }
     *             }
     *
     *  DriverManagerDataSource 는 Spring꺼 사용.. (c3p0 제공하는 DriverManagerDataSource 도 있음)
     *     */
    private DriverManagerDataSource dataSource; //
    private JdbcTemplate template;
    public MemberDao(){ // Dao 객체가 생성될 때 딱한번만 사용한다.
        // c3p0
        /*dataSource = new DriverManagerDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(id);
        dataSource.setPassword(pw);*/
        // spring
        dataSource = new org.springframework.jdbc.datasource.DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(id);
        dataSource.setPassword(pw);

        template = new JdbcTemplate();
        template.setDataSource(dataSource); // dataBase에 관련된 값들은 template에 저장
    }

    public Member select(final Member member) {
        // 익명 클래스 구현 으로 가져온다.
        String sql = "SELECT * FROM Member WHERE memId = ?";
        List<Member> members = null;
        members = template.query(sql,
                new PreparedStatementSetter() { // '?' 지정
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, member.getMemId());
            }},
                new RowMapper<Member>() { // 데이터 맵핑(가져오기)
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                Member selectMember = new Member();
                selectMember.setMemId(rs.getString("memId"));
                selectMember.setMemPw(rs.getString("memPw"));
                selectMember.setMemMail(rs.getString("memMail"));
                return selectMember;
            }
        });
        if(members.isEmpty()) //  없을 경우 null 을 반환한다.
            return null;
        else
            return members.get(0); // 있으면 첫번째 회원정보 return
    }

    public int insert(final Member member) {
        if(select(member) == null){ // 삽입하려는 아이디가 db에 없을 때 삽입
            String sql = "INSERT INTO Member VALUES (?, ?, ?)";
            return template.update(sql, new PreparedStatementSetter() {
                public void setValues(PreparedStatement preparedStatement) throws SQLException {
                    preparedStatement.setString(1, member.getMemId());
                    preparedStatement.setString(2, member.getMemPw());
                    preparedStatement.setString(3, member.getMemMail());
                }
            });
        }else{
            return -1; // 이미 있는 아이디 이다.
        }
    }

    public int update(final Member member) {
        String sql = "UPDATE Member SET memId = ?, memPw = ?, memMail = ? WHERE memId = ?";
        return template.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, member.getMemId());
                preparedStatement.setString(2, member.getMemPw());
                preparedStatement.setString(3, member.getMemMail());
                preparedStatement.setString(4, member.getMemId());
            }
        });
    }

    public int delete(final Member member) {
        String sql = "DELETE FROM Member WHERE memId = ?";
        return template.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, member.getMemId());
            }
        });
    }
}
