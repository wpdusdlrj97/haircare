package com.android.haircare.board;

import android.widget.ImageView;
import android.widget.TextView;

public class BoardSecondData {

    int boardsecond_no;

    int boardsecond_profile;
    String boardsecond_nickname;
    String boardsecond_date;
    String boardsecond_content;
    String boardsecond_status;

    String boardsecond_first_image;
    String boardsecond_second_image;
    String boardsecond_third_image;


    public BoardSecondData(int boardsecond_no, int boardsecond_profile, String boardsecond_nickname, String boardsecond_date, String boardsecond_content, String boardsecond_status, String boardsecond_first_image, String boardsecond_second_image, String boardsecond_third_image) {
        this.boardsecond_no = boardsecond_no;
        this.boardsecond_profile = boardsecond_profile;
        this.boardsecond_nickname = boardsecond_nickname;
        this.boardsecond_date = boardsecond_date;
        this.boardsecond_content = boardsecond_content;
        this.boardsecond_status = boardsecond_status;
        this.boardsecond_first_image = boardsecond_first_image;
        this.boardsecond_second_image = boardsecond_second_image;
        this.boardsecond_third_image = boardsecond_third_image;
    }

    public int getBoardsecond_no() {
        return boardsecond_no;
    }

    public void setBoardsecond_no(int boardsecond_no) {
        this.boardsecond_no = boardsecond_no;
    }

    public String getBoardsecond_first_image() {
        return boardsecond_first_image;
    }

    public void setBoardsecond_first_image(String boardsecond_first_image) {
        this.boardsecond_first_image = boardsecond_first_image;
    }

    public String getBoardsecond_second_image() {
        return boardsecond_second_image;
    }

    public void setBoardsecond_second_image(String boardsecond_second_image) {
        this.boardsecond_second_image = boardsecond_second_image;
    }

    public String getBoardsecond_third_image() {
        return boardsecond_third_image;
    }

    public void setBoardsecond_third_image(String boardsecond_third_image) {
        this.boardsecond_third_image = boardsecond_third_image;
    }

    public int getBoardsecond_profile() {
        return boardsecond_profile;
    }

    public void setBoardsecond_profile(int boardsecond_profile) {
        this.boardsecond_profile = boardsecond_profile;
    }

    public String getBoardsecond_nickname() {
        return boardsecond_nickname;
    }

    public void setBoardsecond_nickname(String boardsecond_nickname) {
        this.boardsecond_nickname = boardsecond_nickname;
    }

    public String getBoardsecond_date() {
        return boardsecond_date;
    }

    public void setBoardsecond_date(String boardsecond_date) {
        this.boardsecond_date = boardsecond_date;
    }

    public String getBoardsecond_content() {
        return boardsecond_content;
    }

    public void setBoardsecond_content(String boardsecond_content) {
        this.boardsecond_content = boardsecond_content;
    }

    public String getBoardsecond_status() {
        return boardsecond_status;
    }

    public void setBoardsecond_status(String boardsecond_status) {
        this.boardsecond_status = boardsecond_status;
    }
}
