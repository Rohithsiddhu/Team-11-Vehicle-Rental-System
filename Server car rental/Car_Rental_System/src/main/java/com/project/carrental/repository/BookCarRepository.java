package com.project.carrental.repository;

import com.project.carrental.*;
import com.project.carrental.entity.BookCar;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookCarRepository extends JpaRepository<BookCar,Long> {
    List<BookCar> findAllByUserId(Long userId);
}
