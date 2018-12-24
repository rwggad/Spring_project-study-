package conn.service;

import conn.Model.WordModel.WordSet;
import conn.dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WordService {

    @Autowired
    private WordDao dao; // dao 자동 주입

    /** 단어 등록 */
    public int Register(WordSet wordSet) {
        // 이미 등록되어 있는 단어일 경우 -1 return
        return dao.insert(wordSet) > 0 ? 1 : -1;
    }

    /** 단어 전부 검색 */
    public List<WordSet> SearchAll(){
        return dao.selectAll();
    }

    /** 단어 검색*/
    public WordSet Search(String wordKey) {
        return dao.select(wordKey);
    }

    /** 단어 수정 */
    public void Modify(WordSet wordSet){

    }

    /** 단어 삭제 */
    public int Remove(WordSet wordSet){
        return dao.delete(wordSet);
    }
}
