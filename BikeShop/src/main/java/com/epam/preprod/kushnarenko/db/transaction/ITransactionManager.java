package main.java.com.epam.preprod.kushnarenko.db.transaction;

public interface ITransactionManager {

    /**
     * Allows to wrap executing of ITransactionOperation into transaction.
     * 
     * @param op
     *            - executed operation.
     * @return result of executing ITransactionOperation<T> op.
     */
    <T> T executeTransaction(ITransactionOperation<T> op);

    /**
     * Allows to wrap executing of ITransactionOperation into non-transactional
     * opening and closing Connection.
     * 
     * @param op
     *            - executed operation.
     * @return result of executing ITransactionOperation<T> op.
     */
    <T> T execute(ITransactionOperation<T> op);
}