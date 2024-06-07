package com.Rating.RatingService.Service;

import java.util.List;

import com.Rating.RatingService.Entity.Rating;


public interface ratingService {
	//create ratings
	Rating createrating(Rating rating);
	
	//get all the rating
	List<Rating> getAllrating();
	
	//get all ratings by Userid
	List<Rating> getratingsbyUser(String userid);
	
	//get all ratings by hotelid
		List<Rating> getratingsbyHotel(String hotelid);

}
