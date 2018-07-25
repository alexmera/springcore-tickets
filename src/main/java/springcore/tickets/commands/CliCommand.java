package springcore.tickets.commands;

import javax.annotation.Nonnull;

public interface CliCommand {

  @Nonnull
  String getCommandName();

  @Nonnull
  String runCommand();
}
