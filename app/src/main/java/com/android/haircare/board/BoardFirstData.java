package com.android.haircare.board;

public class BoardFirstData {

    int doctor_img;
    String doctor_name;

    String boardfirst_type;
    String boardfirst_title;
    String boardfirst_tag;
    String boardfirst_date;


    public BoardFirstData(int doctor_img, String doctor_name, String boardfirst_type, String boardfirst_title, String boardfirst_tag, String boardfirst_date){
        this.doctor_img=doctor_img;
        this.doctor_name=doctor_name;
        this.boardfirst_type=boardfirst_type;
        this.boardfirst_title=boardfirst_title;
        this.boardfirst_tag=boardfirst_tag;
        this.boardfirst_date=boardfirst_date;
    }

    public int getDoctor_img() {
        return doctor_img;
    }

    public void setDoctor_img(int doctor_img) {
        this.doctor_img = doctor_img;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getBoardfirst_type() {
        return boardfirst_type;
    }

    public void setBoardfirst_type(String boardfirst_type) {
        this.boardfirst_type = boardfirst_type;
    }

    public String getBoardfirst_title() {
        return boardfirst_title;
    }

    public void setBoardfirst_title(String boardfirst_title) {
        this.boardfirst_title = boardfirst_title;
    }

    public String getBoardfirst_tag() {
        return boardfirst_tag;
    }

    public void setBoardfirst_tag(String boardfirst_tag) {
        this.boardfirst_tag = boardfirst_tag;
    }

    public String getBoardfirst_date() {
        return boardfirst_date;
    }

    public void setBoardfirst_date(String boardfirst_date) {
        this.boardfirst_date = boardfirst_date;
    }
}
