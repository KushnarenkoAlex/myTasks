package ua.nure.serdyuk.SummaryTask4.db.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.db.DbUtils;
import ua.nure.serdyuk.SummaryTask4.db.dao.TicketDao;
import ua.nure.serdyuk.SummaryTask4.entity.Ticket;
import ua.nure.serdyuk.SummaryTask4.exception.DbException;
import ua.nure.serdyuk.SummaryTask4.util.PropertyContainer;

public class TicketDaoMySql implements TicketDao {

	private static final Logger LOG = Logger.getLogger(TicketDaoMySql.class);

	@Override
	public boolean create(Ticket ticket) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		int res = 0;

		try {
			ps = conn.prepareStatement(
					PropertyContainer.get(Const.SQL_INSERT_TICKET));
			int k = 1;
			ps.setString(k++, ticket.getFirstName());
			ps.setString(k++, ticket.getLastName());
			ps.setInt(k++, ticket.getSeatNum());
			ps.setBigDecimal(k++, ticket.getPrice());
			ps.setLong(k++, ticket.getUserId());
			ps.setObject(k++, ticket.getDiscountTypeId(), Types.TINYINT);
			ps.setObject(k++, ticket.getStatusId(), Types.TINYINT);
			ps.setLong(k++, ticket.getCarriageId());
			ps.setLong(k++, ticket.getRouteId());
			ps.setLong(k++, ticket.getRouteItemDepId());
			ps.setLong(k++, ticket.getRouteItemArrId());

			LOG.debug("Ticket statement ==> " + ps);

			res = ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			DbUtils.rollback(conn);
			
			LOG.error(e.getMessage());
			throw new DbException(e.getMessage(), e);
		} finally {
			DbUtils.close(conn, ps, null);
		}
		return res != 0;
	}

	@Override
	public Ticket get(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean update(Ticket item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean delete(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Ticket> getAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Ticket> getAllByUserId(long userId) {
		throw new UnsupportedOperationException();
	}

}
