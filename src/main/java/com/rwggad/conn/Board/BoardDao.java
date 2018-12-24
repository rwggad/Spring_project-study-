package com.rwggad.conn.Board;

import com.rwggad.conn.AbstractDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardDao extends AbstractDAO {

    public List<Map<String, Object>> selectBoardList(Map<String, Object> map)
            throws Exception{
        return (List<Map<String, Object>>) selectList("board.selectBoardList", map);
    }
}
