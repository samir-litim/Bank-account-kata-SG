package clean.account;

import clean.model.Operation;

import java.util.ArrayList;
import java.util.Collection;

public class OperationsHistoryImpl implements OperationsHistory {

    private final Collection<Operation> operations;

    public OperationsHistoryImpl() {
        operations = new ArrayList<>();
    }

    @Override
    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    @Override
    public Collection<Operation> getOperations() {
        return operations;
    }

}
