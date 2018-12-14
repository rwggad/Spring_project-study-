package conn.interfaces;

import conn.Model.WordSet;

public interface IWordDao {
    WordSet select(String word);
    int insert(WordSet wordSet);
    int update(WordSet wordSet);
    int delete(WordSet wordSet);
}
