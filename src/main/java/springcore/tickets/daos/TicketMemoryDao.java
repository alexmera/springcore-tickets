package springcore.tickets.daos;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import springcore.tickets.model.Ticket;
import springcore.tickets.model.data.TicketData;

@ParametersAreNonnullByDefault
public class TicketMemoryDao implements TicketDao {

  private final Map<Long, Ticket> persistence;

  public TicketMemoryDao() {
    this.persistence = new LinkedHashMap<>();
  }

  @Nonnull
  @Override
  public Ticket create(Ticket ticket) {
    Ticket copy = new TicketData(ticket);
    persistence.put(ticket.getId(), copy);
    return copy;
  }

  @Nonnull
  @Override
  public Ticket getOne(long id) {
    Ticket ticket = persistence.get(id);
    if (ticket != null) {
      return new TicketData(ticket);
    }
    throw new NoSuchElementException();
  }

  @Nonnull
  @Override
  public Optional<Ticket> findOne(long id) {
    return Optional.ofNullable(persistence.get(id)).map(TicketData::new);
  }

  @Nonnull
  @Override
  public List<Ticket> find(Predicate<Ticket> predicate) {
    return Collections.unmodifiableList(valuesCopyList(predicate));
  }

  @Nonnull
  @Override
  public List<Ticket> find() {
    return Collections.unmodifiableList(valuesCopyList(null));
  }

  @Nonnull
  @Override
  public Ticket update(Ticket ticket) {
    persistence.replace(ticket.getId(), ticket);
    return getOne(ticket.getId());
  }

  @Nonnull
  @Override
  public Ticket delete(long id) {
    Ticket ticket = getOne(id);
    persistence.remove(id);
    return new TicketData(ticket);
  }

  private List<Ticket> valuesCopyList(@Nullable Predicate<Ticket> predicate) {
    Stream<Ticket> stream = persistence.values().stream().map(TicketData::new);
    if (predicate != null) {
      return stream.filter(predicate).collect(Collectors.toList());
    }
    return stream.collect(Collectors.toList());
  }
}
