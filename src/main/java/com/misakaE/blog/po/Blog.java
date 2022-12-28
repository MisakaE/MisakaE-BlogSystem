package com.misakaE.blog.po;

public class Blog {
    private int bid;
    private String title;
    private String body;
    private String date;
    private int uuid;
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
    public String getDate(){return date;}
    public int getUuid(){return uuid;}
    public void setBody(String body) {
        this.body = body;
    }
    public void setDate(String date){this.date=date;}
    public void setUuid(int uuid){this.uuid=uuid;};
}
