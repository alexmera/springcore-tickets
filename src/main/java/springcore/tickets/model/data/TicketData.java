package springcore.tickets.model.data;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springcore.tickets.model.Resolution;
import springcore.tickets.model.Ticket;
import springcore.tickets.model.TicketStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketData implements Ticket {

  private Long id;

  private String subject;

  private TicketStatus status;

  private Resolution resolution;

  private String resolutionInfo;

  private LocalDateTime creationDate;

  private LocalDateTime closingDate;

  public TicketData(Ticket other) {
    this.id = other.getId();
    this.subject = other.getSubject();
    this.status = other.getStatus();
    this.resolution = other.getResolution();
    this.resolutionInfo = other.getResolutionInfo();
    this.creationDate = other.getCreationDate();
    this.closingDate = other.getClosingDate();
  }
}
