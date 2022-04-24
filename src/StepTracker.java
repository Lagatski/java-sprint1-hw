import java.util.HashMap;

public class StepTracker {
    private static HashMap<Integer, int[]> stepsByMonth;
    private static Converter converter;
    private static Integer stepLimit;
    public StepTracker() {
        converter = new Converter();
        stepsByMonth = new HashMap<>();

        for (int i = 1; i <= 12; i++) {
            int[] stepsInDay = new int[31];
            stepsByMonth.put(i, stepsInDay);
        }

        stepLimit = 10000;
    }

    public void addStepInMonth(Integer month, Integer numOfDay, Integer stepsCount) {
        int[] steps = stepsByMonth.get(month);

        steps[numOfDay] += stepsCount;

        stepsByMonth.put(month, steps);
    }

    public void addStepInMonth(Integer newStepLimit) {
        stepLimit = newStepLimit;

        System.out.println("Новая цель по шагам в день: " + stepLimit);
    }

    public void printStatistics(Integer month) {
        int[] steps = stepsByMonth.get(month);
        int sum = 0;
        int max = 0;
        int bestSeries = 0;
        int count = 0;

        for (int i = 1; i <= 30; i++) {
            System.out.print(i + " день: " + steps[i]);
            if (i != 30)
                System.out.print(", ");
            else
                System.out.print("\n");
            if (steps[i] > max)
                max = steps[i];

            if (steps[i] >= stepLimit) {
                count += 1;
            } else if (count > bestSeries) {
                bestSeries = count;
                count = 0;
            }
            if (i == 30 && count > 0 && count > bestSeries) {
                bestSeries = count;
            }
            sum += steps[i];
        }

        System.out.println("Общее количество шагов за месяц: " + sum);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + max);
        System.out.println("Среднее количество шагов за день: " + (sum / 30));
        System.out.println("Пройденная дистанция (в км): " + converter.countDistanceInKilometers(sum));
        System.out.println("Количество сожжённых килокалорий: " + converter.countCcal(sum));
        System.out.println("Лучшая серия: " + bestSeries);
    }
}
