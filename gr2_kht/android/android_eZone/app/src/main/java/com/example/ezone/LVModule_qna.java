package com.example.ezone;

public class LVModule_qna {

    private String qna_cate;
    private String qna_title;
    private String qna_detail;

    public LVModule_qna(String qna_cate, String qna_title, String qna_detail) {
        this.qna_cate = qna_cate;
        this.qna_title = qna_title;
        this.qna_detail = qna_detail;
    }

    public String getQna_cate() {
        return qna_cate;
    }

    public void setQna_cate(String qna_cate) {
        this.qna_cate = qna_cate;
    }

    public String getQna_title() {
        return qna_title;
    }

    public void setQna_title(String qna_title) {
        this.qna_title = qna_title;
    }

    public String getQna_detail() {
        return qna_detail;
    }

    public void setQna_detail(String qna_detail) {
        this.qna_detail = qna_detail;
    }
}
