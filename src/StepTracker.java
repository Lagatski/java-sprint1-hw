import java.util.HashMap;

public class StepTracker {
    HashMap<Integer, int[]> stepsByMounth;
    Converter converter;
    Integer stepLimit;
    StepTracker() {
        converter = new Converter();
        stepsByMounth = new HashMap<>();

        for (int i = 1; i <= 12; i++) {
            int[] stepsInDay = new int[31];

            for (int j = 0; j < 31; j++) {
                stepsInDay[j] = 0;
            }
            stepsByMounth.put(i, stepsInDay);
        }

        stepLimit = 10000;
    }

    void addStepInMounth(Integer mounth, Integer numOfDay, Integer stepsCount) {
        int[] steps = stepsByMounth.get(mounth);

        steps[numOfDay] += stepsCount;

        stepsByMounth.put(mounth, steps);
    }

    void addStepInMounth(Integer newStepLimit) {
        stepLimit = newStepLimit;

        System.out.println("Новый лимит шагов: " + stepLimit + " в день ");
    }

    void printStatistics(Integer mounth) {
        int[] steps = stepsByMounth.get(mounth);
        int sum = 0;
        int max = 0;
        int bestSeries = 0;
        int count = 1;

        for (int i = 1; i <= 30; i++) {
            System.out.print(i + " день: " + steps[i]);
            if (i != 30)
                System.out.print(", ");
            else
                System.out.print("\n");
            if (steps[i] > max)
                max = steps[i];
            if (i > 1 && i <= 30 && steps[i] >= stepLimit && steps[i - 1] >= stepLimit) {
                count += 1;
            } else if (count > 1 && count > bestSeries) {
                bestSeries = count;
                count = 1;
            }
            if (i == 30 && count > 1) {
                bestSeries = count;
            }
            sum += steps[i];
        }

        System.out.println("Общее количество шагов за месяц: " + sum);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + max);
        System.out.println("Среднее количество шагов за день: " + (sum / 30));
        System.out.println("Пройденная дистанция (в км): " + converter.countDistanceInKilometrs(sum));
        System.out.println("Количество сожжённых килокалорий: " + converter.countCcal(sum));
        System.out.println("Лучшая серия: " + bestSeries);
    }
}
