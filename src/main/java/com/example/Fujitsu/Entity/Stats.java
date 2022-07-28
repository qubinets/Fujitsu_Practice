package com.example.Fujitsu.Entity;

import javax.persistence.*;
import java.util.List;

public class Stats {

    private String movieName;
    private Integer totalRentCounts;

    private Integer totalWeeksRented;
    private Double totalIncome;

    public Stats() {

    }

    public Stats(Integer totalRentCounts, Double totalIncome) {

        this.totalRentCounts = totalRentCounts;
        this.totalIncome = totalIncome;
    }

    public Stats(String movieName, Integer totalRentCounts, Double totalIncome) {
        this.movieName = movieName;
        this.totalRentCounts = totalRentCounts;
        this.totalIncome = totalIncome;
    }
    public Stats(String movieName) {
        this.movieName = movieName;

    }

    public Integer getTotalRentCounts() {
        return totalRentCounts;
    }

    public void setTotalRentCounts(Integer totalRentCounts) {
        this.totalRentCounts = totalRentCounts;
    }

    public Double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getTotalWeeksRented() {
        return totalWeeksRented;
    }

    public void setTotalWeeksRented(Integer totalWeeksRented) {
        this.totalWeeksRented = totalWeeksRented;
    }
}
