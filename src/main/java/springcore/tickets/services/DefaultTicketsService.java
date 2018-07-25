package springcore.tickets.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import springcore.tickets.daos.TicketDao;
import springcore.tickets.model.Resolution;
import springcore.tickets.model.Ticket;
import springcore.tickets.model.TicketStatus;
import springcore.tickets.model.data.TicketData;

@ParametersAreNonnullByDefault
public class DefaultTicketsService implements TicketsService {

  private final TicketDao ticketDao;

  public DefaultTicketsService(TicketDao ticketDao) {
    this.ticketDao = ticketDao;
  }

  @Nonnull
  @Override
  public Ticket report(Ticket ticket) {
    return ticketDao.create(ticket);
  }

  @Nonnull
  @Override
  public Ticket get(long ticketId) {
    return ticketDao.getOne(ticketId);
  }

  @Nonnull
  @Override
  public Optional<Ticket> findOne(long ticketId) {
    return ticketDao.findOne(ticketId);
  }

  @Nonnull
  @Override
  public List<Ticket> find(Predicate<Ticket> predicate) {
    return ticketDao.find(predicate);
  }

  @Nonnull
  @Override
  public List<Ticket> all() {
    return ticketDao.find();
  }

  @Nonnull
  @Override
  public Ticket modify(Ticket ticket) {
    return ticketDao.update(ticket);
  }

  @Nonnull
  @Override
  public Ticket close(long ticketId, Resolution resolution) {
    return close(ticketId, resolution, "N/A");
  }

  @Nonnull
  @Override
  public Ticket close(long ticketId, Resolution resolution, String resolutionInfo) {
    TicketData ticket = new TicketData(get(ticketId));
    ticket.setResolution(resolution);
    ticket.setResolutionInfo(resolutionInfo);
    ticket.setStatus(TicketStatus.CLOSED);
    ticket.setClosingDate(LocalDateTime.now());
    return modify(ticket);
  }
}
