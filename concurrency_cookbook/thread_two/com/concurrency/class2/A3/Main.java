package com.concurrency.class2.A3;
/**
 * 使用非依赖属性实现同步
 * @author qpx
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		TicketOffce1 ticketOffce1 = new TicketOffce1(cinema);
		Thread thread1 = new Thread(ticketOffce1,"ticketOffce1");
		
		TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
		Thread thread2 = new Thread(ticketOffice2,"ticketOffice2");
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Room 1 Vacancies:%d\n",cinema.getVacanciesCinema1());
		System.out.printf("Room 2 Vacancies:%d\n",cinema.getVacanciesCinema2());

	
	}

}
