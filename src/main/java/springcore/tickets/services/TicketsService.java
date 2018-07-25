package springcore.tickets.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import springcore.tickets.model.Resolution;
import springcore.tickets.model.Ticket;

@ParametersAreNonnullByDefault
public interface TicketsService {

  @Nonnull
  Ticket report(Ticket ticket);

  @Nonnull
  Ticket get(long ticketId);

  @Nonnull
  Optional<Ticket> findOne(long ticketId);

  @Nonnull
  List<Ticket> find(Predicate<Ticket> predicate);

  @Nonnull
  List<Ticket> all();

  @Nonnull
  Ticket modify(Ticket ticket);

  @Nonnull
  Ticket close(long ticketId, Resolution resolution);

  @Nonnull
  Ticket close(long ticketId, Resolution resolution, String resolutionInfo);

}
