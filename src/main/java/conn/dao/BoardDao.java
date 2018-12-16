package conn.dao;

import conn.Model.Board;
import conn.interfaces.IBoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDao implements IBoardDao {

    private JdbcTemplate template;

    @Autowired
    public BoardDao(DataSource dataSource) {
        this.template = new JdbcTemplate();
        this.template.setDataSource(dataSource);
    }

    public List<Board> selectAll() {
        String SQL = "SELECT * FROM board order BY boardId DESC";
        return template.query(SQL,
                new RowMapper<Board>() {
                    public Board mapRow(ResultSet resultSet, int i) throws SQLException {
                        Board selectBoard = new Board();
                        selectBoard.setBoardId(resultSet.getInt(1));
                        selectBoard.setBoardWriter(resultSet.getString(2));
                        selectBoard.setBoardTitle(resultSet.getString(3));
                        selectBoard.setBoardContent(resultSet.getString(4));
                        selectBoard.setBoardDate(resultSet.getString(5));
                        selectBoard.setBoardCnt(resultSet.getInt(6));
                        selectBoard.setIpAddress(resultSet.getString(7));
                        return selectBoard;
                    }
                });

    }

    public Board select(final Board board) {
        List<Board> boardList = null;
        String SQL = "SELECT * FROM board WHERE boardId = ?";
        boardList = template.query(SQL,
                new PreparedStatementSetter() {
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setInt(1, board.getBoardId());
                    }
                },
                new RowMapper<Board>() {
                    public Board mapRow(ResultSet resultSet, int i) throws SQLException {
                        Board selectBoard = new Board();
                        selectBoard.setBoardId(resultSet.getInt(1));
                        selectBoard.setBoardWriter(resultSet.getString(2));
                        selectBoard.setBoardTitle(resultSet.getString(3));
                        selectBoard.setBoardContent(resultSet.getString(4));
                        selectBoard.setBoardDate(resultSet.getString(5));
                        selectBoard.setBoardCnt(resultSet.getInt(6));
                        selectBoard.setIpAddress(resultSet.getString(7));
                        return selectBoard;
                    }
                });
        if(boardList.isEmpty())
            return null;
        else
            return boardList.get(0);
    }

    public int insert(final Board board) {
        final String sql = "INSERT INTO board VALUES(?, ?, ?, ?, ?, ?, ?)";
        // 다음 게시물의 고유 번호 들고오기
        List<Board> boardList = selectAll();
        int nextId = 0;
        if (!boardList.isEmpty()) {
            nextId = boardList.get(0).getBoardId() + 1;
        }
        final int boardId = nextId;
        return template.update(sql,
                new PreparedStatementSetter() {
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setInt(1, boardId);
                        preparedStatement.setString(2, board.getBoardWriter());
                        preparedStatement.setString(3, board.getBoardTitle());
                        preparedStatement.setString(4, board.getBoardContent());
                        preparedStatement.setString(5, board.getBoardDate());
                        preparedStatement.setInt(6, 0);
                        preparedStatement.setString(7, "null");
                    }
                });

    }

    public int delete(Board board) {
        return 0;
    }
}
