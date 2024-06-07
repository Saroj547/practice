package com.HotelService.HotelService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HotelService.HotelService.Entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
