package za.co.mosdemos.carracing.domain.service;

import za.co.mosdemos.carracing.domain.objectmodel.Car;
import za.co.mosdemos.carracing.domain.objectmodel.CarScore;

import java.util.List;
import java.util.Map;

public interface IRaceRankingService {
    List<CarScore> firstNumberOfCars(Map<Car, Double> carScores, int number);
}
