package com.project.carrental.services.admin;



import java.io.IOException;
import java.util.List;

import com.project.carrental.dto.AdminSingleCarDto;
import com.project.carrental.dto.BookCarDto;
import com.project.carrental.dto.CarDto;
import com.project.carrental.dto.CarsDtoList;
import com.project.carrental.dto.SearchCarDto;

public interface AdminService {

    boolean addCar(CarDto carDto);

    List<CarDto> getAllCars();

    AdminSingleCarDto getCarById(Long carId);

    boolean updateCar(Long carId, CarDto carDto) throws IOException;

    void deleteCar(Long carId);

    CarsDtoList searchCars(SearchCarDto searchCarDto);

    List<BookCarDto> getBookings();

    boolean changeBookingStatus(Long bookingId, String status);

}
