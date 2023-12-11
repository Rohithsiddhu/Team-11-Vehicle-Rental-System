package com.project.carrental.services.customer;

import com.project.carrental.dto.*;

import java.util.List;

public interface CustomerService {

    List<CarDto> getAllCars();

    UserSingleCarDto getCarById(Long carId);

    boolean bookACar(Long carId, BookCarDto bookCarDto);

    List<BookCarDto> getBookedCarsByUserId(Long userId);

    CarsDtoList searchCars(SearchCarDto searchCarDto);
}
