package za.co.mosdemos.carracing.domain.service;

import za.co.mosdemos.carracing.domain.objectmodel.Car;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ICarRacingService {
    Optional<Map<Car, Double>> start(Optional<List<Car>> cars, Optional<String> patterns);
}
