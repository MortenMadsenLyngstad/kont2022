# Del 1 - oppsett av orienteringsløp

I eit orienteringsløp skal deltakarane gå frå eit startpunkt, via postar plassert ute i terrenget i riktig rekkefølgje og enda opp på målpunktet. Deltakarane går ikkje nødvendigvis dei same postane i same rekkefølgje, m.a. fordi dei stiller i ulike klassar. 

Klassane i denne oppgåva handlar om rigging av eit slikt løp.

## Oversyn over klassane

### Post

**Post**-klassen representerer ein lokasjon som inngår i løpet, både dei i terrenget og start- og avslutningspunktet.
Lokasjonen er representert som avstand i meter i øst- og nordleg retning frå eit referansepunkt (0, 0).

Avstand mellom lokasjoner (øst-, nord-koordinatar) og postar blir berekna som geometrisk avstand som om jorda er flat. Klassen har diverse **distance**-metodar for å berekna avstand.

Kvar post har eit nummer, for å gjera dei lettare å skilja frå kvarandre, men merk at dette nummeret ikkje nødvendigvis svarer til rekkefølgja dei skal besøkast i løpet. Post-nummeret er -1 i starten og blir berre sett éin gang.

### Leg

**Leg**-klassen representerer strekket mellom to postar (start og end).

### Race

**Race**-klassen held oversyn over start- og avslutningspunkta, og dessutan alle postane som totalt sett inngår i løpet.

Klassen initialiseres med start- og avslutningspostane, og så blir nye postlokasjoner lagt til éin og éin med **addPost*-metoden.

Mange av metodane behandlar postane som ein sekvens/liste og då blir start-posten rekna som første *post* og avslutningsposten som den *siste*. Postane som blir lagt til med **addPost** hamnar i mellom i innleggingsrekkefølgje.

**addPost** har ein sjekk på om han er for nær (angitt av **distanceEpsilon**-konstanten) dei som allereie er lagt inn.
Hjelpemetoden **findPostsNearby** returnerer alle postar innanfor ein viss distanse frå eit angitt punkt.

**assignPostNums** blir brukt for å setja postnummera, slik at det sidan blir lettare å halda oversyn over rutene.

### Route

**Route**-klassen representerer eit sett med postar (**Post**) som må besøkast i ei bestemd rekkefølgje. Alternativt kan ein tenka på det som ein sekvens med strekk (**Leg**) mellom poster.

**Route** initialiseres med ein sekvens av postar, som strekka blir avleidde frå. Viss ein **Route** initialiseres med postar med nummera 1, 3 og 4, så vil han ha strekk mellom postar 1 og 3 og mellom postar 3 og 4.

Det er ingen metodar for å endra ein **Route** etter at han er initialisert.

### RouteFactory

Dette er eit funksjonelt grensesnitt og representerer ein framgangsmåte (algoritme) for å berekna ei rute (**Route**) frå ein startpost til ein avslutningspost (først og siste post i ruta) via ein eller fleire mellomliggande postar (dei i terrenget). Ikkje alle postane som blir lagt inn som kandidatar for dei mellomliggande postane, skal nødvendigvis vera med i den berekna ruta.

I tillegg til ein abstrakt **createRoute**-metode, så deklarerer klassen i tillegg ein del nyttige **default**-metodar, som bruker den abstrakte.

Ein implementasjon av **RouteFactory** treng ikkje ta med alle postane og eller behalda rekkefølgja, men start-og avslutningsposten må vera med som høvesvis først og siste post.

Klassen inneheld to statiske felt som held kvar sin implementasjon av grensesnittet. **ALL_POSTS_ON_ORDER** lagar ein **Route** med alle postane i original rekkefølgje, medan **ALL_POSTS_REVERSED** lagar ein **Route** med alle postane i motsett rekkefølgje (men sjølvsagt med same start- og avslutningspost).

### MaxDistanceRouteFactory

Implementasjon av **RouteFactory** som lagar ruter med ein viss maks-lengde.

## Oppgåver

### a)

Skriv ferdig **Post**- og **Leg**- klassane.

Desse klassane manglar felt, initialisering i konstruktøren, tilgangsmetodar og metodar for å berekna avstandar vha. **distance**-metodar.

### b)

Skriv ferdig **Race**-klassen.

Klassen manglar felt og kode i konstruktørar og diverse metodar.

### c)

Skriv ferdig **Route**- og **RouteFactory**-klassane.

**Route**-klassen manglar felt og kode i konstruktørar og diverse metodar.
**RouteFactory** manglar initialisering av to statiske felt.

### d)

Skriv ferdig **MaxDistanceRouteFactory**-klassen.

Logikken i **createRoute**-metoden manglar.
