package springcore.tickets;

import java.time.LocalDateTime;
import springcore.tickets.daos.TicketDao;
import springcore.tickets.daos.TicketMemoryDao;
import springcore.tickets.model.Resolution;
import springcore.tickets.model.Ticket;
import springcore.tickets.model.TicketStatus;
import springcore.tickets.model.data.TicketData;
import springcore.tickets.services.DefaultTicketsService;
import springcore.tickets.services.TicketsService;

public class App {

  static Ticket ticket_1 = new TicketData(
      1L,
      "Qué es NPE?",
      TicketStatus.OPEN,
      null,
      null,
      LocalDateTime.now(),
      null
  );

  static Ticket ticket_2 = new TicketData(
      2L,
      "Por qué NullPointerException?",
      TicketStatus.OPEN,
      null,
      null,
      LocalDateTime.now(),
      null
  );

  public static void main(String[] args) {
    System.out.println(new App().getGreeting());

    TicketDao dao = new TicketMemoryDao();
    TicketsService service = new DefaultTicketsService(dao);

    service.report(ticket_1);
    service.report(ticket_2);
    service.all().forEach(System.out::println);

    System.out.println("----------------------");
    service.close(ticket_2.getId(), Resolution.SOLVED, "Información adicional");
    service.find(ticket -> ticket.getId().equals(ticket_2.getId())).forEach(System.out::println);
  }

  public String getGreeting() {
    return "CLI App — Gestión de Tickets con Spring Core";
  }
}
