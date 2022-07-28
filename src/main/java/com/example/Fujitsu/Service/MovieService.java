package com.example.Fujitsu.Service;

import com.example.Fujitsu.Entity.Movie;
import com.example.Fujitsu.Repo.MovieRepo;
import com.example.Fujitsu.Repo.RentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepo movieRepo;

    public List<Movie> getAllMovies() {

        return movieRepo.findAll();
    }

    public void addMovie(Movie movie) {
        List<Movie> movieOptional = movieRepo.findByTitle(movie.getTitle());
        if(!movieOptional.isEmpty()) {
            throw new IllegalStateException("Movie already exists");
        }
        movieRepo.save(movie);
    }

    public List<Movie> findByCategory(String category) {

        return movieRepo.findByCategory(category);
    }


    public void removeMovie(Long id) {
        boolean exists = movieRepo.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Movie with id" + id + " not found");
        }
        movieRepo.deleteById(id);
    }
    @Transactional
    public void updateMovie(Long id,
                            String title,
                            String description,
                            String category,
                            String actors,
                            LocalDate date,
                            Double rating,
                            Boolean rented)
    {
    Movie movie = movieRepo.findById(id).
            orElseThrow(()->new IllegalStateException("Movie with id" + id + " notation"));
    if(title != null && title.length() > 0)
    {
        List<Movie> movieOptional = movieRepo.findByTitle(title);
        if(!movieOptional.isEmpty()) {
            throw new IllegalStateException("Movie already exists with this title");
        }
        movie.setTitle(title);
    }

    if(description != null && description.length() > 0){
        movie.setDescription(description);
    }
    if(category!= null && category.length() > 0){
        movie.setCategory(category);
    }
    if(actors!= null && actors.length() > 0){
        movie.setActors(actors);
    }
    if(date!= null){
        movie.setReleaseDate(date);
    }
    if(rating!= null)
    {
        movie.setRating(rating);
    }
        if(rented!= null)
        {
            movie.setRented(rented);
        }

    movieRepo.saveAndFlush(movie);
    }

    public Movie findMovieById(Long id) {
        return movieRepo.findByMovieId(id);
    }

    public List<Movie> getRentedMovies() {
        return movieRepo.findByIfRented();
    }

    public List<Movie> getNotRentedMovies() {

        return movieRepo.findByIfNotRented();
    }
}
