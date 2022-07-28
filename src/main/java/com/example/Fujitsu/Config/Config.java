package com.example.Fujitsu.Config;
import com.example.Fujitsu.Entity.Movie;
import com.example.Fujitsu.Entity.Rent;
import com.example.Fujitsu.Repo.MovieRepo;
import com.example.Fujitsu.Repo.RentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Config {
    @Autowired
    MovieRepo movieRepo;
    @Bean
    CommandLineRunner runner(MovieRepo movieRepo, RentRepo rentRepo){
     return args ->{
         Movie defaultMovie = new Movie(

                 "Lord of the Rings",
                 "Frodo going to Mordor",
                 "Fantasy,Adventure,Drama",
                 "Actors",
                 LocalDate.of(2004,Month.SEPTEMBER, 1),
                 0

                );
         Movie defaultMovie2 = new Movie(

                 "Edge of Tomorrow",
                 "Description",
                 "Fantastic,Action,Adventure",
                 "Actors",
                 LocalDate.of(2014,Month.SEPTEMBER, 1),
                 0

         );
         List<Movie> movies = Arrays.asList(defaultMovie,defaultMovie2);
         Rent rent = new Rent(
                 LocalDate.now(),
                 2,
                 movies
         );
         rent.setFinalBillingPrice(rent.getFinalBillingPrice());
         movieRepo.saveAll(movies);
         rentRepo.save(rent);

        };
    }
}

