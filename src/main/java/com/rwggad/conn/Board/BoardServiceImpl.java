package com.rwggad.conn.Board;

import java.util.List;
import java.util.Map;

public interface BoardServiceImpl {
    List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;
}
