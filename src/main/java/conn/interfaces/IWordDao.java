package conn.interfaces;

import conn.Model.WordSet;

import java.util.List;

public interface IWordDao {
    List<WordSet> selectAll();
    WordSet select(String word);
    int insert(WordSet wordSet);
    int update(WordSet wordSet);
    int delete(WordSet wordSet);
}
