package Training_Roadmap_sh.Variables_operators_control_structures.Task_3_Encapsulation_Inheritance_Polymorphism;

public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String expirationDate;
    public CreditCardPayment(double amount, String cardNumber, String expirationDate) {
        super(amount);
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }
    @Override
    public void processPayment() {
        System.out.println("Обработка платежа кредитной картой " + cardNumber + " на сумму: " + amount);
        // Здесь могла бы быть логика взаимодействия с платежным шлюзом
    }
}
