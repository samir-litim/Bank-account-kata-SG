package clean.account;

import clean.model.Amount;
import clean.model.Operation;

import java.time.LocalDate;
import java.util.Collection;
import java.util.function.Consumer;

public interface Account {
    void deposit(Amount amount, LocalDate localDate);
    void withdraw(Amount amount, LocalDate localDate);
    Amount getBalance();
    void printHistory(Consumer<String> stringPrinter );
}
