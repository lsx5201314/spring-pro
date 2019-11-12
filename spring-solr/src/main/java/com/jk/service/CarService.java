package com.jk.service;

import com.jk.model.Car;

public interface CarService {
    Car addCar(Car car);

    void deleteCar(String id);
}
