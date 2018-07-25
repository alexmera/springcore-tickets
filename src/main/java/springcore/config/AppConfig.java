package springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springcore.tickets.daos.TicketDao;
import springcore.tickets.daos.TicketMemoryDao;
import springcore.tickets.services.DefaultTicketsService;
import springcore.tickets.services.TicketsService;

@Configuration
public class AppConfig {

  @Bean
  public TicketDao ticketDao() {
    return new TicketMemoryDao();
  }

  @Bean
  public TicketsService ticketsService(TicketDao ticketDao) {
    return new DefaultTicketsService(ticketDao);
  }
}
