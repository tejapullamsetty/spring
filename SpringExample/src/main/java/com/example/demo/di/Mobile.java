package com.example.demo.di;

import org.springframework.stereotype.Component;

@Component
public class Mobile {
	private String brand;
	private int mid;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public Mobile() {
		super();
	}
	
	public void showMobile() {
		System.out.println("This is in mobile class");
	}
	

}
