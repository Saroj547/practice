package com.Rating.RatingService.Implementation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rating.RatingService.Entity.Rating;
import com.Rating.RatingService.Reporsitory.RatingRepo;
import com.Rating.RatingService.Service.ratingService;

@Service
public class ratingServiceImple implements ratingService{
	
	@Autowired
	private RatingRepo ratingrepo;

	@Override
	public Rating createrating(Rating rating) {
		String randomratingsid = UUID.randomUUID().toString();
		rating.setRatingid(randomratingsid);
		return this.ratingrepo.save(rating);
	}

	@Override
	public List<Rating> getAllrating() {
		return this.ratingrepo.findAll();
	}

	@Override
	public List<Rating> getratingsbyUser(String userid) {
		return this.ratingrepo.findByUserid(userid);
	}

	@Override
	public List<Rating> getratingsbyHotel(String hotelid) {
		return this.ratingrepo.findByHotelid(hotelid);
	}

}
