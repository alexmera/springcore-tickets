package springcore.tickets.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static springcore.tickets.daos.TicketMemoryDaoTest.Fixtures.ticket_1;
import static springcore.tickets.daos.TicketMemoryDaoTest.Fixtures.ticket_2;
import static springcore.tickets.daos.TicketMemoryDaoTest.Fixtures.ticket_3;
import static springcore.tickets.daos.TicketMemoryDaoTest.Fixtures.ticket_4;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import springcore.tickets.model.Ticket;
import springcore.tickets.model.TicketStatus;
import springcore.tickets.model.data.TicketData;

public class TicketMemoryDaoTest {

  private TicketDao dao;

  @Before
  public void setup() {
    dao = new TicketMemoryDao();
    dao.create(ticket_1);
    dao.create(ticket_2);
    dao.create(ticket_3);
  }

  @Test
  public void create() {
    Ticket ticket = dao.create(ticket_4);

    assertEquals(4, dao.find().size());
    assertEquals(ticket_4.getSubject(), ticket.getSubject());
  }

  @Test
  public void getOne() {
    Ticket ticket = dao.getOne(1L);

    assertEquals(ticket_1.getSubject(), ticket.getSubject());
  }

  @Test
  public void findOne() {
    Optional<Ticket> ticket = dao.findOne(2L);

    assertTrue(ticket.isPresent());
    assertEquals(ticket_2.getSubject(), ticket.get().getSubject());
  }

  @Test
  public void find() {
    List<Ticket> tickets = dao.find(ticket -> ticket.getId() < 3L);

    assertEquals(2L, tickets.size());
  }

  @Test
  public void find_all() {
    List<Ticket> tickets = dao.find();

    assertEquals(3L, tickets.size());
  }

  @Test
  public void update() {
    TicketData ticket = new TicketData(ticket_4);
    ticket.setId(3L);
    ticket.setSubject("SUBJECT UPDATED");
    dao.update(ticket);

    Ticket ticket3 = dao.getOne(3L);

    assertEquals("SUBJECT UPDATED", ticket3.getSubject());

  }

  @Test
  public void delete() {
    Ticket ticket = dao.delete(2L);

    assertEquals(2, dao.find().size());
    assertEquals(ticket_2.getSubject(), ticket.getSubject());
  }

  interface Fixtures {

    Ticket ticket_1 = new TicketData(
        1L,
        "Qué es NPE?",
        TicketStatus.OPEN,
        null,
        null,
        LocalDateTime.now(),
        null
    );

    Ticket ticket_2 = new TicketData(
        2L,
        "Por qué NullPointerException?",
        TicketStatus.OPEN,
        null,
        null,
        LocalDateTime.now(),
        null
    );

    Ticket ticket_3 = new TicketData(
        3L,
        "Error 404",
        TicketStatus.OPEN,
        null,
        null,
        LocalDateTime.now(),
        null
    );

    Ticket ticket_4 = new TicketData(
        4L,
        "Error 500",
        TicketStatus.OPEN,
        null,
        null,
        LocalDateTime.now(),
        null
    );

  }
}