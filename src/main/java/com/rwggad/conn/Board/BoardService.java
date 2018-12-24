package com.rwggad.conn.Board;

import com.rwggad.conn.Board.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardService implements BoardServiceImpl{

    @Autowired
    private BoardDao boardDao;

    public List<Map<String, Object>> selectBoardList(Map<String, Object> map)
            throws Exception {
        return this.boardDao.selectBoardList(map);
    }
}
