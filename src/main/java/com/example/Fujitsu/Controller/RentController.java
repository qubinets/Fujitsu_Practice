package com.example.Fujitsu.Controller;

import com.example.Fujitsu.Entity.Rent;
import com.example.Fujitsu.Service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/movie/rent")
public class RentController {
    @Autowired
    RentService rentService;

    @GetMapping
    public List<Rent> getRentedMovies(){
       return rentService.getRentedMovies();
    }

    @GetMapping("/{rent_id}")
    public Rent getRentedMovieByrentId(@PathVariable("rent_id") Long id) {
        return rentService.getRentedMovieByrentId(id);
    }

    @PostMapping("/add")
    public void addRent(@RequestBody Rent rent){
        rentService.addRent(rent);

    }


}
