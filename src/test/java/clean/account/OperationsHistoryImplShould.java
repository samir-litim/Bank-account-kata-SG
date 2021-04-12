package clean.account;

import clean.model.Amount;
import clean.model.Operation;
import clean.model.OperationType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;

class OperationsHistoryImplShould {

    OperationsHistoryImpl operationsHistoryImpl;

    @BeforeEach
    public void init(){
        operationsHistoryImpl = new OperationsHistoryImpl();
    }


    @Test
    public void return_empty_collection_when_no_add_operation_has_been_done(){
        Collection<Operation> operationsHistory = operationsHistoryImpl.getOperations();
        Assertions.assertTrue(operationsHistory.isEmpty());
    }

    @Test
    public void return_previously_added_operations(){


        Operation deposit = new Operation(OperationType.DEPOSIT,new Amount(100), LocalDate.now(),new Amount(100));
        Operation withdrawal = new Operation(OperationType.WITHDRAWAL,new Amount(20), LocalDate.now(),new Amount(20));

        operationsHistoryImpl.addOperation(deposit);
        operationsHistoryImpl.addOperation(withdrawal);

        Collection<Operation> operations = this.operationsHistoryImpl.getOperations();
        Assertions.assertTrue(operations.contains(deposit));
        Assertions.assertTrue(operations.contains(withdrawal));

    }

}