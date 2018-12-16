package conn.interfaces;

import conn.Model.Board;

import java.sql.SQLException;
import java.util.List;

public interface IBoardDao {
    List<Board> selectAll();
    Board select(Board board);
    int insert(Board board);
    int delete(Board board);
}
