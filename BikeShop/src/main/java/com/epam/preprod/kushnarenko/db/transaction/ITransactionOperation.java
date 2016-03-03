package main.java.com.epam.preprod.kushnarenko.db.transaction;

import java.sql.Connection;
import java.sql.SQLException;

public interface ITransactionOperation<E> {
	E execute(Connection con) throws SQLException;
}
