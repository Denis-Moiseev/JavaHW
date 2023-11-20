package JavaHW;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = createManyLaptops();
        Map<Integer, Object> filteringCriteria = createCriteriaFiltering();

        Set<Laptop> result = filterLaptops(laptops, filteringCriteria);
        outputResult(result);
    }

    private static Set<Laptop> createManyLaptops() {
        Set<Laptop> laptops = new HashSet<>();

        laptops.add(new Laptop("MSI Modern 14", 8, 512, "Windows 10", "Красный"));
        laptops.add(new Laptop("MacBook Pro", 8, 256, "macOS", "Серый"));
        laptops.add(new Laptop("Lenovo ThinkPad", 16, 1000, "Windows 10", "Черный"));
        laptops.add(new Laptop("HP Pavilion", 16, 512, "Windows 10", "Синий"));

        return laptops;
    }

    private static Map<Integer, Object> createCriteriaFiltering() {
        try (Scanner scanner = new Scanner(System.in)) {
            Map<Integer, Object> filteringCriteria = new HashMap<>();

            System.out.println("Введите цифру, соответствующую необходимому критерию:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");

            int selectedCriteria = scanner.nextInt();
            filteringCriteria.put(selectedCriteria, requestMinimumValue(selectedCriteria));

            return filteringCriteria;
        }
    }

    private static Object requestMinimumValue(int criterion) {
        try (Scanner scanner = new Scanner(System.in)) {
            Object minValue = null;

            switch (criterion) {
                case 1:
                    System.out.print("Минимальный объем ОЗУ: ");
                    minValue = scanner.nextInt();
                    break;
                case 2:
                    System.out.print("Минимальный объем ЖД: ");
                    minValue = scanner.nextInt();
                    break;
                case 3:
                    System.out.print("Операционная система: ");
                    minValue = scanner.next();
                    break;
                case 4:
                    System.out.print("Цвет: ");
                    minValue = scanner.next();
                    break;
                default:
                    System.out.println("Неверный критерий.");
            }

            return minValue;
        }
    }

    private static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<Integer, Object> filteringCriteria) {
        Set<Laptop> result = new HashSet<>();

        for (Laptop laptop : laptops) {
            boolean SuitableAccordingToConditions = true;

            for (Map.Entry<Integer, Object> entry : filteringCriteria.entrySet()) {
                int criterion = entry.getKey();
                Object minValue = entry.getValue();

                switch (criterion) {
                    case 1:
                        if (laptop.getAmountOfRAM() < (int) minValue) {
                            SuitableAccordingToConditions = false;
                        }
                        break;
                    case 2:
                        if (laptop.getMemory() < (int) minValue) {
                            SuitableAccordingToConditions = false;
                        }
                        break;
                    case 3:
                        if (!laptop.getOS().equals(minValue)) {
                            SuitableAccordingToConditions = false;
                        }
                        break;
                    case 4:
                        if (!laptop.getColor().equals(minValue)) {
                            SuitableAccordingToConditions = false;
                        }
                        break;
                }

                if (!SuitableAccordingToConditions) {
                    break;
                }
            }

            if (SuitableAccordingToConditions) {
                result.add(laptop);
            }
        }

        return result;
    }

    private static void outputResult(Set<Laptop> result) {
        if (result.isEmpty()) {
            System.out.println("Нет ноутбуков, удовлетворяющих заданным критериям.");
        } else {
            System.out.println("Ноутбуки, удовлетворяющие заданным критериям:");
            for (Laptop laptop : result) {
                System.out.println(laptop);
            }
        }
    }
}