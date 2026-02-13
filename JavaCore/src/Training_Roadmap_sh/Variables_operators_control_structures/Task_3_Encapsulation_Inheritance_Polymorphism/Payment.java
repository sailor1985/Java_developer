package Training_Roadmap_sh.Variables_operators_control_structures.Task_3_Encapsulation_Inheritance_Polymorphism;

public class Payment {
    // Базовый класс платежа
        protected double amount;
        public Payment(double amount) {
            this.amount = amount;
        }
        public void processPayment() {
            System.out.println("Обработка общего платежа на сумму: " + amount);
        }
}