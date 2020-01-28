package Planes;

import java.util.Objects;

abstract public class Plane {
    private String  model;
    private int     maxSpeed;
    private int     maxFlightDistance;
    private int     maxLoadCapacity;

    public Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {

        this.maxFlightDistance  = maxFlightDistance;
        this.maxLoadCapacity    = maxLoadCapacity;
        this.maxSpeed           = maxSpeed;
        this.model              = model;
    }

    public String getModel() {
        return model;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public Integer getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMaxLoadCapacity() {
        return this.maxLoadCapacity;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}
