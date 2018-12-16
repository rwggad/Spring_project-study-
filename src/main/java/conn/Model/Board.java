package conn.Model;

public class Board {
    private int boardId; // 글 번호
    private String boardWriter; // 작성자
    private String boardTitle; // 제목
    private String boardContent; // 내용
    private String boardDate; // 작성일
    private String boardCnt; // 조회수
    private String IpAddress; // ip 주소

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public String getBoardDate() {
        return boardDate;
    }

    public void setBoardDate(String boardDate) {
        this.boardDate = boardDate;
    }

    public String getBoardCnt() {
        return boardCnt;
    }

    public void setBoardCnt(String boardCnt) {
        this.boardCnt = boardCnt;
    }

    public String getIpAddress() {
        return IpAddress;
    }

    public void setIpAddress(String ipAddress) {
        IpAddress = ipAddress;
    }
}
