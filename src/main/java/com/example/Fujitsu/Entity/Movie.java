package com.example.Fujitsu.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String category;
    private String actors;
    private LocalDate releaseDate;
    private double rating;
    @JsonIgnore
    private boolean rented;

    public Movie() {
    }

    public Movie(Long id, String title, String description, String category, String actors, LocalDate releaseDate, double rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.actors = actors;
        this.releaseDate = releaseDate;
        this.rating = rating;

    }

    public Movie(String title, String description, String category, String actors, LocalDate releaseDate, double rating) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.actors = actors;
        this.releaseDate = releaseDate;
        this.rating = rating;

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    //this method will calculate base rental price for a week based on movie released date.
    public Double getRentalPrice(LocalDate localDate) {
    //calculate totalday

    double years= Period.between(this.releaseDate,localDate).getYears();
    double months= Period.between(this.releaseDate,localDate).getMonths();
    double days= Period.between(this.releaseDate,localDate).getDays();
    double totaldays =(years*365)+(months*30)+days;
    //get full amount of weeks by using int variable
    int weeks = (int)totaldays/7;
    //if movie is not older than 52 weeks. The rental price is 5 EUR per week
        if(weeks<52) {
            return 5.0;
        }
        //if movie is not older than 156 weeks and older then 52. The rental price is 3.49 EUR per week
        if(weeks<156 && weeks > 52){
            return 3.49;
        }
        //all others cases 1.99
        else
        return 1.99;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", actors='" + actors + '\'' +
                ", releaseDate=" + releaseDate +
                ", rating=" + rating +

                '}';
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }


}
