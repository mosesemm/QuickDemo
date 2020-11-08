package za.co.mosdemos.carracing.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.mosdemos.carracing.domain.objectmodel.Car;
import za.co.mosdemos.carracing.domain.objectmodel.CarScore;
import za.co.mosdemos.carracing.domain.objectmodel.RaceTrack;
import za.co.mosdemos.carracing.domain.service.ICarRacingService;
import za.co.mosdemos.carracing.domain.service.IRaceRankingService;

import java.util.List;
import java.util.Optional;

@Service
public class RacingGameService implements IRacingGameService {

    @Autowired
    private ICarConfigurationsService carConfigurationsService;
    @Autowired
    private ITrackConfigurationService trackConfigurationService;
    @Autowired
    private ICarRacingService carRacingService;
    @Autowired
    private IRaceRankingService raceRankingService;

    @Override
    public List<RaceTrack> getRaceTracks() {
        return trackConfigurationService.loadTracks();
    }

    @Override
    public List<Car> getCars() {
        return carConfigurationsService.loadCars();
    }

    @Override
    public List<CarScore> startRace(Optional<List<Car>> cars, Optional<String> trackPatterns) {
        return raceRankingService.firstNumberOfCars(carRacingService.start(cars, trackPatterns).get(), 3);
    }
}
