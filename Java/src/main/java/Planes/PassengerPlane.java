package Planes;

import java.util.Objects;

public class PassengerPlane extends Plane{

    private int passengersCapacity;

    public PassengerPlane(
            String  model,
            Integer maxSpeed,
            Integer maxFlightDistance,
            Integer maxLoadCapacity,
            Integer passengersCapacity)
    {

        super(
                model,
                maxSpeed,
                maxFlightDistance,
                maxLoadCapacity
        );

        this.passengersCapacity = passengersCapacity;
    }


    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengersCapacity=" + passengersCapacity +
                '}');
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof PassengerPlane)) return false;
//        if (!super.equals(o)) return false;
//        PassengerPlane plane = (PassengerPlane) o;
//        return passengersCapacity == plane.passengersCapacity;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
