package Training_Roadmap_sh.Variables_operators_control_structures.Task_3_Encapsulation_Inheritance_Polymorphism;

    public class PaymentProcessor {
        static void main() {
            // Создаем массив платежей разных типов
            Payment[] payments = new Payment[3];
            payments[0] = new CreditCardPayment(150.75, "1111-2222-3333-4444", "12/25");
            payments[1] = new PayPalPayment(75.00, "user@example.com");
            payments[2] = new CashPayment(25.50);

            for (Payment p : payments) {
                processSinglePayment(p);
            }

            System.out.println("---");
        }

        public static void processSinglePayment(Payment payment) {
            System.out.println("Начинаем обработку платежа...");
            payment.processPayment();
            System.out.println("Завершение обработки.");
        }
    }