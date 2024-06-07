package com.HotelService.HotelService.Implementation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelService.HotelService.Entity.Hotel;
import com.HotelService.HotelService.Exception.ResourceNotFoundException;
import com.HotelService.HotelService.Repo.HotelRepository;
import com.HotelService.HotelService.Services.hotelService;

@Service
public class hotelServiceImplementation implements hotelService{
	
	@Autowired
	private HotelRepository hotelrepository;

	@Override
	public Hotel createhotel(Hotel hotel) {
		String randomhotelid= UUID.randomUUID().toString();
		hotel.setHotelid(randomhotelid);
	return hotelrepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelrepository.findAll();
	}

	@Override
	public Hotel getoneHotel(String hotelid) {
		return hotelrepository.findById(hotelid).orElseThrow(()-> new ResourceNotFoundException(" Hotel with given id is not found !! " +hotelid));
	}

	@Override
	public Hotel updateHotel(Hotel hotel, String hotelid) {
		Hotel newhotel= hotelrepository.findById(hotelid).orElseThrow(()-> new ResourceNotFoundException(" Hotel with given id is not found !! " +hotelid));
		newhotel.setHotelname(hotel.getHotelname());
		newhotel.setLocation(hotel.getLocation());
		newhotel.setAbout(hotel.getAbout());
		return hotelrepository.save(newhotel);
		
	}

	@Override
	public void deleteUser(String hotelid) {
		Hotel hotel= hotelrepository.findById(hotelid).orElseThrow(()-> new ResourceNotFoundException(" Hotel with given id is not found !! " +hotelid));
		hotelrepository.delete(hotel);
		
	}

}
