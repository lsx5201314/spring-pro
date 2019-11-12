/**
 * @ClassNameCar
 * @Description
 * @Author
 * @Date2019/11/7 16:51
 * @Version V1.0
 **/

package com.jk.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable {
    private static final long serialVersionUID = -1387734664159352526L;
    private Integer carId;
    private String carName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date carDate;
    private Integer typeId;
    private Double carPrice;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Date getCarDate() {
        return carDate;
    }

    public void setCarDate(Date carDate) {
        this.carDate = carDate;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }
}