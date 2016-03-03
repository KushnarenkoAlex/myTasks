package ua.nure.serdyuk.SummaryTask4.db.dao;

import java.util.List;

import ua.nure.serdyuk.SummaryTask4.entity.Ticket;

public interface TicketDao extends GenericDao<Ticket> {

	List<Ticket> getAllByUserId(long userId);

}
