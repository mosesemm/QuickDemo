package za.co.mosdemos.carracing.domain.objectmodel;

public class CarBuilder {
    private String name;
    private int acceleration;
    private int braking;
    private int cornerAbility;
    private int topSpeed;

    public CarBuilder(String name){
        this.name = name;
    }

    public CarBuilder acceleration(int acceleration) {
        this.acceleration = acceleration;
        return this;
    }

    public CarBuilder braking(int braking) {
        this.braking = braking;
        return this;
    }
    public CarBuilder corneringAbility(int cornerAbility) {
        this.cornerAbility = cornerAbility;
        return this;
    }

    public CarBuilder topSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
        return this;
    }

    public Car build() {
        Car car = new Car();
        car.setName(this.name);

        //it should at least have one of the attributes set
        if(this.acceleration == 0 && this.braking == 0
                && this.cornerAbility == 0 && this.topSpeed == 0) {
            throw new IllegalStateException("At least one of the car attributes should be set");
        }

        car.setAcceleration(this.acceleration);
        car.setBraking(this.braking);
        car.setCornerAbility(this.cornerAbility);
        car.setTopSpeed(this.topSpeed);
        return car;
    }
}
