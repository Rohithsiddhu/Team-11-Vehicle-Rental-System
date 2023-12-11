package com.project.carrental.controller;

import com.project.carrental.dto.BookCarDto;
import com.project.carrental.dto.CarDto;
import com.project.carrental.dto.SearchCarDto;
import com.project.carrental.entity.Car;
import com.project.carrental.services.admin.AdminService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
    AdminService adminService;

    //Admin can post a new car

    @PostMapping("/car")
    public ResponseEntity<?> addCar(@ModelAttribute CarDto carDto) {
        boolean success = adminService.addCar(carDto);
        if (success) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Admin can get all cars

    @GetMapping("/cars")
    public ResponseEntity<?> getAllCars() {
        return ResponseEntity.ok(adminService.getAllCars());
    }

    //Admin can get a single car

    @GetMapping("/car/{carId}")
    public ResponseEntity<?> getCarById(@PathVariable Long carId) {
        return ResponseEntity.ok(adminService.getCarById(carId));
    }

    //Admin can update a car
    @PostMapping("/car/{carId}")
    public ResponseEntity<?> updateCar(@PathVariable Long carId, @ModelAttribute CarDto carDto) {
        try {
            boolean success = adminService.updateCar(carId, carDto);
            if (success) {
                return ResponseEntity.status(HttpStatus.OK).build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (IOException e) {
            // Handle the exception appropriately, for example, by returning an error response.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Admin can delete a car

    @DeleteMapping("/car/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long carId) {
        adminService.deleteCar(carId);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/car/search")
    public ResponseEntity<?> searchCars(@RequestBody SearchCarDto searchCarDto) {
        return ResponseEntity.ok(adminService.searchCars(searchCarDto));
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<BookCarDto>> getBookings() {
        return ResponseEntity.ok(adminService.getBookings());
    }

    @GetMapping("/booking/{bookingId}/{status}")
    public ResponseEntity<?> changeBookingStatus(@PathVariable Long bookingId, @PathVariable String status) {
        boolean success = adminService.changeBookingStatus(bookingId, status);
        if (success) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

}

