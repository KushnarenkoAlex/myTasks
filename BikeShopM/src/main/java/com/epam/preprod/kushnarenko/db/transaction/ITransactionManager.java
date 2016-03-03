package main.java.com.epam.preprod.kushnarenko.db.transaction;

public interface ITransactionManager{
	<T> T executeTransaction(ITransactionOperation<T> op);
	<T> T execute(ITransactionOperation<T> op);
}