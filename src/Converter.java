
public class Converter {

    public int countCcal(Integer steps) {
        int ccal = (steps * 50) / 1000;

        return ccal;
    }

    public int countDistanceInKilometers(Integer steps) {
        double distance = (steps * 0.75) / 1000;
        int intDist = (int)distance;

        return intDist;
    }
}
