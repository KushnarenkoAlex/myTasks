package ua.nure.serdyuk.SummaryTask4.db.dao;

import java.util.List;

/**
 * Common interface for all DAOs in the project, includes basic CRUD operations.
 * 
 * @author Daria Serdiuk
 *
 * @param <E>
 *            entity class that is managed by implementation
 */
public interface GenericDao<E> {

	/**
	 * Creates new record in a database and sets auto-generated key to
	 * entity-object (`id`).
	 * 
	 * @param item
	 *            object to be inserted
	 * @return true if creation succeeded, false otherwise
	 */
	boolean create(E item);

	/**
	 * Retrieves entity from database by id.
	 * 
	 * @param id
	 *            entity id
	 * @return entity that was retrieved
	 */
	E get(long id);

	/**
	 * Updates all fields in given entity (by retrieving an id).
	 * 
	 * @param item
	 *            entity to be updated
	 * @return true if update succeeded, false otherwise
	 */
	boolean update(E item);

	/**
	 * Deletes a record from database, specified by id.
	 * 
	 * @param id
	 *            entity id to be deleted
	 * @return true if deleting succeeded, false otherwise
	 */
	boolean delete(long id);

	/**
	 * Retrieves all rows from the database table associated with this entity.
	 * 
	 * @return list of entities
	 */
	List<E> getAll();
}
