package com.HotelService.HotelService.Entity;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Hotels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Hotel {
	
	@Id
	@Column(name="id")
	private String hotelid;
	
	@Column(name="hotelname")
	private String hotelname;
	
	@Column(name="location")
	private String location;
	
	@Column(name="about")
	private String about;
	

}
