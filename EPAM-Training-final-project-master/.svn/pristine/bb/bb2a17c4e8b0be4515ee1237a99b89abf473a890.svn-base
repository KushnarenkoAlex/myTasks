package ua.nure.serdyuk.SummaryTask4.db.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Statement;

import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.db.DbUtils;
import ua.nure.serdyuk.SummaryTask4.db.dao.StationDao;
import ua.nure.serdyuk.SummaryTask4.entity.Station;
import ua.nure.serdyuk.SummaryTask4.exception.DbException;
import ua.nure.serdyuk.SummaryTask4.util.PropertyContainer;

public class StationDaoMySql implements StationDao {

	private static final Logger LOG = Logger.getLogger(StationDaoMySql.class);

	@Override
	public boolean create(Station item) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		try {
			ps = conn.prepareStatement(
					PropertyContainer.get(Const.SQL_CREATE_STATION),
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, item.getName());

			result = ps.executeUpdate();

			rs = ps.getGeneratedKeys();
			if (!rs.next()) {
				throw new DbException("A key for station was not generated");
			}
			item.setId(rs.getLong(1));

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

	@Override
	public Station get(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean update(Station item) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement(
					PropertyContainer.get(Const.SQL_UPDATE_STATION));

			int k = 1;
			ps.setString(k++, item.getName());
			ps.setLong(k++, item.getId());

			result = ps.executeUpdate();
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

	@Override
	public boolean delete(long id) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement(
					PropertyContainer.get(Const.SQL_DELETE_STATION));
			ps.setLong(1, id);

			result = ps.executeUpdate();
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

	@Override
	public List<Station> getAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Station> getAll(String filter) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Station> stations = new ArrayList<>();
		String query = (filter != null)
				? PropertyContainer.get(Const.GET_ALL_STATIONS_LIKE)
				: PropertyContainer.get(Const.GET_ALL_STATIONS);

		try {
			if (filter != null) {
				query = query.replace("?", filter);
			}
			ps = conn.prepareStatement(query);
			LOG.debug(String.format("Executing statement %s", ps.toString()));

			rs = ps.executeQuery();
			while (rs.next()) {
				stations.add(extractStation(rs));
			}
		} catch (SQLException e) {
			DbUtils.rollback(conn);
			LOG.error(e.getMessage());
			throw new DbException(e.getMessage(), e);
		} finally {
			DbUtils.close(conn, ps, rs);
		}
		return stations;
	}

	@Override
	public Station getByName(String name) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Station station = null;
		final String query = PropertyContainer.get(Const.GET_STATION_BY_NAME);

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, name);

			rs = ps.executeQuery();
			if (rs.next()) {
				station = extractStation(rs);
			}
		} catch (SQLException e) {
			DbUtils.rollback(conn);
			LOG.error(e.getMessage());
			throw new DbException(e.getMessage(), e);
		} finally {
			DbUtils.close(conn, ps, rs);
		}
		return station;
	}

	@Override
	public List<Station> getByRouteItems(long routeItemId1, long routeItemId2) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Station> stations = null;

		try {
			ps = conn.prepareStatement(
					PropertyContainer.get(Const.GET_STATIONS_BY_ROUTE_ITEMS));
			int k = 1;
			ps.setLong(k++, routeItemId1);
			ps.setLong(k++, routeItemId2);

			rs = ps.executeQuery();
			stations = new ArrayList<>();
			while (rs.next()) {
				stations.add(extractStation(rs));
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
			throw new DbException(e.getMessage(), e);
		} finally {
			DbUtils.close(conn, ps, rs);
		}
		if (stations.size() != 2) {
			throw new DbException("Unexpected result set.");
		}
		return stations;
	}

	private Station extractStation(ResultSet rs) throws SQLException {
		Station s = new Station();
		s.setId(rs.getLong("id"));
		s.setName(rs.getString("name"));

		return s;
	}

}
