
public class Converter {

    Integer countCcal(Integer steps) {
        Integer ccal = (steps * 50) / 1000;

        return ccal;
    }

    int countDistanceInKilometrs(Integer steps) {
        double distance = (steps * 0.75) / 1000;
        int intDist = (int)distance;

        return intDist;
    }
}
