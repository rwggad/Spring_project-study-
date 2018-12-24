package com.rwggad.conn.dao;

import com.rwggad.conn.Model.BaordModel.Board;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDao extends AbstractDAO{

    public List<Map<String, Object>> selectBoardList(Map<String, Object> map){
        return (List<Map<String, Object>>) selectList("board.selectBoardList", map);
    }
}
