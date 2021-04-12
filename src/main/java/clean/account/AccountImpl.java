package clean.account;

import clean.model.Amount;
import clean.model.Operation;
import clean.model.OperationType;

import java.time.LocalDate;
import java.util.function.Consumer;

public class AccountImpl implements Account{

    private Amount balance = new Amount(0);
    private final  OperationsHistoryImpl operationsHistory = new OperationsHistoryImpl();

    private void addOperationToHistory(Amount amount, LocalDate localDate, OperationType deposit) {
        Operation operation = new Operation(deposit, amount, localDate, balance);
        operationsHistory.addOperation(operation);
    }

    @Override
    public void deposit(Amount amount, LocalDate localDate) {
        balance = balance.add(amount);
        addOperationToHistory(amount, localDate, OperationType.DEPOSIT);
    }

    @Override
    public void withdraw(Amount amount, LocalDate localDate) {
        Amount resultingBalance = balance.subtract(amount);

        if (resultingBalance.isNegative()){
            throw new RuntimeException("Can't withdraw amount "+ amount + ". Balance is not enough!");
        }

        balance = resultingBalance;
        addOperationToHistory(amount, localDate, OperationType.WITHDRAWAL);

    }


    @Override
    public Amount getBalance() {
        return balance;
    }

    @Override
    public void printHistory(Consumer<String> stringPrinter ) {

        operationsHistory.getOperations().stream()
                .map(Operation::toString)
                .forEachOrdered(stringPrinter);
    }

}
