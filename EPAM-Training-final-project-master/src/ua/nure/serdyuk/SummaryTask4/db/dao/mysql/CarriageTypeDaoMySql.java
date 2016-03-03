package ua.nure.serdyuk.SummaryTask4.db.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.db.DbUtils;
import ua.nure.serdyuk.SummaryTask4.db.dao.CarriageTypeDao;
import ua.nure.serdyuk.SummaryTask4.entity.CarriageType;
import ua.nure.serdyuk.SummaryTask4.exception.DbException;
import ua.nure.serdyuk.SummaryTask4.util.PropertyContainer;

public class CarriageTypeDaoMySql implements CarriageTypeDao {

	private static final Logger LOG = Logger
			.getLogger(CarriageTypeDaoMySql.class);

	@Override
	public boolean create(CarriageType item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public CarriageType get(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean update(CarriageType item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean delete(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<CarriageType> getAll() {
		Connection conn = DbUtils.getConnection();
		Statement s = null;
		ResultSet rs = null;
		List<CarriageType> types = null;

		try {
			s = conn.createStatement();
			rs = s.executeQuery(
					PropertyContainer.get(Const.SQL_GET_ALL_CAR_TYPES));
			types = new ArrayList<>();
			while (rs.next()) {
				types.add(extractType(rs));
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			throw new DbException(e.getMessage(), e);
		} finally {
			DbUtils.close(conn, s, rs);
		}
		return types;
	}

	private CarriageType extractType(ResultSet rs) throws SQLException {
		CarriageType type = new CarriageType();
		type.setId(rs.getInt("id"));
		type.setName(rs.getString("name"));
		type.setSeatNum(rs.getInt("seat_num"));

		return type;
	}

}
