package com.UserService.Controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


import com.UserService.Entity.User;
import com.UserService.Implementation.userServiceImple;
import com.UserService.Services.userService;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;



@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private userService userservice;
	
	private Logger logger= LoggerFactory.getLogger(userServiceImple.class);
	
	@PostMapping
	public ResponseEntity<User> createuser(@RequestBody User user){
		User userdetails = this.userservice.createuser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userdetails);
		
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getUser(){
		List<User> allUser = this.userservice.getAllUser();
		return ResponseEntity.ok(allUser);
		
	}
	int retryCount=1;
	
	@GetMapping("/{userid}")
//	@CircuitBreaker(name="ratinghotelbreaker", fallbackMethod="ratingHotelFallback")
//	@Retry(name="ratinghotelbreaker", fallbackMethod="ratingHotelFallback")
	@RateLimiter(name="userratelimiter", fallbackMethod="ratingHotelFallback" )
	public ResponseEntity<User> getsingleuser(@PathVariable String userid){
		User user = this.userservice.getoneUser(userid);
		logger.info("Retry count : {} ", retryCount);
		retryCount++;
		return ResponseEntity.ok(user);
		
	}
	
	// creating fallback method for circuit breaker
	
//	public ResponseEntity<User> ratingHotelFallback(String userid, Exception ex)
//	{
//		logger.info("fallback is executed because service is down : ", ex.getMessage());
//		User user= User.builder()
//				.email("dummy@gmail.com")
//				.name("Dummy")
//				.about("This user is created dummy because some services is down ")
//				.id("12345")
//				.build();
//		return new ResponseEntity<>(user, HttpStatus.OK);
//		
//	}
	
	
	public ResponseEntity<User> ratingHotelFallback(String userid, Exception ex)
	{
	
		User user= User.builder()
				.email("dummy@gmail.com")
				.name("Dummy")
				.about("This user is created dummy because some services is down ")
				.id("12345")
				.build();
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}
	
	
	
	@PutMapping("/{userid}")
	public ResponseEntity<User> updateoneuser(@RequestBody User user,@PathVariable String userid){
		User updateuser =this.userservice.updateUser(user, userid);
		return ResponseEntity.ok(updateuser);
		
	}
	
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<?> deleteuser(@PathVariable String userid){
		 this.userservice.deleteUser(userid);
		 return new ResponseEntity<>("User deleted successfully",HttpStatus.OK);
		
	}

}
