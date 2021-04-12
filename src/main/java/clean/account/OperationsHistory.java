package clean.account;

import clean.model.Operation;

import java.util.Collection;

public interface OperationsHistory {
    void addOperation (Operation operation);
    public Collection<Operation> getOperations();

}
