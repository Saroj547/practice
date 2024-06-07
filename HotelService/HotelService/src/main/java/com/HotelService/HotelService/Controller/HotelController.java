package com.HotelService.HotelService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HotelService.HotelService.Entity.Hotel;
import com.HotelService.HotelService.Services.hotelService;


@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private hotelService hotelservice;
	
	@PostMapping
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
	return ResponseEntity.status(HttpStatus.CREATED).body(hotelservice.createhotel(hotel));
		
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> showAllHoteldetails(){
		return ResponseEntity.status(HttpStatus.OK).body(hotelservice.getAllHotel());

		
	}
	
	@GetMapping("/{hotelid}")
	public ResponseEntity<Hotel> showOneHoteldetails(@PathVariable String hotelid){
		
		return ResponseEntity.status(HttpStatus.OK).body(hotelservice.getoneHotel(hotelid));
		
	}
	
	@PutMapping("/{hotelid}")
	public ResponseEntity<Hotel> updateHoteldetails(@RequestBody Hotel hotel, @PathVariable String hotelid){
		
		return ResponseEntity.status(HttpStatus.OK).body(hotelservice.updateHotel(hotel, hotelid));
		
	}
	
	@DeleteMapping("/{hotelid}")
	public ResponseEntity<?> deleteuser(@PathVariable String hotelid){
		 this.hotelservice.deleteUser(hotelid);
		 return new ResponseEntity<>("Hotel deleted successfully",HttpStatus.OK);
		
	}

}
