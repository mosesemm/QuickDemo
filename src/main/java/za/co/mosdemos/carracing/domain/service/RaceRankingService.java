package za.co.mosdemos.carracing.domain.service;

import org.springframework.stereotype.Service;
import za.co.mosdemos.carracing.domain.objectmodel.Car;
import za.co.mosdemos.carracing.domain.objectmodel.CarScore;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RaceRankingService implements IRaceRankingService {

    @Override
    public List<CarScore>  firstNumberOfCars(Map<Car, Double> carScores, int number) {
        return carScores.entrySet().stream()
                .map(carScoreEntry ->  new CarScore(carScoreEntry.getKey(), carScoreEntry.getValue()))
                .sorted()
                .limit(number)
                .collect(Collectors.toList());
    }
}
