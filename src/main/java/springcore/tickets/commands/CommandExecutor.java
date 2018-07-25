package springcore.tickets.commands;

import java.util.Collection;
import java.util.Map;
import javax.annotation.Nonnull;
import org.springframework.context.ApplicationContext;

public class CommandExecutor {

  private final ApplicationContext applicationContext;

  private final Map<String, CliCommand> commandMap;

  public CommandExecutor(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
    this.commandMap = applicationContext.getBeansOfType(CliCommand.class);
  }

  public Collection<CliCommand> commands() {
    return commandMap.values();
  }

  public void execute(@Nonnull String commandName) {
    CliCommand cliCommand = commandMap.get(commandName);
    System.out.println(cliCommand.runCommand());
  }
}
