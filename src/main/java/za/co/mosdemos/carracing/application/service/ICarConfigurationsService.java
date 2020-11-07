package za.co.mosdemos.carracing.application.service;

import za.co.mosdemos.carracing.domain.objectmodel.Car;

import java.util.List;

public interface ICarConfigurationsService {
    List<Car> loadCars();
}
