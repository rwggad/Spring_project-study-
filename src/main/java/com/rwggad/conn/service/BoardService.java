package com.rwggad.conn.service;

import com.rwggad.conn.Model.BaordModel.Board;
import com.rwggad.conn.dao.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    @Autowired
    private BoardDao boardDao;

    public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
        return this.boardDao.selectBoardList(map);
    }
}
