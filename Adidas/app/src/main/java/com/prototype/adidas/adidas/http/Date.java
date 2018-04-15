package com.prototype.adidas.adidas.http;

public class Date {

   private String month;
   private String year;
   private String day;


    public Date(String month, String year) {
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
    }

    public Date(String month, String day, String year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
