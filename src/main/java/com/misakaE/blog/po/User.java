package com.misakaE.blog.po;

public class User {
    private Integer uid;
    private String username;
    private String userpwd;
    private String nick;
    private String head;
    public int getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return userpwd;
    }
    public String getNick() {
        return nick;
    }
    public String getHead() {
        return head;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
    public void setNick(String nick){this.nick = nick;}
}
