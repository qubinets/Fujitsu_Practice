package com.example.Fujitsu.Service;

import com.example.Fujitsu.Entity.Movie;
import com.example.Fujitsu.Entity.Rent;
import com.example.Fujitsu.Entity.Stats;
import com.example.Fujitsu.Repo.MovieRepo;
import com.example.Fujitsu.Repo.RentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentService {
    @Autowired
    RentRepo rentRepo;
    @Autowired
    MovieRepo movieRepo;


    public List<Rent> getRentedMovies() {
       return  rentRepo.findAll();
    }
    public void addRent(Rent rent) {


       rentRepo.save(rent);

    }

    public Rent getRentedMovieByrentId(Long id) {
        return rentRepo.findByRentId(id);
    }

    //not really good stats claculation since its Big(0^3)
    public List<Stats> getStats() {
      List<Rent> rentList =  rentRepo.findAll();
      List<Movie> movies = movieRepo.findAll();
      List<Stats> latestStats = new ArrayList<>();

      for(Movie m : movies) {
          if(!latestStats.contains(m.getTitle()))
          {
              latestStats.add(new Stats(m.getTitle()));
          }
      }
      for(int i = 0; i < rentList.size(); i++)
      {
          List<Movie> movieCheck = rentList.get(i).getMovies();
          for(int j = 0; j < movieCheck.size(); j++)
          {
              for(int k = 0; k < latestStats.size(); k++)
              {
                  if(movieCheck.get(j).getTitle().equals(latestStats.get(k).getMovieName()))
                  {
                      if(latestStats.get(k).getTotalRentCounts() == null)
                      {
                          latestStats.get(k).setTotalRentCounts(0);
                      }
                      if(latestStats.get(k).getTotalIncome() == null)
                      {
                          latestStats.get(k).setTotalIncome(0.0) ;
                      }
                      if(latestStats.get(k).getTotalWeeksRented() == null)
                      {
                          latestStats.get(k).setTotalWeeksRented(0); ;
                      }
                      latestStats.get(k).setTotalRentCounts(latestStats.get(k).getTotalRentCounts()+1);
                      latestStats.get(k).setTotalIncome(latestStats.get(k).getTotalIncome()
                              + rentList.get(i).getFinalBillingPriceBySingleMovie(movieCheck.get(j)));
                      latestStats.get(k).setTotalWeeksRented(latestStats.get(k).getTotalWeeksRented()+ rentList.get(i).getRent_period_by_weeks());
                  }
              }
          }
      }
      return latestStats;
    }
}
