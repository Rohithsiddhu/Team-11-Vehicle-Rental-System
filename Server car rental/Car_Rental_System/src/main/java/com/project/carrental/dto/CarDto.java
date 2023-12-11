package com.project.carrental.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;



public class CarDto {

    private Long id;
    private String brand;
    private String name;
    private String type;
    private String transmission;
    private String color;
    private Date year;
    private String description;
    private Long price;
    private MultipartFile img;
    private byte[] returnedImg;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
		this.img = img;
	}
	public byte[] getReturnedImg() {
		return returnedImg;
	}
	public void setReturnedImg(byte[] returnedImg) {
		this.returnedImg = returnedImg;
	}
	public CarDto(Long id, String brand, String name, String type, String transmission, String color, Date year,
			String description, Long price, MultipartFile img, byte[] returnedImg) {
		this.id = id;
		this.brand = brand;
		this.name = name;
		this.type = type;
		this.transmission = transmission;
		this.color = color;
		this.year = year;
		this.description = description;
		this.price = price;
		this.img = img;
		this.returnedImg = returnedImg;
	}
	public CarDto() {
    }
	
    
    

}
