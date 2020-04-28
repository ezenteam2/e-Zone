package com.example.ezone;

public class LVModule_notice {
    private String noti_cate;
    private String noti_title;
    private String noti_detail;

    public LVModule_notice(String noti_cate, String noti_title, String noti_detail) {
        this.noti_cate = noti_cate;
        this.noti_title = noti_title;
        this.noti_detail = noti_detail;
    }

    public String getNoti_cate() {
        return noti_cate;
    }

    public void setNoti_cate(String noti_cate) {
        this.noti_cate = noti_cate;
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
}
