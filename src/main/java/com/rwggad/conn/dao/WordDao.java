package com.rwggad.conn.dao;

import com.rwggad.conn.Model.WordModel.WordSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * xml파일에 명시하지 않고 스프링 컨테이너로 Bean 생성방법 */
//@Service
//@Component
@Repository
public class WordDao {
    /**
     * Spring 설정 파일을 이용한 DataSource*/
    private JdbcTemplate template;

    @Autowired
    public WordDao(DataSource dataSource){
        this.template = new JdbcTemplate();
        this.template.setDataSource(dataSource);
    }

    public List<WordSet> selectAll(){ // 저장된 단어 전부 출력
        String sql = "SELECT * FROM wordSet";
        return template.query(sql, new RowMapper<WordSet>() {
            public WordSet mapRow(ResultSet rs, int i) throws SQLException {
                WordSet selectWord = new WordSet();
                selectWord.setInsertUser(rs.getString(1));
                selectWord.setWordKey(rs.getString(2));
                selectWord.setWordValue(rs.getString(3));
                return selectWord;
            }
        });
    }

    public WordSet select(final String wordKey) {
        String sql = "SELECT * FROM wordSet WHERE wordKey = ?";
        List<WordSet> words = null;
        words = template.query(sql,
                new PreparedStatementSetter() {
                    public void setValues(PreparedStatement pstmt) throws SQLException {
                        pstmt.setString(1, wordKey);
                    }
                },
                new RowMapper<WordSet>() {
                    public WordSet mapRow(ResultSet rs, int rowNum) throws SQLException {
                        WordSet selectWord = new WordSet();
                        selectWord.setInsertUser(rs.getString(1));
                        selectWord.setWordKey(rs.getString(2));
                        selectWord.setWordValue(rs.getString(3));
                        return selectWord;
                    }
                });
        if(words.isEmpty()){ // 없으면 null
            return null;
        }else{ // select 하려는 단어가 있을 때 반환
            return words.get(0);
        }
    }


    public int insert(final WordSet wordSet) {
        if(select(wordSet.getWordKey()) == null){
            String sql = "INSERT INTO wordSet VALUES(?, ?, ?)";
            return template.update(sql, new PreparedStatementSetter() {
                public void setValues(PreparedStatement preparedStatement) throws SQLException {
                    preparedStatement.setString(1, wordSet.getInsertUser());
                    preparedStatement.setString(2, wordSet.getWordKey());
                    preparedStatement.setString(3, wordSet.getWordValue());
                }
            });
        }else{
            return -1;
        }
    }

    public int update(final WordSet wordSet) {
        String sql = "UPDATE wordSet SET insertUser = ?, wordKey = ?, wordValue =? WHERE wordKey = ?";
        return template.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, wordSet.getInsertUser());
                preparedStatement.setString(2, wordSet.getWordKey());
                preparedStatement.setString(3, wordSet.getWordValue());
            }
        });
    }

    public int delete(final WordSet wordSet) {
        String sql = "DELETE FROM wordSet WHERE wordKey = ?";
        return template.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,wordSet.getWordKey());
            }
        });
    }
}
