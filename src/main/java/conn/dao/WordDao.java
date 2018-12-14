package conn.dao;

import conn.Model.WordSet;
import conn.interfaces.IWordDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class WordDao implements IWordDao {

    /**
     * 데이터 베이스 대체로 HashMap 을 사용한다.*/
    private HashMap<String, WordSet> wordDB;
    public WordDao() {
        this.wordDB = new HashMap<String, WordSet>();
    }

    public WordSet select(String wordKey) {
        if(this.wordDB.containsKey(wordKey)){ // select 하려는 단어가 있을 때 반환
            WordSet wordSet = this.wordDB.get(wordKey);
            return wordSet;
        }else{ // 없으면 null
            return null;
        }
    }

    public ArrayList<WordSet> selectAll(){ // 저장된 단어 전부 출력
        ArrayList<WordSet> list = new ArrayList<WordSet>();
        for(String key : this.wordDB.keySet()){
            list.add(this.wordDB.get(key));
        }
        return list;
    }

    public int insert(WordSet wordSet) {
        if(!this.wordDB.containsKey(wordSet.getWordKey())){ // insert 하려는 단어가 db 안에 없다면
            this.wordDB.put(wordSet.getWordKey(), wordSet); // db에 삽입
            return 1; // 양수 : 성공
        }else{ // 이미 있다면 (중복) null 반환
            return -1; // 음수 : 실패
        }
    }

    public int update(WordSet wordSet) {
        this.wordDB.put(wordSet.getWordKey(), wordSet); // 새로운 값으로 업데이트
        return 1; // 성공
    }

    public int delete(WordSet wordSet) {
        this.wordDB.remove(wordSet.getWordKey()); // 단어 제거
        return 1; // 성공
    }
}
