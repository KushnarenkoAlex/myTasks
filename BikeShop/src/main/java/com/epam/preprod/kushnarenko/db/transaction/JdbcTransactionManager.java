package main.java.com.epam.preprod.kushnarenko.db.transaction;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.exception.DbCallException;

public class JdbcTransactionManager implements ITransactionManager {

    DataSource dataSource;
    private final static Logger logger = Logger.getLogger(JdbcTransactionManager.class);

    public JdbcTransactionManager(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }

    @Override
    public <T> T executeTransaction(ITransactionOperation<T> op) {
        Connection con = null;
        T res = null;
        try {
            con = dataSource.getConnection();
            try {
                con.setAutoCommit(false);
                con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                res = op.execute(con);
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                logger.error("SQL exception during the transaction");
            } finally {
                if (con != null) {
                    con.close();
                }
            }
        } catch (SQLException e1) {
            logger.error("SQL Exception during the transaction");
            throw new DbCallException(Const.DB_DOESNT_ANSWER);
        }
        return res;
    }

    @Override
    public <T> T execute(ITransactionOperation<T> op) {
        Connection con = null;
        T res = null;
        try {
            con = dataSource.getConnection();

            res = op.execute(con);
            con.close();

        } catch (SQLException e1) {
            logger.error("SQL Exception during operation");
            throw new DbCallException(Const.DB_DOESNT_ANSWER);
        }
        return res;
    }

}
