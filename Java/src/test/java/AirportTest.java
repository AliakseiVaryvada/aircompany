import Planes.experimentalPlane;
import models.ClassificationLevel;
import models.ExperimentalTypes;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AirportTest {
    private static List<Plane> planesListForTest = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new experimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new experimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane(
            "Boeing-747",
            980,
            16100,
            70500,
            242
    );

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(planesListForTest);
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        boolean detectWrongType = false;
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            if ((militaryPlane.getType() != MilitaryType.TRANSPORT)) {
                detectWrongType = true;
                break;
            }
        }
        Assert.assertFalse(detectWrongType);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {

        Airport airport = new Airport(planesListForTest);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();

        Assert.assertEquals(expectedPlaneWithMaxPassengersCapacity.getPassengersCapacity(), 242);
    }

    @Test
    public void sortByMaxLoadCapacity() {
        Airport airport = new Airport(planesListForTest);
        List<? extends Plane> arrayForSort = airport.getPlanes();
        Assert.assertNotEquals(arrayForSort.get(0).getMaxLoadCapacity(), 500);
        Assert.assertNotEquals(arrayForSort.get(arrayForSort.size()-1).getMaxLoadCapacity(), 110000);

        airport.sortByMaxLoadCapacity();

        Assert.assertEquals(arrayForSort.get(0).getMaxLoadCapacity(), 500);
        Assert.assertEquals(arrayForSort.get(arrayForSort.size()-1).getMaxLoadCapacity(), 110000);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(planesListForTest);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        Assert.assertEquals(bomberMilitaryPlanes.size(), 3);
    }

    @Test
    public void testExperimentalPlanesWithClassificationLevel(){
        Airport airport = new Airport(planesListForTest);
        List<experimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        Assert.assertEquals(experimentalPlanes.size(), 2);
    }
}
