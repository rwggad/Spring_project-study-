package conn.interfaces.Board;

import conn.Model.BaordModel.Board;

import java.util.List;

public interface IBoardService {
    int Register(Board board);
    List<Board> GetList();
    int Modify(Board Board);
    int Remove(Board Board);
}
