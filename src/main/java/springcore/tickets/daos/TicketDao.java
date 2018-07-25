package springcore.tickets.daos;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import springcore.tickets.model.Ticket;

@ParametersAreNonnullByDefault
public interface TicketDao {

  @Nonnull
  Ticket create(Ticket ticket);

  @Nonnull
  Ticket getOne(long id);

  @Nonnull
  Optional<Ticket> findOne(long id);

  @Nonnull
  List<Ticket> find(Predicate<Ticket> predicate);

  @Nonnull
  List<Ticket> find();

  @Nonnull
  Ticket update(Ticket ticket);

  @Nonnull
  Ticket delete(long id);
}
