package Training_Roadmap_sh.Variables_operators_control_structures.Task_3_Encapsulation_Inheritance_Polymorphism;

// Оплата через PayPal
public class PayPalPayment extends Payment {
    private String email;
    public PayPalPayment(double amount, String email) {
        super(amount);
        this.email = email;
    }
    @Override
    public void processPayment() {
        System.out.println("Обработка платежа PayPal через " + email + " на сумму: " + amount);
        // Здесь могла бы быть логика взаимодействия с API PayPal
    }
}
