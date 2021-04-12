package clean;

import clean.account.Account;
import clean.account.AccountImpl;
import clean.model.Amount;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Account account = new AccountImpl();

        account.deposit(new Amount(200), LocalDate.now());
        account.withdraw(new Amount(120), LocalDate.now().plusDays(1));

        account.printHistory(System.out::println);


    }

}
