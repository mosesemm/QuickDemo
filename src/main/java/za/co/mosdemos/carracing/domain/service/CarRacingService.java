package za.co.mosdemos.carracing.domain.service;

import org.springframework.stereotype.Service;
import za.co.mosdemos.carracing.domain.objectmodel.*;

import java.util.*;

@Service
public class CarRacingService implements ICarRacingService {

    @Override
    public Optional<Map<Car, Double>> start(Optional<List<Car>> cars, Optional<String> patterns) {
        Map<Car, Double> results = new HashMap<>();
        patterns.orElseGet(String::new).chars()
                .mapToObj(i-> (char)i) // Convert to individual pattern characters
                .forEach(pattern -> {
                    cars.orElseGet(ArrayList::new).forEach(car -> { // calculate score for each car and pattern
                        results.merge(car, createCarScorePolicy(pattern).score(car), Double::sum);
                    });
                });

        return Optional.of(results);
    }

    private CarScorePolicy createCarScorePolicy(Character pattern) {
        if('1' == pattern) {
            return new StraightPattern();
        }
        else if('0' == pattern) {
            return new CornerPattern();
        }

        throw new IllegalArgumentException("Unknown pattern detected");
    }
}
