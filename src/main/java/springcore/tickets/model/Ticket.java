package springcore.tickets.model;

import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface Ticket {

  @Nonnull
  Long getId();

  @Nonnull
  String getSubject();

  @Nonnull
  TicketStatus getStatus();

  @Nullable
  Resolution getResolution();

  @Nullable
  String getResolutionInfo();

  @Nonnull
  LocalDateTime getCreationDate();

  @Nullable
  LocalDateTime getClosingDate();
}
