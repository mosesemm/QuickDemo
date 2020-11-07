package za.co.mosdemos.carracing.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.mosdemos.carracing.application.repository.ITrackConfigurationRepository;
import za.co.mosdemos.carracing.domain.objectmodel.RaceTrack;

import java.util.List;

@Service
public class TrackConfigurationService implements ITrackConfigurationService {

    @Autowired
    private ITrackConfigurationRepository trackConfigurationRepository;

    @Override
    public List<RaceTrack> loadTracks() {
        return trackConfigurationRepository.loadTracks();
    }
}
