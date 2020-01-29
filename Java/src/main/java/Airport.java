import models.MilitaryType;
import Planes.ExperimentalPlane;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {

    private List<? extends Plane> allPlanesList;

    public Airport(List<? extends Plane> allPlanesList) {
        this.allPlanesList = allPlanesList;
    }

    public List<? extends Plane> getPlanes() {
        return allPlanesList;
    }

    public List<PassengerPlane> getPassengerPlanes() {

        return allPlanesList.stream()
                .filter(PassengerPlane.class::isInstance)
                .map(PassengerPlane.class::cast)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {

        return allPlanesList.stream()
                .filter(MilitaryPlane.class::isInstance)
                .map(MilitaryPlane.class::cast)
                .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {

        return allPlanesList.stream()
                .filter(ExperimentalPlane.class::isInstance)
                .map(ExperimentalPlane.class::cast)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {

        return getMilitaryPlanes().stream()
                .filter(plane -> plane.getType() == MilitaryType.TRANSPORT)
                .collect(Collectors.toList());

    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {

        return getMilitaryPlanes().stream()
                .filter(plane -> plane.getType() == MilitaryType.BOMBER)
                .collect(Collectors.toList());

    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {

        PassengerPlane planeWithMaxCapacity =
                Collections.max(getPassengerPlanes(),
                        Comparator.comparing(PassengerPlane::getPassengersCapacity));

        return planeWithMaxCapacity;
    }

    public Airport sortByMaxDistance() {

        Collections.sort(allPlanesList, Comparator.comparingInt(Plane::getMaxFlightDistance));
        return this;
    }

    public Airport sortByMaxSpeed() {

        Collections.sort(allPlanesList, Comparator.comparingInt(Plane::getMaxSpeed));
        return this;
    }

    public Airport sortByMaxLoadCapacity() {

        Collections.sort(allPlanesList, Comparator.comparingInt(Plane::getMaxLoadCapacity));
        return this;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + allPlanesList.toString() +
                '}';
    }

}
