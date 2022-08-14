# Del 3 - Tekstformat for Race og JavaFX+FXML-app

Denne delen omhandler lesing og skriving av et tekstformat for Race-poster, og en Race-app.

## Oversikt over klassene

### RaceFormat

Metoder for å lese og skrive et tekstformat for postene i et løp.

### RaceApp og RaceAppController

App-klasse og tilhørende kontroller-klasse.

## Oppgaver

### a)

Det er definert et enkelt tekstformat for Race-poster, som kan lese og skrives av **RaceFormat**-klassen. Skriv ferdig **readRace**- og **writeRace**-metodene i denne klassen.

### b)

Det er nesten laget ferdig en app for å laste inn **Race**-poster og vise postene i en liste.
Brukeren skal kunne skrive inn en URL (adresse til en fil eller nettressurs) og så trykke en knapp for å få lest inn poster vha. **RaceFormat**-klassen.
Etter innlesing skal postene vises i en liste (**Post** sin **toString**-metode brukes implisitt):

![Load OK](load-ok.png)

Dersom det utløses unntak under lesing, så skal en melding vises:

![Load Exception](load-exception.png)

Dessverre fungerer ikke appen, og det kan være feil i både java- og fxml-koden.
Oppgaven er å gjøre appen kjørbar, med ønsket oppførsel.
