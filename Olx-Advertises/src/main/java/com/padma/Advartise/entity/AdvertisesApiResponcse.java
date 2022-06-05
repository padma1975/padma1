package com.padma.Advartise.entity;
import java.time.LocalDate;
import lombok.Data;


@Data

public class AdvertisesApiResponcse {
	
	
	
	private Integer id;
	private String title;
	private double price;
	private String category;
	private String description;
	private String username;
	private LocalDate createDate;
	private LocalDate modifeddate;
	private String status;
	
	}

	

	

