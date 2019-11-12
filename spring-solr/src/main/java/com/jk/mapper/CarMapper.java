package com.jk.mapper;

import com.jk.model.Car;
import org.apache.ibatis.annotations.Param;

public interface CarMapper {
    void addCar(Car car);

    void deleteCar(@Param("id") String id);

    void updateCar(Car car);
}
