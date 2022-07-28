package com.example.Fujitsu.Repo;

import com.example.Fujitsu.Entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepo extends JpaRepository<Rent,Long> {

    @Query("SELECT r FROM Rent r WHERE r.rent_id=?1")
    Rent findByRentId(Long id);


}
