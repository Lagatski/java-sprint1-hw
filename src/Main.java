import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            switch(scanner.nextInt()) {

            case (1):
                System.out.println("Введите порядковый номер месяца, где 1 - Январь, а 12 - Декабрь:");
                Integer mounth = scanner.nextInt();
                while (mounth < 1 || mounth > 12) {
                    System.out.println("Вы ввели не корректный номер месяца, попробуйте ещё раз или введите '0' для выхода:");
                    mounth = scanner.nextInt();
                    if (mounth == 0) {
                        System.out.println("Выход из программы");
                        return;
                    }
                }

                System.out.println("Введите дату:");
                Integer numOfDay = scanner.nextInt();
                while (numOfDay < 1 || numOfDay > 30) {
                    System.out.println("Вы ввели не корректную дату, попробуйте ещё раз или введите '0' для выхода:");
                    numOfDay = scanner.nextInt();
                    if (numOfDay == 0) {
                        System.out.println("Выход из программы");
                        return;
                    }
                }

                System.out.println("Введите количество шагов в этот день:");
                Integer stepsCount = scanner.nextInt();
                while (stepsCount < 0) {
                    System.out.println("Вы ввели не корректное кол-во шагов, попробуйте ещё раз или введите '0' для выхода:");
                    stepsCount = scanner.nextInt();
                    if (stepsCount == 0) {
                        System.out.println("Выход из программы");
                        return;
                    }
                }

                stepTracker.addStepInMounth(mounth, numOfDay, stepsCount);
                break;
            case (2):
                System.out.println("Введите порядковый номер месяца за который хотите получить статистику, где 1 - Январь, а 12 - Декабрь:");
                mounth = scanner.nextInt();
                while (mounth < 1 || mounth > 12) {
                    System.out.println("Вы ввели не корректный номер месяца, попробуйте ещё раз или введите '0' для выхода:");
                    mounth = scanner.nextInt();
                    if (mounth == 0) {
                        System.out.println("Выход из программы");
                        return;
                    }
                }

                stepTracker.printStatistics(mounth);
                break;
            case (3):
                System.out.println("Введите новый лимит шагов в день:");
                Integer newStepControl = scanner.nextInt();
                while (newStepControl < 0) {
                    System.out.println("Вы установили не корректный лимит, попробуйте ещё раз или введите '0' для выхода:");
                    newStepControl = scanner.nextInt();
                    if (newStepControl == 0) {
                        System.out.println("Выход из программы");
                        return;
                    }
                }

                stepTracker.addStepInMounth(newStepControl);
                break;
            case (0):
                System.out.println("Программа завершена");
                return;
            default :
                System.out.println("Вы ввели не верное число, попробуйте снова:");
                break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}
