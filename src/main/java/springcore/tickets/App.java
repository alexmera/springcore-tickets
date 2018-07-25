package springcore.tickets;

public class App {

  public static void main(String[] args) {
    System.out.println(new App().getGreeting());
  }

  public String getGreeting() {
    return "CLI App — Gestión de Tickets con Spring Core";
  }
}
