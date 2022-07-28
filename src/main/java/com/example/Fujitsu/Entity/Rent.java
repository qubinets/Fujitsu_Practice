package com.example.Fujitsu.Entity;

import com.example.Fujitsu.Entity.Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "rent")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rent_id;
    private LocalDate startDate;
    private int rent_period_by_weeks;

    @Transient
    private double finalBillingPrice;

    @ManyToMany
    @JoinTable(name = "rented_movies_id")
    private List<Movie> movies ;


    public Rent() {
    }

    public Rent(LocalDate startDate, int rent_period_by_weeks, double finalBillingPrice, List<Movie> movies) {
        this.startDate = startDate;
        this.rent_period_by_weeks = rent_period_by_weeks;
        this.finalBillingPrice = finalBillingPrice;
        this.movies = movies;
    }
    public Rent(LocalDate startDate, int rent_period_by_weeks, List<Movie> movies) {
        this.startDate = startDate;
        this.rent_period_by_weeks = rent_period_by_weeks;
        this.movies = movies;
    }

    public Long getRent_id() {
        return rent_id;
    }

    public void setRent_id(Long rent_id) {
        this.rent_id = rent_id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getRent_period_by_weeks() {
        return rent_period_by_weeks;
    }

    public void setRent_period_by_weeks(int rent_period_by_weeks) {
        this.rent_period_by_weeks = rent_period_by_weeks;
    }

    public double getFinalBillingPrice() {
        for (Movie movie:this.movies) {
            for (int i = 0; i < rent_period_by_weeks; i++)
            {
                finalBillingPrice+=movie.getRentalPrice(startDate.plusWeeks(i));
            }
        }
        return finalBillingPrice;
    }
    public double getFinalBillingPriceBySingleMovie(Movie movie) {

        double singleMoviePrice = 0.0;
            for (int i = 0; i < rent_period_by_weeks; i++)
            {
                singleMoviePrice+=movie.getRentalPrice(startDate.plusWeeks(i));
            }

        return singleMoviePrice;
    }

    public void setFinalBillingPrice(double finalBillingPrice) {
        this.finalBillingPrice = finalBillingPrice;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
