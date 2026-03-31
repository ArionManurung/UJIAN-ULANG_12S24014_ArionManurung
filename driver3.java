package academic.driver;

import fintech.model.*;
import java.util.*;

public class Driver3 {

    public static void main(String[] _args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("---")) break;

            String[] p = input.split("#");

            if (p[0].equals("create-account")) {
                accounts.put(p[2], new Account(p[1], p[2]));
            }

            else if (p[0].equals("deposit")) {
                accounts.get(p[1]).deposit(Double.parseDouble(p[2]));
            }

            else if (p[0].equals("transfer")) {
                Account sender = accounts.get(p[1]);
                Account receiver = accounts.get(p[2]);
                double amt = Double.parseDouble(p[3]);

                // pakai boolean
                if (sender.withdraw(amt)) {
                    receiver.deposit(amt);
                }
            }
        }

        for (Account acc : accounts.values()) {
            System.out.println(acc.getUsername() + "|" +
                               acc.getName() + "|" +
                               acc.getBalance());
        }
    }
}