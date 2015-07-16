package com.concurrency.class2.A3;
/**
 * 第一售票处
 * @author qpx
 *
 */
public class TicketOffce1 implements Runnable {
	
	private Cinema cinema;
	public TicketOffce1(Cinema cinema) {
		this.cinema = cinema;
	}
	@Override
	public void run() {
		cinema.sellTickets1(3);
		cinema.sellTickets1(2);
		cinema.sellTickets2(2);
		cinema.returnTickets1(3);
		cinema.sellTickets1(5);
		cinema.sellTickets2(2);
		cinema.sellTickets2(2);
		cinema.sellTickets2(2);

	}

}
