package clean.model;


import java.time.LocalDate;
import java.util.Objects;

public class Operation {

    private final OperationType type;
    private final Amount amount;
    private final LocalDate date;
    private final Amount balance;

    public Operation(OperationType type, Amount amount, LocalDate date, Amount balance) {
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return type == operation.type &&
                Objects.equals(amount, operation.amount) &&
                Objects.equals(date, operation.date) &&
                Objects.equals(balance, operation.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, amount, date, balance);
    }

    @Override
    public String toString() {
        return type.name() + " - "+date.toString()+" : "+ amount +" => "+balance;
    }
}
