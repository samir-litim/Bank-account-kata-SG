package clean.account;

import clean.model.Amount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

class AccountImplShould {

    AccountImpl account;
    LocalDate localDate;

    @BeforeEach
    public void init(){
        account=new AccountImpl();
        localDate = LocalDate.now();
    }


    @Test
    public void new_account_has_zero_balance(){
        Amount zero = new Amount(0);
        Assertions.assertEquals(zero , account.getBalance());
    }

    @Test
    public void add_deposit_amount_to_my_balance(){

        Amount depositAmount= new Amount(15);
        account.deposit(depositAmount, localDate);
        Assertions.assertEquals(new Amount(15), account.getBalance());

    }

    @Test
    public void subtract_withdrawal_amount_to_my_balance(){
        AccountImpl account = new AccountImpl();
        account.deposit(new Amount(100), localDate);
        account.withdraw(new Amount(20), localDate);
        Assertions.assertEquals(new Amount(80), account.getBalance());

    }

    @Test
    public void throw_error_when_subtract_amount_greater_than_balance(){
        AccountImpl account = new AccountImpl();
        account.deposit(new Amount(100), localDate);
        Assertions.assertThrows(RuntimeException.class, ()->account.withdraw(new Amount(120), localDate));

    }

    @Test
    public void print_history_of_operations_in_the_printer(){
        final Collection<String> toBePrinted = new ArrayList<>();

        AccountImpl account = new AccountImpl();
        account.deposit(new Amount(100), localDate);
        account.withdraw(new Amount(20), localDate);

        String depositOperationToBePrinted = "DEPOSIT - "+localDate.toString()+" : 100.0€ => 100.0€";
        String withdrawalOperationToBePrinted = "WITHDRAWAL - "+localDate.toString()+" : 20.0€ => 80.0€";

        account.printHistory(toBePrinted::add);


        Assertions.assertTrue(toBePrinted.contains(depositOperationToBePrinted));
        Assertions.assertTrue(toBePrinted.contains(withdrawalOperationToBePrinted));

    }

}