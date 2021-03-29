package com.example.smartvan;

public class Van {
    private String vanId;
    private Integer seats;
    private Integer fillseats;
    private Integer availableseats;
    private String condition;
    private String vanreg_date;

    public Van(String vanId, Integer seats, Integer fillseats, Integer availableseats, String condition,String vanreg_date) {
        this.setVanId(vanId);
        this.setSeats(seats);
        this.setFillseats(fillseats);
        this.setAvailableseats(availableseats);
        this.setCondition(condition);
        this.setVanreg_date(vanreg_date);
    }

    public String getVanId() {
        return vanId;
    }

    public void setVanId(String vanId) {
        this.vanId = vanId;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getFillseats() {
        return fillseats;
    }

    public void setFillseats(Integer fillseats) {
        this.fillseats = fillseats;
    }

    public Integer getAvailableseats() {
        return availableseats;
    }

    public void setAvailableseats(Integer availableseats) {
        this.availableseats = availableseats;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getVanreg_date() {
        return vanreg_date;
    }

    public void setVanreg_date(String vanreg_date) {
        this.vanreg_date = vanreg_date;
    }


    //private int childId;
}

