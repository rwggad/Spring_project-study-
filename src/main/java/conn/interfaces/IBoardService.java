package conn.interfaces;

import conn.Model.Board;

import java.util.List;

public interface IBoardService {
    int Register(Board board);
    List<Board> GetList();
    void Modify(Board Board);
    int Remove(Board Board);
}
