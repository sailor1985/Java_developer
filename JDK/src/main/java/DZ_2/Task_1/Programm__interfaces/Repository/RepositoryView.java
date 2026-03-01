package DZ_2.Task_1.Programm__interfaces.Repository;

public interface RepositoryView {
    void saveLogToFile(String text);
    String readLogFromFile();
}
