package com.wsh.bean;

public class Car {
	private String color;

    private String maxSpeed;

    private String price;

    
    public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getMaxSpeed() {
		return maxSpeed;
	}


	public void setMaxSpeed(String maxSpeed) {
		this.maxSpeed = maxSpeed;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	@Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", maxSpeed='" + maxSpeed + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
