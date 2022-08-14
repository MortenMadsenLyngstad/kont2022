# Del 2 - sporing av deltakere i orienteringsløp

Mens del 1 handler om rigging av orienteringsløp, så handler del 2 om selve løpet.
 
## Oversikt over klassene
 
### Participant

Representerer én deltaker og ruta som hen må løpe.

### ParticipantsTracker

Denne klassen registrerer deltakerne og deres ruter, og holder rede på hvem som har startet, hvor i ruta de er og om de evt. er ferdige.

Deltakere registreres med **register**-metoden. **isRegistered** angir om det har skjedd for en gitt deltaker.

**start**-metoden kalles når en deltaker løper avgårde *fra* start-posten og begynner på det første strekket i ruta. **hasStarted** angir om det har skjedd for en gitt deltaker. **getCurrentLeg**-metoden skal da returnere første strekk i ruta til deltakeren.

Etter starten kalles **registerPost**-metoden én eller flere ganger for hver nye post som passeres. Hvilken post som er en deltakers neste post beregnes av **getExpectedNextPost**-metoden. Dette skal være samme post som ende-posten til strekket som returneres av **getCurrentLeg**.

Deltakeren regnes som ferdig når siste post i ruta er registrert. **hasFinished** angir om det har skjedd for en gitt deltaker.


## Oppgaver

### a)

Skriv ferdig **Participant**-klassen.

### b)

Skriv ferdig **ParticipantsTracker**-klassen.

Klassen mangler felt og kode i diverse metoder.
