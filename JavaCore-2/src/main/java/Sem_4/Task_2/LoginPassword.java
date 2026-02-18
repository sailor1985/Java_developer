package Sem_4.Task_2;
/*
1. Создать статический метод, который принимает на вход три параметра: login, password и confirmPassword.
2.Длина login должна быть меньше 20 символов. Если login не соответствует этому требованию, необходимо выбросить WrongLoginException.
3. Длина password должна быть не меньше 20 символов. Также password и confirmPas (confirmPassword) должны быть равны.
Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
 */
public class LoginPassword {

    public LoginPassword(String login, String password, String confirmPassword) {
        //login, password и confirmPassword
    }

    public static boolean checkLoginPassword(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        try {
            if (login.length() >= 20) {
                throw new WrongLoginException("менее 20", String.valueOf(login.length()));
            } else if (password.length() < 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("20", String.valueOf(password.length()));
            }
            // Если код дошел до этой строки, значит ни один throw не сработал.
            // Значит всё верно.
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            //e.printStackTrace();
            //return false;
            System.out.println("Ошибка: " + e.getMessage());
        }
        return false;
    }
}