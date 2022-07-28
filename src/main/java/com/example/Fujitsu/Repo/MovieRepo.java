package com.example.Fujitsu.Repo;

import com.example.Fujitsu.Entity.Movie;
import com.example.Fujitsu.Entity.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Long> {

    @Query("Select m from Movie m where m.category LIKE CONCAT('%',?1,'%')")
    List<Movie> findByCategory(String category);
    @Query("Select m from Movie m where m.id =?1")
    Movie findByMovieId(Long id);

    List<Movie> findByTitle(String title);





    @Query("Select m from Movie m where m.rented IS TRUE")
    List<Movie> findByIfRented();
    @Query("Select m from Movie m where m.rented IS FALSE")
    List<Movie> findByIfNotRented();
}
