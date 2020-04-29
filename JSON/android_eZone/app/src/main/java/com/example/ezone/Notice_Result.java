package com.example.ezone;

import java.util.ArrayList;

public class Notice_Result {
    private ArrayList<Notice_VO> notice_Result;

    public Notice_Result(ArrayList<Notice_VO> notice_Result) {
        this.notice_Result = notice_Result;
    }

    public ArrayList<Notice_VO> getNotice_Result() {
        return notice_Result;
    }

    public void setNotice_Result(ArrayList<Notice_VO> notice_Result) {
        this.notice_Result = notice_Result;
    }
}
