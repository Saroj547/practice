package com.HotelService.HotelService.Services;

import java.util.List;

import com.HotelService.HotelService.Entity.Hotel;


public interface hotelService {
	
	Hotel createhotel(Hotel hotel);
	List<Hotel> getAllHotel();
	Hotel getoneHotel(String hotelid);
	Hotel updateHotel(Hotel hotel,String hotelid);
	void deleteUser(String hotelid);

}
