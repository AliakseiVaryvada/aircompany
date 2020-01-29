package Planes;

import models.ClassificationLevel;
import models.ExperimentalTypes;

public class ExperimentalPlane extends Plane{

    private ExperimentalTypes   experimentalType;
    private ClassificationLevel classificationLevel;


    public ExperimentalPlane(
            String              model,
            Integer             maxSpeed,
            Integer             maxFlightDistance,
            Integer             maxLoadCapacity,
            ExperimentalTypes   experimentalType,
            ClassificationLevel classificationLevel
    ){
        super(
                model,
                maxSpeed,
                maxFlightDistance,
                maxLoadCapacity
        );

        this.experimentalType =     experimentalType;
        this.classificationLevel =  classificationLevel;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }
    public ExperimentalTypes getExperimentalType(){
        return experimentalType;
    }
    public void setClassificationLevel(ClassificationLevel classificationLevel){
        this.classificationLevel = classificationLevel;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + getModel() + '\'' +
                '}';
    }
}
