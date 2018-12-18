package conn.interfaces.Board;

import conn.Model.BaordModel.Board;

import java.util.List;

public interface IBoardDao {
    List<Board> selectAll();
    Board select(Board board);
    int insert(Board board);
    int update(Board board);
    int delete(Board board);
}
