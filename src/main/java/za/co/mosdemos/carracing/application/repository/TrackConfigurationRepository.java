package za.co.mosdemos.carracing.application.repository;

import org.springframework.stereotype.Repository;
import za.co.mosdemos.carracing.domain.objectmodel.RaceTrack;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrackConfigurationRepository implements ITrackConfigurationRepository {

    @Override
    public List<RaceTrack> loadTracks() {
        List<RaceTrack> raceTracks = new ArrayList<>();
        raceTracks.add(new RaceTrack("Example track 1 ", "11001"));
        raceTracks.add(new RaceTrack("Example track 2", "110014434"));
        raceTracks.add(new RaceTrack("Example track 3", "110015454"));
        return raceTracks;
    }
}
