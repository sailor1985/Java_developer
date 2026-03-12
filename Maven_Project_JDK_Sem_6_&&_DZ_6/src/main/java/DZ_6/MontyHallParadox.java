package DZ_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {
    // Генератор случайных чисел для выбора дверей
    private final Random random = new Random();

    /**
     * Запускает цикл тестов
     * @param totalTests количество итераций (например, 1000)
     * @param switchChoice менять ли дверь игроку? (true/false)
     */
    public Map<Integer, GameResult> runSimulation(int totalTests, boolean switchChoice) {
        // Создаем карту (словарь) для хранения результатов: номер попытки -> победа/проигрыш
        Map<Integer, GameResult> results = new HashMap<>();

        // Цикл проходит столько раз, сколько указано в totalTests
        for (int i = 1; i <= totalTests; i++) {
            // Запускаем одну игру и записываем результат в карту под номером i
            results.put(i, playSingleGame(switchChoice));
        }
        // Возвращаем собранную коллекцию результатов
        return results;
    }

    // Внутренний метод для логики одной игры
    private GameResult playSingleGame(boolean switchChoice) {
        // Случайно ставим автомобиль за одну из дверей: 0, 1 или 2
        int carPosition = random.nextInt(3);
        // Игрок делает свой первый случайный выбор двери: 0, 1 или 2
        int initialChoice = random.nextInt(3);

        // Переменная для двери, которую откроет ведущий (Монти)
        int montyShow;
        do {
            // Ведущий выбирает дверь от 0 до 2
            montyShow = random.nextInt(3);
            // Цикл повторяется, пока дверь ведущего совпадает с машиной ИЛИ с выбором игрока
            // Ведущий ОБЯЗАН открыть дверь с козой и не ту, что выбрал игрок
        } while (montyShow == carPosition || montyShow == initialChoice);

        // Переменная для окончательного выбора игрока
        int finalChoice;
        // Если стратегия подразумевает смену двери
        if (switchChoice) {
            // Сумма индексов дверей (0+1+2) = 3.
            // Чтобы найти оставшуюся третью дверь, вычитаем из 3 текущий выбор и дверь ведущего.
            finalChoice = 3 - initialChoice - montyShow;
        } else {
            // Если игрок упрямый — он остается при своем первом выборе
            finalChoice = initialChoice;
        }

        // Если итоговый выбор совпал с позицией авто — возвращаем WIN (Победа), иначе LOSS (Поражение)
        return (finalChoice == carPosition) ? GameResult.WIN : GameResult.LOSS;
    }

    // Метод для анализа и вывода итогов в консоль
    public void printStatistics(Map<Integer, GameResult> results) {
        // Считаем количество побед: фильтруем значения карты по статусу WIN и считаем их
        long wins = results.values().stream().filter(r -> r == GameResult.WIN).count();
        // Поражения — это размер всего списка минус количество побед
        long losses = results.size() - wins;
        // Вычисляем процент побед (приводим к double, чтобы не потерять точность)
        double winRate = (double) wins / results.size() * 100;

        // Печатаем красиво оформленную строку со статистикой
        System.out.printf("Всего игр: %d | Побед: %d | Поражений: %d | Процент побед: %.2f%%%n",
                results.size(), wins, losses, winRate);
    }
}