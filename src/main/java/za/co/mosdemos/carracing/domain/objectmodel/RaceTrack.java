package za.co.mosdemos.carracing.domain.objectmodel;

public class RaceTrack {
    private long id;
    private String name;
    private String patterns;

    public RaceTrack(String name, String patterns) {
        this.name = name;
        this.patterns = patterns;
    }

    public RaceTrack() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatterns() {
        return patterns;
    }

    public void setPatterns(String patterns) {
        this.patterns = patterns;
    }
}
