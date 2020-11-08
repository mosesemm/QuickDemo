package za.co.mosdemos.carracing.domain.objectmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "track")
public class RaceTrack {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Column(name = "patterns", nullable = false, length = 255)
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
