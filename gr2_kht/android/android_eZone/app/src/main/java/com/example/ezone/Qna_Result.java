package com.example.ezone;

import java.util.ArrayList;

public class Qna_Result {
    private ArrayList<Qna_VO> qna_Result;

    public Qna_Result(ArrayList<Qna_VO> notice_Result) {
        this.qna_Result = qna_Result;
    }

    public ArrayList<Qna_VO> getQna_Result() {
        return qna_Result;
    }

    public void setQna_Result(ArrayList<Qna_VO> qna_Result) {
        this.qna_Result = qna_Result;
    }
}
