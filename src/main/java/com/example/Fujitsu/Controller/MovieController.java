package com.example.Fujitsu.Controller;

import com.example.Fujitsu.Entity.Movie;
import com.example.Fujitsu.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class MovieController {

    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movie")
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }
    @GetMapping("/movie/rented")
    public List<Movie> getRentedMovies() {
        return movieService.getRentedMovies();
    }
    @GetMapping("/movie/not-rented")
    public List<Movie> getNotRentedMovies() {
        return movieService.getNotRentedMovies();
    }

    @GetMapping("/movie/category")
    public List<Movie> getMoviesByCategory(String category) {
        return movieService.findByCategory(category);
    }

    @GetMapping("/movie/{id}")
    public Movie  getMovieByID(@PathVariable("id")Long id) {
        return movieService.findMovieById(id);
    }

    @PostMapping("/movie")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

    @DeleteMapping ("/movie/{id}")
    public void removeMovie(@PathVariable("id") Long id) {
    movieService.removeMovie(id);}

    @PutMapping("/movie/{id}")
    public void updateMovie(@PathVariable("id") Long id,
                            @RequestParam(required = false) String title,
                            @RequestParam(required = false) String description,
                            @RequestParam(required = false) String category,
                            @RequestParam(required = false) String actors,
                            @RequestParam(required = false) LocalDate date,
                            @RequestParam(required = false) Double rating,
                            @RequestParam(required = false) boolean rented)
     {
        movieService.updateMovie(id, title, description, category, actors, date, rating,rented);
     }
}
