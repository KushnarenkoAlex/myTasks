package ua.nure.serdyuk.SummaryTask4.db.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.db.DbUtils;
import ua.nure.serdyuk.SummaryTask4.db.dao.RouteBeanDao;
import ua.nure.serdyuk.SummaryTask4.entity.bean.RouteBean;
import ua.nure.serdyuk.SummaryTask4.exception.DbException;
import ua.nure.serdyuk.SummaryTask4.util.PropertyContainer;

public class RouteBeanDaoMySql implements RouteBeanDao {

	private static final Logger LOG = Logger.getLogger(RouteBeanDaoMySql.class);

	@Override
	public List<RouteBean> getAllByTrainId(long trainId) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<RouteBean> beans = null;

		try {
			ps = conn.prepareStatement(
					PropertyContainer.get(Const.GET_ROUTE_INFO_BY_TRAIN_ID));
			ps.setLong(1, trainId);

			rs = ps.executeQuery();

			beans = new ArrayList<>();
			while (rs.next()) {
				beans.add(extract(rs));
			}
			
			LOG.debug("beans obtained ==> " + beans);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
			throw new DbException(e.getMessage(), e);
		} finally {
			DbUtils.close(conn, ps, rs);
		}
		return beans;
	}

	private RouteBean extract(ResultSet rs) throws SQLException {
		RouteBean bean = new RouteBean();
		bean.setArrTime(rs.getTime("arr_time"));
		bean.setDepTime(rs.getTime("dep_time"));
		bean.setStationName(rs.getString("name"));

		return bean;
	}

	@Override
	public boolean create(RouteBean item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public RouteBean get(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean update(RouteBean item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean delete(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<RouteBean> getAll() {
		throw new UnsupportedOperationException();
	}

}
