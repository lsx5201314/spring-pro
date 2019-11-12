/**
 * @ClassNameCarServiceImpl
 * @Description
 * @Author
 * @Date2019/11/11 17:28
 * @Version V1.0
 **/

package com.jk.service.impl;


import com.jk.mapper.CarMapper;
import com.jk.model.Car;
import com.jk.service.CarService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public Car addCar(Car car) {
        if (car.getCarId()==null){
            carMapper.addCar(car);
        }else {
            carMapper.updateCar(car);
        }
        return car;
    }

    @Override
    public void deleteCar(String id) {
        carMapper.deleteCar(id);
    }
}