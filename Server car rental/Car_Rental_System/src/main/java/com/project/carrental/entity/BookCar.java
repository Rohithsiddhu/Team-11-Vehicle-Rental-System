package com.project.carrental.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.carrental.dto.BookCarDto;
import com.project.carrental.enums.BookCarStatus;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data
public class BookCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fromDate;

    private Date toDate;

    private Long days;

    private Long price;
    
    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Long getDays() {
		return days;
	}

	public void setDays(Long days) {
		this.days = days;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public BookCarStatus getBookCarStatus() {
		return bookCarStatus;
	}

	public void setBookCarStatus(BookCarStatus bookCarStatus) {
		this.bookCarStatus = bookCarStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	private BookCarStatus bookCarStatus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Car car;

    public BookCarDto getBookCarDto() {
        BookCarDto bookCarDto = new BookCarDto();
        bookCarDto.setId(id);
        bookCarDto.setFromDate(fromDate);
        bookCarDto.setToDate(toDate);
        bookCarDto.setDays(days);
        bookCarDto.setPrice(price);
        bookCarDto.setBookCarStatus(bookCarStatus);
        bookCarDto.setCarId(car.getId());
        bookCarDto.setUserId(user.getId());
        bookCarDto.setEmail(user.getEmail());
        bookCarDto.setUsername(user.getName());
        return bookCarDto;
    }
}

