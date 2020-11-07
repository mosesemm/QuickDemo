package za.co.mosdemos.carracing.configurations;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import za.co.mosdemos.carracing.domain.service.CarRacingService;
import za.co.mosdemos.carracing.domain.service.ICarRacingService;
import za.co.mosdemos.carracing.domain.service.IRaceRankingService;
import za.co.mosdemos.carracing.domain.service.RaceRankingService;

@TestConfiguration
public class UnitTestConfiguration {

    @Bean
    public ICarRacingService carRacingService() {
        return new CarRacingService();
    }
    @Bean
    public IRaceRankingService raceRankingService() {
        return new RaceRankingService();
    }
}
