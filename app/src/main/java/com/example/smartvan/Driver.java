package com.example.smartvan;
public class Driver<Int> {
    private String driverId;
    private String driverfname;
    private String driverlname;
    private String driverdob;
    private String drivergender;
    private String driveremail;
    private String driversalary;
    private String driveraddress;
    private String driverlicence;

    public Integer getDrivercontact() {
        return drivercontact;
    }

    public void setDrivercontact(Integer drivercontact) {
        this.drivercontact = drivercontact;
    }

    private Integer drivercontact;
    private String drivervan;
    private String drivercontract;
    private String driverReg_date;

    public Driver(String driverId, String driverfname, String driverlname, String driverdob, String drivergender, String driveremail, String driversalary, String driveraddress, String driverlicence, Integer drivercontact, String drivervan, String drivercontract, String driverReg_date){
        this.setDriverId(driverId);
        this.setDriverfname(driverfname);
        this.setDriverlname(driverlname);
        this.setDriverdob(driverdob);
        this.setDrivergender(drivergender);
        this.setDriveremail(driveremail);
        this.setDriversalary(driversalary);
        this.setDriveraddress(driveraddress);
        this.setDriverlicence(driverlicence);
        this.setDrivercontact(drivercontact);
        this.setDrivervan(drivervan);
        this.setDrivercontract(drivercontract);
        this.setDriverReg_date(driverReg_date);
    }
    //private int childId;


    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverfname() {
        return driverfname;
    }

    public void setDriverfname(String driverfname) {
        this.driverfname = driverfname;
    }

    public String getDriverlname() {
        return driverlname;
    }

    public void setDriverlname(String driverlname) {
        this.driverlname = driverlname;
    }

    public String getDriverdob() {
        return driverdob;
    }

    public void setDriverdob(String driverdob) {
        this.driverdob = driverdob;
    }

    public String getDrivergender() {
        return drivergender;
    }

    public void setDrivergender(String drivergender) {
        this.drivergender = drivergender;
    }

    public String getDriveremail() {
        return driveremail;
    }

    public void setDriveremail(String driveremail) {
        this.driveremail = driveremail;
    }

    public String getDriversalary() {
        return driversalary;
    }

    public void setDriversalary(String driverslary) {
        this.driversalary = driverslary;
    }

    public String getDriveraddress() {
        return driveraddress;
    }

    public void setDriveraddress(String driveraddress) {
        this.driveraddress = driveraddress;
    }

    public String getDriverlicence() {
        return driverlicence;
    }

    public void setDriverlicence(String driverlicence) {
        this.driverlicence = driverlicence;
    }



    public String getDrivervan() {
        return drivervan;
    }

    public void setDrivervan(String drivervan) {
        this.drivervan = drivervan;
    }

    public String getDrivercontract() {
        return drivercontract;
    }

    public void setDrivercontract(String drivercontract) {
        this.drivercontract = drivercontract;
    }

    public String getDriverReg_date() {
        return driverReg_date;
    }

    public void setDriverReg_date(String driverReg_date) {
        this.driverReg_date = driverReg_date;
    }
}
