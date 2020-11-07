package za.co.mosdemos.carracing.domain.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import za.co.mosdemos.carracing.BaseUnitTest;
import za.co.mosdemos.carracing.configurations.UnitTestConfiguration;
import za.co.mosdemos.carracing.domain.objectmodel.Car;
import za.co.mosdemos.carracing.domain.objectmodel.CarBuilder;
import za.co.mosdemos.carracing.domain.objectmodel.CarScore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Import(UnitTestConfiguration.class)
public class RaceRankingServiceTests extends BaseUnitTest {

    @Autowired
    private IRaceRankingService raceRankingService;

    @Test
    public void testTop3Rank() {
        Car corv = new CarBuilder("CORV")
                .acceleration(8)
                .braking(3)
                .corneringAbility(4)
                .topSpeed(9)
                .build();
        Car gtr = new CarBuilder("GTR")
                .acceleration(6)
                .braking(7)
                .corneringAbility(9)
                .topSpeed(8)
                .build();

        Map<Car, Double> carScoresMapping = new HashMap<>();
        carScoresMapping.put(corv, new Double(65));
        carScoresMapping.put(gtr, new Double(74));
        List<CarScore> carScores = raceRankingService.firstNumberOfCars(carScoresMapping, 3);
        assertThat(carScores.size() > 0).isTrue();
        assertThat(carScores.size()).isLessThanOrEqualTo(3);
        assertThat(carScores.get(0).getCar().getName()).isEqualTo("GTR");
        assertThat(carScores.get(1).getCar().getName()).isEqualTo("CORV");
    }
}
