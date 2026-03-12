package DZ_5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class EmployeeGUI extends JFrame {
    private final EmployeeDirectory directory = new EmployeeDirectory();

    // Элементы интерфейса
    private final DefaultTableModel tableModel;
    private final JTable table;
    private final JTextField txtName, txtPhone, txtExp, txtId;
    private final JTextArea txtOutput;

    public EmployeeGUI() {
        settings(); // Настройка окна

        this.txtId = new JTextField();
        this.txtName = new JTextField();
        this.txtPhone = new JTextField();
        this.txtExp = new JTextField();
        this.txtOutput = new JTextArea(5, 20); // Поле для текстового вывода результатов поиска
        this.tableModel = new DefaultTableModel(getColumns(), 0); // Центральная панель: таблица
        this.table = new JTable(tableModel);

        JPanel inputPanel = new JPanel(new GridLayout(2, 5, 5, 5));
        JButton btnAdd = new JButton("Добавить");

        addElementsToPanelTop(inputPanel, btnAdd); // Верхняя панель: форма добавления

        JScrollPane scrollTable = new JScrollPane(table);
        JPanel searchPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        JTextField txtSearchExp = new JTextField();
        JButton btnSearchExp = new JButton("Найти по стажу");
        JTextField txtSearchName = new JTextField();
        JButton btnSearchPhone = new JButton("Найти телефон по имени");
        JTextField txtSearchId = new JTextField();
        JButton btnSearchId = new JButton("Найти по таб. номеру");

        addElementsToBottomPanel(searchPanel, txtSearchExp, btnSearchExp,
                txtSearchName, btnSearchPhone, txtSearchId, btnSearchId); // Нижняя панель: поиск

        txtOutput.setEditable(false);
        txtOutput.setBackground(new Color(240, 240, 240));
        JScrollPane scrollOutput = new JScrollPane(txtOutput);

        JPanel topContainer = new JPanel(new BorderLayout());
        JPanel bottomContainer = new JPanel(new BorderLayout());

        createTopAndBottomContainer(topContainer, bottomContainer, inputPanel, scrollTable,
                searchPanel, scrollOutput); // Сборка интерфейса

        buttonListeners(btnAdd, btnSearchExp, btnSearchPhone, btnSearchId, txtSearchExp, txtSearchName, txtSearchId); // Слушатели кнопок
        // Предзаполнение данными
        initData();
        setVisible(true);
    }

    //Настройки окна "Справочник сотрудников"
    private void settings() {
        setTitle("Справочник сотрудников");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
    }

    // Метод создания верхней панели: форма добавления
    private void addElementsToPanelTop(JPanel inputPanel, JButton btnAdd) {
        inputPanel.setBorder(BorderFactory.createTitledBorder("Добавить нового сотрудника"));
        inputPanel.add(new JLabel("Таб. номер:"));
        inputPanel.add(new JLabel("Имя:"));
        inputPanel.add(new JLabel("Телефон:"));
        inputPanel.add(new JLabel("Стаж (лет):"));
        inputPanel.add(new JLabel("")); // Заглушка
        inputPanel.add(txtId);
        inputPanel.add(txtName);
        inputPanel.add(txtPhone);
        inputPanel.add(txtExp);
        inputPanel.add(btnAdd);
    }

    private String[] getColumns() {
        return new String[]{"Таб. №", "Имя", "Телефон", "Стаж"};
    }

    private void addElementsToBottomPanel(JPanel searchPanel, JTextField txtSearchExp,
                                                 JButton btnSearchExp, JTextField txtSearchName,
                                                 JButton btnSearchPhone, JTextField txtSearchId,
                                                 JButton btnSearchId) {
        searchPanel.setBorder(BorderFactory.createTitledBorder("Поиск и фильтрация"));
        searchPanel.add(new JLabel("Введите стаж:"));
        searchPanel.add(txtSearchExp);
        searchPanel.add(btnSearchExp);
        searchPanel.add(new JLabel("Введите имя:"));
        searchPanel.add(txtSearchName);
        searchPanel.add(btnSearchPhone);
        searchPanel.add(new JLabel("Введите таб. №:"));
        searchPanel.add(txtSearchId);
        searchPanel.add(btnSearchId);
    }

    private void createTopAndBottomContainer(JPanel topContainer, JPanel bottomContainer,
                                             JPanel inputPanel, JScrollPane scrollTable,
                                             JPanel searchPanel, JScrollPane scrollOutput) {
        topContainer.add(inputPanel, BorderLayout.NORTH);
        topContainer.add(scrollTable, BorderLayout.CENTER);
        add(topContainer, BorderLayout.CENTER);
        bottomContainer.add(searchPanel, BorderLayout.NORTH);
        bottomContainer.add(scrollOutput, BorderLayout.SOUTH);
        add(bottomContainer, BorderLayout.SOUTH);
    }

    private void buttonListeners(JButton btnAdd, JButton btnSearchExp, JButton btnSearchPhone,
                                 JButton btnSearchId, JTextField txtSearchExp, JTextField txtSearchName,
                                 JTextField txtSearchId) {
        // Кнопка ДОБАВИТЬ
        btnAdd.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String name = txtName.getText();
                String phone = txtPhone.getText();
                int exp = Integer.parseInt(txtExp.getText());

                Employee emp = new Employee(id, phone, name, exp);
                directory.addEmployees(emp);
                updateTable();
                clearInputs();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ошибка: ID и Стаж должны быть числами!");
            }
        });

        // Поиск по стажу
        btnSearchExp.addActionListener(e -> {
            try {
                int exp = Integer.parseInt(txtSearchExp.getText());
                List<Employee> result = directory.findEmployeeByExperience(exp);
                showResult("Сотрудники со стажем " + exp + ":", result);
            } catch (NumberFormatException ex) {
                txtOutput.setText("Введите корректное число в поле стажа");
            }
        });

        // Поиск телефона по имени
        btnSearchPhone.addActionListener(e -> {
            String name = txtSearchName.getText();
            String phones = directory.telephoneNumberReturn(name);
            txtOutput.setText("Телефоны для " + name + ":\n" + (phones.isEmpty() ? "Не найдено" : phones));
        });

        // Поиск по табельному номеру
        btnSearchId.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtSearchId.getText());
                List<Employee> result = directory.findEmployeeByPersonnelNumber(id);
                showResult("Результат по номеру " + id + ":", result);
            } catch (NumberFormatException ex) {
                txtOutput.setText("Введите корректный номер");
            }
        });
    }


    private void initData() {
        directory.addEmployees(new Employee(1, "89851233958","Михаил", 23));
        directory.addEmployees(new Employee(2, "89169780401","Юлия", 18));
        directory.addEmployees(new Employee(3, "89805374714","Ирина", 40));
        updateTable();
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (Employee e : directory.getEmployeeList()) {
            tableModel.addRow(new Object[]{e.getPersonnelNumber(), e.getName(), e.getTelephoneNumber(), e.getExperience()});
        }
    }

    private void showResult(String title, List<Employee> list) {
        StringBuilder sb = new StringBuilder(title + "\n");
        if (list.isEmpty()) {
            sb.append("Ничего не найдено.");
        } else {
            list.forEach(e -> sb.append(e.toString()).append("\n"));
        }
        txtOutput.setText(sb.toString());
    }

    private void clearInputs() {
        txtId.setText("");
        txtName.setText("");
        txtPhone.setText("");
        txtExp.setText("");
    }
}