package com.Rating.RatingService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Rating.RatingService.Entity.Rating;
import com.Rating.RatingService.Service.ratingService;


@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private ratingService ratingservice;
	
	
	@PostMapping
	public ResponseEntity<Rating> addRatings(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingservice.createrating(rating));
		
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> readRating(){
		return ResponseEntity.status(HttpStatus.OK).body(ratingservice.getAllrating());
	}
	
	@GetMapping("/users/{userid}")
	public ResponseEntity<List<Rating>> readRatingWithUserId(@PathVariable String userid ){
		return ResponseEntity.status(HttpStatus.OK).body(ratingservice.getratingsbyUser(userid));
	}
	
	@GetMapping("/hotels/{hotelid}")
	public ResponseEntity<List<Rating>> readRatingWithUHotelId(@PathVariable String hotelid ){
		return ResponseEntity.status(HttpStatus.OK).body(ratingservice.getratingsbyHotel(hotelid));
	}

}
