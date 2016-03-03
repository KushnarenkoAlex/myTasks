package ua.nure.serdyuk.SummaryTask4.db.service.impl;

import ua.nure.serdyuk.SummaryTask4.db.dao.TicketDao;
import ua.nure.serdyuk.SummaryTask4.db.service.TicketService;
import ua.nure.serdyuk.SummaryTask4.entity.Ticket;

public class TicketServiceImpl implements TicketService {

	private TicketDao ticketDao;
	
	public TicketServiceImpl(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	@Override
	public boolean create(Ticket ticket) {
		return ticketDao.create(ticket);
	}

}
