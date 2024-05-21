package com.entity;


public class Student {
    private String sid;
    private String sname;
    private int sage;
    private String phone;
    private String email;

    private boolean sex;

    private String QQNumber;
    private String StuClass;
    private String Username;
    private String Password;

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    private int No;

    public String getCurriId() {
        return CurriId;
    }

    public void setCurriId(String curriId) {
        CurriId = curriId;
    }

    public String getCteacher() {
        return Cteacher;
    }

    public void setCteacher(String cteacher) {
        Cteacher = cteacher;
    }

    public int getCgrade() {
        return Cgrade;
    }

    public void setCgrade(int cgrade) {
        Cgrade = cgrade;
    }

    private String CurriName;
    private String CurriId;
    private String Cteacher;
    private int Cgrade;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public boolean setPassword(String password) {
        int len = password.length();
        if (len >= 6 & len <= 15) {
            Password = password;
            return true;
        } else return false;

    }

    public String getQQNumber() {
        return QQNumber;
    }

    public void setQQNumber(String QQNumber) {
        this.QQNumber = QQNumber;
    }

    public String getStuClass() {
        return StuClass;
    }

    public void setStuClass(String stuClass) {
        StuClass = stuClass;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }


    public String getCurriName() {
        return CurriName;
    }

    public void setCurriName(String curriName) {
        CurriName = curriName;
    }
}
