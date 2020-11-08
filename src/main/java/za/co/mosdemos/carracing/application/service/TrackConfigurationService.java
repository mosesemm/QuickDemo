package za.co.mosdemos.carracing.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.mosdemos.carracing.application.repository.TrackConfigurationRepository;
import za.co.mosdemos.carracing.domain.objectmodel.RaceTrack;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackConfigurationService implements ITrackConfigurationService {

    @Autowired
    private TrackConfigurationRepository trackConfigurationRepository;

    @Override
    public List<RaceTrack> loadTracks() {
        List<RaceTrack> raceTracks = new ArrayList<>();
        trackConfigurationRepository.findAll().forEach(raceTracks::add);
        return raceTracks;
    }
}
