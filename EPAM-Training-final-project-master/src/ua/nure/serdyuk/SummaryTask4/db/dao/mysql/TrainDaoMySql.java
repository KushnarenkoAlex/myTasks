package ua.nure.serdyuk.SummaryTask4.db.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Statement;

import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.db.DbUtils;
import ua.nure.serdyuk.SummaryTask4.db.dao.TrainDao;
import ua.nure.serdyuk.SummaryTask4.entity.RouteItem;
import ua.nure.serdyuk.SummaryTask4.entity.Train;
import ua.nure.serdyuk.SummaryTask4.exception.DbException;
import ua.nure.serdyuk.SummaryTask4.util.DateUtils;
import ua.nure.serdyuk.SummaryTask4.util.PropertyContainer;

public class TrainDaoMySql implements TrainDao {

	private static final Logger LOG = Logger.getLogger(TrainDaoMySql.class);

	@Override
	public boolean create(Train item) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		try {
			ps = conn.prepareStatement(
					PropertyContainer.get(Const.SQL_CREATE_TRAIN),
					Statement.RETURN_GENERATED_KEYS);
			int k = 1;
			ps.setString(k++, item.getTag());
			ps.setBigDecimal(k++, item.getPrice());
			ps.setObject(k++, item.getTypeId(), Types.INTEGER);

			result = ps.executeUpdate();

			rs = ps.getGeneratedKeys();
			if (!rs.next()) {
				throw new DbException("A key for station was not generated");
			}
			item.setId(rs.getInt(1));

			if (!createRouteItems(conn, item.getRouteItems(), item.getId())) {
				throw new DbException("Error while creating RouteItems");
			}

			conn.commit();
		} catch (SQLException e) {
			DbUtils.rollback(conn);
			LOG.error(e.getMessage());
			throw new DbException(e.getMessage(), e);
		} finally {
			DbUtils.close(conn, ps, null);
		}
		return result != 0;
	}

	private boolean createRouteItems(Connection conn, List<RouteItem> items, int trainId)
			throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			ps = conn.prepareStatement(
					PropertyContainer.get(Const.SQL_CREATE_ROUTE_ITEM));

			for (RouteItem ri : items) {
				int k = 1;
				ps.setObject(k++, DateUtils.getTime(ri.getArrivalTime()),
						Types.TIME);
				ps.setObject(k++, DateUtils.getTime(ri.getDepartureTime()),
						Types.TIME);
				ps.setInt(k++, ri.getOrdinal());
				ps.setLong(k++, trainId);
				ps.setLong(k++, ri.getStationId());
				ps.addBatch();
			}
			result = DbUtils.isBatchSuccessful(ps.executeBatch());
		} finally {
			DbUtils.close(null, ps, rs);
		}

		return result;
	}

	@Override
	public Train get(long id) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Train train = null;

		try {
			ps = conn.prepareStatement(
					PropertyContainer.get(Const.SQL_GET_TRAIN_BY_ID));
			ps.setLong(1, id);

			rs = ps.executeQuery();
			if (rs.next()) {
				train = extract(rs);
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
			throw new DbException(e.getMessage(), e);
		} finally {
			DbUtils.close(conn, ps, rs);
		}
		return train;
	}

	@Override
	public boolean update(Train item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean delete(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Train> getAll() {
		throw new UnsupportedOperationException();
	}

	private Train extract(ResultSet rs) throws SQLException {
		Train train = new Train();
		train.setId(rs.getInt("id"));
		train.setPrice(rs.getBigDecimal("price"));
		train.setTag(rs.getString("tag"));

		return train;
	}

}
