package conn.interfaces;

import conn.WordSet;

public interface IWordDao {
    WordSet select(String word);
    int insert(WordSet wordSet);
    int update(WordSet wordSet);
    int delete(WordSet wordSet);
}
