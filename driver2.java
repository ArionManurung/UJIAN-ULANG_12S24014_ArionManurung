package smartwallet.driver;

import smartwallet.model.*;
import java.util.*;

public class Driver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Account> accounts = new ArrayList<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("---")) break;

            String[] p = input.split("#");

            if (p[0].equals("create-account")) {
                accounts.add(new Account(p[1], p[2], p[3]));
            }

            else if (p[0].equals("deposit")) {
                for (Account acc : accounts) {
                    if (acc.getUsername().equals(p[1])) {
                        Transaction t = new DepositTransaction(p[1], Double.parseDouble(p[2]), p[3], p[4]);
                        t.process(acc);
                    }
                }
            }

            else if (p[0].equals("withdraw")) {
                for (Account acc : accounts) {
                    if (acc.getUsername().equals(p[1])) {
                        Transaction t = new WithdrawTransaction(p[1], Double.parseDouble(p[2]), p[3], p[4]);
                        t.process(acc);
                    }
                }
            }
        }

        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }
}