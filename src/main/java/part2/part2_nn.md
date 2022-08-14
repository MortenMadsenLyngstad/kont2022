# Del 2 - sporing av deltakarar i orienteringsløp

Mens del 1 handlar om rigging av orienteringsløp, så handlar del 2 om sjølve løpet.
 
## Oversyn over klassane
 
### Participant

Representerer éin deltakar og ruta som hen må gå.

### ParticipantsTracker

Denne klassen registrerer deltakarane og rutene deira, og held reie på kven som har starta, kvar i ruta dei er og om dei evt. er ferdige.

Deltakarar blir registrerte med **register**-metoden. **isRegistered** angir om det har skjedd for ein gitt deltakar.

**start**-metoden kallast når ein deltakar går av gårde frå *start*posten og byrjar på det første strekket i ruta. **hasStarted** angir om det har skjedd for ein gitt deltakar. **getCurrentLeg**-metoden skal då returnera første strekk i ruta til deltakaren.

Etter starten kallast **registerPost**-metoden éin eller fleire gangar for kvar nye post som blir passert. Kva post som er ein deltakars neste post blir berekna av **getExpectedNextPost**-metoden. Dette skal vera same post som ende-posten til strekket som blir returnert av **getCurrentLeg**.

Deltakaren blir rekna som ferdig når siste post i ruta er registrert. **hasFinished** angir om det har skjedd for ein gitt deltakar.


## Oppgåver

### a)

Skriv ferdig **Participant**-klassen.

### b)

Skriv ferdig **ParticipantsTracker**-klassen.

Klassen manglar felt og kode i diverse metodar.
