package conn.interfaces.Word;

import conn.Model.WordModel.WordSet;

import java.util.List;

public interface IWordService {
    int Register(WordSet wordSet);
    List<WordSet> SearchAll();
    WordSet Search(String wordKey);
    void Modify(WordSet wordSet);
    int Remove(WordSet wordSet);
}
