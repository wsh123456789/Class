package com.wsh.bean;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean  implements FactoryBean<Car> {
	
	private String carInfo;

	@Override
	public Car getObject() throws Exception {
		Car car = new Car();
		String[] infoArr = carInfo.split(",");
		car.setColor(infoArr[0]);
		car.setPrice(infoArr[1]);
		car.setMaxSpeed(infoArr[2]);
		System.out.println("getObject方法————————");
		return car;
	}

	@Override
	public Class<Car> getObjectType() {
		System.out.println("getObjectType方法————————");
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	/**
	 * 功能描述：给carInfo属性注入指定值。(xml方式注入值)
	 *
	 * @param carInfo 值
	 */
	public void setCarInfo(String carInfo) {
		System.out.println("setCarInfo方法————————");
		this.carInfo = carInfo;
	}

}
