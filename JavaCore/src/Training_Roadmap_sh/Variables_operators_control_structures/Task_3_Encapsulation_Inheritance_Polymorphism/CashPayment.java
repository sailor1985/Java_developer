package Training_Roadmap_sh.Variables_operators_control_structures.Task_3_Encapsulation_Inheritance_Polymorphism;

// Оплата наличными
public class CashPayment extends Payment {
    public CashPayment(double amount) {
        super(amount);
    }
    @Override
    public void processPayment() {
        System.out.println("Обработка платежа наличными на сумму: " + amount + ". Требуется подтверждение.");
    }
}