package com.rwggad.conn.Board;

import com.rwggad.conn.Board.BaordModel.Board;

import java.util.List;
import java.util.Map;

public interface BoardServiceImpl {
    List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;
    void insertBoard(Board board) throws Exception;
}
