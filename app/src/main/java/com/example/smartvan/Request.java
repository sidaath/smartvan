package com.example.smartvan;

import android.location.Location;

public class Request {
    private int requestId;
    private String requestDate;
    private String vanId;
    private int childId;
    private String fname;
    private String lname;
    private String location;
    private String school;
    

    public Request(int requestId, String requestDate, String vanId, int childId, String fname, String lname, String location, String school) {
        this.setRequestId(requestId);
        this.setRequestDate(requestDate);
        this.setVanId(vanId);
        this.setChildId(childId);
        this.setFname(fname);
        this.setLname(lname);
        this.setLocation(location);
        this.setSchool(school);
    }


    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getVanId() {
        return vanId;
    }

    public void setVanId(String vanId) {
        this.vanId = vanId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }
}
