package springcore.tickets;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.MissingCommandException;
import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springcore.tickets.commands.CommandExecutor;
import springcore.config.AppConfig;
import springcore.config.CommandsConfig;

public class App {

  public static void main(String[] args) {
    System.out.println(new App().getGreeting());

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
        AppConfig.class,
        CommandsConfig.class
    );
    applicationContext.registerShutdownHook();

    Scanner scanner = new Scanner(System.in);
    while (true) {
      CommandExecutor executor = applicationContext.getBean(CommandExecutor.class);
      JCommander.Builder builder = JCommander.newBuilder();
      executor.commands()
          .forEach(cliCommand -> builder.addCommand(cliCommand.getCommandName(), cliCommand));
      JCommander commander = builder.build();

      System.out.print("$ > ");
      String input = scanner.nextLine().trim();

      if (input.equals("exit")) {
        System.out.println("Bye!");
        break;
      }

      try {
        commander.parse(input.split(" "));
        executor.execute(commander.getParsedCommand());
      } catch (MissingCommandException e) {
        System.err.println("Invalid command, try again");
        commander.usage();
      } catch (Exception e) {
        System.err.println(e.getMessage());
        commander.usage();
      }
    }
    applicationContext.close();
  }

  public String getGreeting() {
    return "CLI App — Gestión de Tickets con Spring Core";
  }
}
