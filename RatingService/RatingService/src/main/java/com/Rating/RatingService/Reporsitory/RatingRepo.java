package com.Rating.RatingService.Reporsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Rating.RatingService.Entity.Rating;

public interface RatingRepo extends JpaRepository<Rating, String> {
	
	// Custom finder method
	
	List<Rating> findByUserid(String userid);
	
	List<Rating> findByHotelid(String hotelid);

}
