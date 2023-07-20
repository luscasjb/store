import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limit = read.nextDouble();
        CreditCard card = new CreditCard(limit);

        int out = 1;
        while(out != 0) {
            System.out.println("Digite a descrição da compra:");
            String description = read.next();

            System.out.println("Digite o valor da compra:");
            double valor = read.nextDouble();

            Purchase purchase = new Purchase(description, valor);
            boolean purchaseMade = card.throwBuy(purchase);

            if (purchaseMade) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                out = read.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                out = 0;
            }
        }

        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");
        Collections.sort(card.getBuy());
        for (Purchase c : card.getBuy()) {
            System.out.println(c.getDescription() + " - " +c.getValue());
        }
        System.out.println("\n***********************");

        System.out.println("\nSaldo do cartão: " + card.getBalance());

    }
}