package clean.model;


import java.util.Objects;

public class Amount {
    final double amount;

    public Amount(double amount) {
        this.amount = amount;
    }

    public Amount add(Amount toBeAdded){
        return new Amount(amount + toBeAdded.amount);
    }

    public Amount subtract(Amount toBeSubtracted){
        return new Amount(amount - toBeSubtracted.amount);
    }

    public boolean isNegative(){
        return amount<0;
    }

    @Override
    public String toString() {
        return amount+"€";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount1 = (Amount) o;
        return Double.compare(amount1.amount, amount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
