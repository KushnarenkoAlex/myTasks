package ua.nure.serdyuk.SummaryTask4.db.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.db.DbUtils;
import ua.nure.serdyuk.SummaryTask4.db.dao.UserDao;
import ua.nure.serdyuk.SummaryTask4.entity.Role;
import ua.nure.serdyuk.SummaryTask4.entity.User;
import ua.nure.serdyuk.SummaryTask4.exception.DbException;
import ua.nure.serdyuk.SummaryTask4.util.PropertyContainer;

public class UserDaoMySql implements UserDao {

	private static final Logger LOG = Logger.getLogger(UserDaoMySql.class);

	@Override
	public boolean create(User u) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		final String query = PropertyContainer.get(Const.INSERT_USER);

		try {
			ps = conn.prepareStatement(query);
			int k = 1;
			ps.setString(k++, u.getEmail());
			ps.setString(k++, u.getPassword());
			ps.setString(k++, u.getFirstName());
			ps.setString(k++, u.getLastName());
			ps.setString(k++, u.getDocumentTag());
			ps.setLong(k++, u.getRole().getId());

			int count = ps.executeUpdate();
			conn.commit();
			if (count > 0) {
				// user.setId ?? rs = getGeneratedKeys...
				return true;
			}
			return false;
		} catch (SQLException e) {
			DbUtils.rollback(conn);
			LOG.error(e.getMessage());
			throw new DbException(e.getMessage(), e);
		} finally {
			DbUtils.close(conn, ps, null);
		}
	}

	@Override
	public User get(long id) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		final String query = PropertyContainer.get(Const.GET_USER_BY_ID);

		try {
			ps = conn.prepareStatement(query);
			ps.setLong(1, id);

			rs = ps.executeQuery();
			if (rs.next()) {
				user = extractUser(rs);
			}
		} catch (SQLException e) {
			DbUtils.rollback(conn);
			LOG.error(e.getMessage());
			throw new DbException(e.getMessage(), e);
		} finally {
			DbUtils.close(conn, ps, rs);
		}
		return user;
	}

	@Override
	public boolean update(User item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean delete(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<User> getAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public User getUserByEmail(String email) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		final String query = PropertyContainer.get(Const.GET_USER_BY_EMAIL);

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, email);

			rs = ps.executeQuery();
			if (rs.next()) {
				user = extractUser(rs);
			}
		} catch (SQLException e) {
			DbUtils.rollback(conn);
			LOG.error(e.getMessage());
			throw new DbException(e.getMessage(), e);
		} finally {
			DbUtils.close(conn, ps, rs);
		}
		return user;
	}

	private User extractUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setFirstName(rs.getString("f_name"));
		user.setLastName(rs.getString("l_name"));
		user.setRole(Role.get(rs.getLong("role_id")));

		return user;
	}
}
