package za.co.mosdemos.carracing.domain.objectmodel;

public class CarScore implements Comparable<CarScore> {
    private Car car;
    private double score;

    public CarScore() {
    }

    public CarScore(Car car, double score) {
        this.car = car;
        this.score = score;
    }

    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int compareTo(CarScore another) {
        return Double.compare(another.score, score);
    }
}
