# Del 1 - oppsett av orienteringsløp

I et orienteringsløp skal deltakerne løpe fra et startpunkt, via poster plassert ute i terrenget i riktig rekkefølge og ende opp på målpunktet. Deltakerne løper ikke nødvendigvis de samme postene i samme rekkefølge, bl.a. fordi de stiller i ulike klasser. 

Klassene i denne oppgaven handler om rigging av et slikt løp.

## Oversikt over klassene

### Post

**Post**-klassen representerer en lokasjon som inngår i løpet, både de i terrenget og start- og avslutningspunktet.
Lokasjonen er representert som avstand i meter i øst- og nordlig retning fra et referansepunkt (0, 0).

Avstand mellom lokasjoner (øst-, nord-koordinater) og poster beregnes som geometrisk avstand som om jorda er flat. Klassen har diverse **distance**-metoder for å beregne avstand.

Hver post har et nummer, for å gjøre dem lettere å skille fra hverandre, men merk at dette nummeret ikke nødvendigvis tilsvarer rekkefølgen de skal besøkes i løpet. Post-nummeret er -1 i starten og settes kun én gang.

### Leg

**Leg**-klassen representerer strekket mellom to poster (start og end).

### Race

**Race**-klassen holder oversikt over start- og avslutningspunktene, samt alle postene som totalt sett inngår i løpet.

Klassen initialiseres med start- og avslutningspostene, og så legges nye postlokasjoner til én og én med **addPost**-metoden.

Mange av metodene behandler postene som en sekvens/liste og da regnes start-posten som *første* post og avslutningsposten som den *siste*. Postene som legges til med **addPost** havner i mellom i innleggingsrekkefølge.

**addPost** har en sjekk på om den er for nær (angitt av **distanceEpsilon**-konstanten) de som allerede er lagt inn.
Hjelpemetoden **findPostsNearby** returnerer alle poster innen en viss distanse fra et angitt punkt.

**assignPostNums** brukes for å sette postnumrene, slik at det siden blir lettere å holde oversikt over rutene.

### Route

**Route**-klassen representerer et sett med poster (**Post**) som må besøkes i en bestemt rekkefølge. Alternativt kan en tenke på det som en sekvens med strekk (**Leg**) mellom poster.

**Route** initialiseres med en sekvens av poster, som strekkene avledes fra. Hvis en **Route** initialiseres med poster med numrene 1, 3 og 4, så vil den ha strekk mellom poster 1 og 3 og mellom poster 3 og 4.

Det er ingen metoder for å endre en **Route** etter at den er initialisert.

### RouteFactory

Dette er et funksjonelt grensesnitt og representerer en fremgangsmåte (algoritme) for å beregne en rute (**Route**) fra en start-post til en avslutningspost (først og siste post i ruta) via en eller flere mellomliggende poster (de i terrenget). Ikke alle postene som gis inn som kandidater for de mellomliggende postene, skal nødvendigvis være med i den beregnede ruta.

I tillegg til én abstrakt **createRoute**-metode, så deklarerer klassen i tillegg en del nyttige **default**-metoder, som bruker den abstrakte.

En implementasjon av **RouteFactory** trenger ikke ta med alle postene og eller beholde rekkefølgen, men start-og avslutningsposten må være med som henholdsvis først og siste post.

Klassen inneholder to statiske felt som holder hver sin implementasjon av grensesnittet. **ALL_POSTS_ON_ORDER** lager en **Route** med alle postene i original rekkefølge, mens **ALL_POSTS_REVERSED** lager en **Route** med alle postene i motsatt rekkefølge (men selvsagt med samme start- og avslutningspost).

### MaxDistanceRouteFactory

Implementasjon av **RouteFactory** som lager ruter med en viss maks-lengde.

## Oppgaver

### a)

Skriv ferdig **Post**- og **Leg**- klassene.

Disse klassene mangler felt, initialisering i konstruktøren, tilgangsmetoder og metoder for å beregne avstander vha. **distance**-metoder.

### b)

Skriv ferdig **Race**-klassen.

Klassen mangler felt og kode i konstruktører og diverse metoder.

### c)

Skriv ferdig **Route**- og **RouteFactory**-klassene.

**Route**-klassen mangler felt og kode i konstruktører og diverse metoder.
**RouteFactory** mangler initialisering av to statiske felt.

### d)

Skriv ferdig **MaxDistanceRouteFactory**-klassen.

Logikken i **createRoute**-metoden mangler.
