package com.project.carrental.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AdminSingleCarDto {

   private CarDto carDto;

public CarDto getCarDto() {
	return carDto;
}

public void setCarDto(CarDto carDto) {
	this.carDto = carDto;
}
   
   

}

