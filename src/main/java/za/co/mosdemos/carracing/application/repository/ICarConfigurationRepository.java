package za.co.mosdemos.carracing.application.repository;

import za.co.mosdemos.carracing.domain.objectmodel.Car;

import java.util.List;

public interface ICarConfigurationRepository {
    List<Car> loadCars();
}
