package springcore.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import springcore.tickets.commands.CommandExecutor;

@Configuration
@ComponentScan(basePackageClasses = {CommandExecutor.class})
public class CommandsConfig {

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public CommandExecutor commandExecutor(ApplicationContext applicationContext) {
    return new CommandExecutor(applicationContext);
  }
}
