# CLI App — Gestión de Tickets con Spring Core

## Prerrequisitos

- Java 9+
- Gradle 4.8.1

## Modelo

![Diagrama de clases](./plant_uml/tickets-uml.svg)

## Comandos CLI

```
Usage: <main class> [command] [command options]
  Commands:
    report      Reportar un ticket
      Usage: report Asunto del ticket

    all      Listar todos los tickets
      Usage: all [options]
        Options:
          --status
            Options: [OPEN, CLOSED]
            Possible Values: [OPEN, CLOSED]

    close      Cerrar un ticket
      Usage: close [options]
        Options:
        * --id

          --info

        * --resolution
            Options: [SOLVED, NOT_SOLVED]
            Possible Values: [SOLVED, NOT_SOLVED]
```