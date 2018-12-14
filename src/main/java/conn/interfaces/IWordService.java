package conn.interfaces;

import conn.Model.WordSet;

import java.util.ArrayList;

public interface IWordService {
    int Register(WordSet wordSet);
    ArrayList<WordSet> SearchAll();
    WordSet Search(String wordKey);
    void Modify(WordSet wordSet);
    int Remove(WordSet wordSet);
}
