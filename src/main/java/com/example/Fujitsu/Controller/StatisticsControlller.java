package com.example.Fujitsu.Controller;

import com.example.Fujitsu.Entity.Movie;
import com.example.Fujitsu.Entity.Stats;
import com.example.Fujitsu.Service.MovieService;
import com.example.Fujitsu.Service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/movie/stats")
public class StatisticsControlller {

    @Autowired
    RentService rentService;

    @GetMapping()
    public List<Stats> getStats() {
        return rentService.getStats();
    }
}
