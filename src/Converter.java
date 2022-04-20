
public class Converter {

    public static int countCcal(Integer steps) {
        int ccal = (steps * 50) / 1000;

        return ccal;
    }

    public static int countDistanceInKilometrs(Integer steps) {
        double distance = (steps * 0.75) / 1000;
        int intDist = (int)distance;

        return intDist;
    }
}
