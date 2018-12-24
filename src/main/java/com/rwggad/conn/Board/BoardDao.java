package com.rwggad.conn.Board;

import com.rwggad.conn.AbstractDAO;
import com.rwggad.conn.Board.BaordModel.Board;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardDao extends AbstractDAO {

    public List<Map<String, Object>> selectBoardList(Map<String, Object> map)
            throws Exception{
        return (List<Map<String, Object>>) selectList("board.selectBoardList", map);
    }

    public void insertBoard(Board board) throws Exception{
        insert("board.insertBoard", board);
    }
}
