package DZ_6;

import java.util.Map;

public class Main {
    static void main() {
        int tests = 1000;
        MontyHallParadox simulator = new MontyHallParadox();

        System.out.println("--- Стратегия: ВСЕГДА МЕНЯТЬ выбор ---");
        Map<Integer, GameResult> switchResults = simulator.runSimulation(tests, true);
        simulator.printStatistics(switchResults);

        System.out.println("\n--- Стратегия: НИКОГДА НЕ МЕНЯТЬ выбор ---");
        Map<Integer, GameResult> stayResults = simulator.runSimulation(tests, false);
        simulator.printStatistics(stayResults);

        // Если нужно вывести первые 10 шагов (чтобы не спамить в консоль 1000 строк)
        System.out.println("\nДетализация первых 10 игр (при смене двери):");
        switchResults.entrySet().stream().limit(10).forEach(entry ->
                System.out.println("Шаг " + entry.getKey() + ": " + entry.getValue())
        );
    }
}
