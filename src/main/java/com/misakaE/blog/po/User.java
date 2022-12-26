package com.misakaE.blog.po;

public class User {
    private Integer uid;
    private String username;
    private String userpwd;
    private String nick;
    private String head;
    public int getuid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return userpwd;
    }
    public String getnick() {
        return nick;
    }
    public String gethead() {
        return head;
    }
    public void setuid(int uid) {
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
