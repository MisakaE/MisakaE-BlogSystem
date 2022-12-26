package com.misakaE.blog.po;

public class Blog {
    private int bid;
    private String title;
    private String body;
    public int getBid(){
        return bid;
    }
    public void setBid(int bid){
        this.bid=bid;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
