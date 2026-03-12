package DZ_5;

import javax.swing.SwingUtilities;

public class Main {
    static void main() {
        // Запускаем GUI в специальном потоке для Swing
        SwingUtilities.invokeLater(() -> {
            EmployeeGUI gui = new EmployeeGUI();
            gui.setVisible(true); // Делаем окно видимым
        });
    }
}
