package com.example.smartvan;

public class Child {
    private Integer childId;
    private String childfname;
    private String childlname;
    private String childdob;
    private String childschool;
    private String childgender;
    private String childlocation;
    private String childregdate;

    public Child(Integer childId, String childfname, String childlname, String childdob, String childschool,String childgender, String childlocation, String childregdate){
        this.setChildId(childId);
        this.setChildfname(childfname);
        this.setChildlname(childlname);
        this.setChilddob(childdob);
        this.setChildschool(childschool);
        this.setChildgender(childgender);
        this.setChildlocation(childlocation);
        this.setChildregdate(childregdate);
    }

    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    public String getChildfname() {
        return childfname;
    }

    public void setChildfname(String childfname) {
        this.childfname = childfname;
    }

    public String getChildlname() {
        return childlname;
    }

    public void setChildlname(String childlname) {
        this.childlname = childlname;
    }

    public String getChilddob() {
        return childdob;
    }

    public void setChilddob(String childdob) {
        this.childdob = childdob;
    }

    public String getChildschool() {
        return childschool;
    }

    public void setChildschool(String childschool) {
        this.childschool = childschool;
    }

    public String getChildgender() {
        return childgender;
    }

    public void setChildgender(String childgender) {
        this.childgender = childgender;
    }

    public String getChildlocation() {
        return childlocation;
    }

    public void setChildlocation(String childlocation) {
        this.childlocation = childlocation;
    }

    public String getChildregdate() {
        return childregdate;
    }

    public void setChildregdate(String childregdate) {
        this.childregdate = childregdate;
    }
}
