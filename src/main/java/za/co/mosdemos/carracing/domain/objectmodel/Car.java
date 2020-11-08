package za.co.mosdemos.carracing.domain.objectmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Column(name = "acceleration", nullable = true)
    private int acceleration;
    @Column(name = "braking", nullable = true)
    private int braking;
    @Column(name = "corner_ability", nullable = true)
    private int cornerAbility;
    @Column(name = "top_speed", nullable = true)
    private int topSpeed;

    public Car() {
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

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getBraking() {
        return braking;
    }

    public void setBraking(int braking) {
        this.braking = braking;
    }

    public int getCornerAbility() {
        return cornerAbility;
    }

    public void setCornerAbility(int cornerAbility) {
        this.cornerAbility = cornerAbility;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
