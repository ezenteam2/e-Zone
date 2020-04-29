package com.example.ezone;

import java.util.Date;

public class Qna_VO {
    private int qnaCode;
    private String qnaCate;
    private String memId;
    private String qnaDate;
    private String qnaTitle;
    private String qnaDetail;
    private String qnaOpen;
    private String qnaAnsw;
    private Date qndAdate;
    private String adId;

    public int getQnaCode() {
        return qnaCode;
    }

    public void setQnaCode(int qnaCode) {
        this.qnaCode = qnaCode;
    }

    public String getQnaCate() {
        return qnaCate;
    }

    public void setQnaCate(String qnaCate) {
        this.qnaCate = qnaCate;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getQnaDate() {
        return qnaDate;
    }

    public void setQnaDate(String qnaDate) {
        this.qnaDate = qnaDate;
    }

    public String getQnaTitle() {
        return qnaTitle;
    }

    public void setQnaTitle(String qnaTitle) {
        this.qnaTitle = qnaTitle;
    }

    public String getQnaDetail() {
        return qnaDetail;
    }

    public void setQnaDetail(String qnaDetail) {
        this.qnaDetail = qnaDetail;
    }

    public String getQnaOpen() {
        return qnaOpen;
    }

    public void setQnaOpen(String qnaOpen) {
        this.qnaOpen = qnaOpen;
    }

    public String getQnaAnsw() {
        return qnaAnsw;
    }

    public void setQnaAnsw(String qnaAnsw) {
        this.qnaAnsw = qnaAnsw;
    }

    public Date getQndAdate() {
        return qndAdate;
    }

    public void setQndAdate(Date qndAdate) {
        this.qndAdate = qndAdate;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }
}
