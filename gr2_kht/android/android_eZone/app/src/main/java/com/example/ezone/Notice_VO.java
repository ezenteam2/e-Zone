package com.example.ezone;

import java.util.Date;

public class Notice_VO {
    private int noti_code;
    private String ad_id;
    private String noti_date;
    private String noti_title;
    private String noti_detail;
    private String noti_img;
    private String keyword;

    public int getNoti_code() {
        return noti_code;
    }

    public void setNoti_code(int noti_code) {
        this.noti_code = noti_code;
    }

    public String getAd_id() {
        return ad_id;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }

    public String getNoti_date() {
        return noti_date;
    }

    public void setNoti_date(String noti_date) {
        this.noti_date = noti_date;
    }

    public String getNoti_title() {
        return noti_title;
    }

    public void setNoti_title(String noti_title) {
        this.noti_title = noti_title;
    }

    public String getNoti_detail() {
        return noti_detail;
    }

    public void setNoti_detail(String noti_detail) {
        this.noti_detail = noti_detail;
    }

    public String getNoti_img() {
        return noti_img;
    }

    public void setNoti_img(String noti_img) {
        this.noti_img = noti_img;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
