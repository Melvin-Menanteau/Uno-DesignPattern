# Uno-DesignPattern

##### AUGER-DUBOIS Benoît - MENANTEAU Melvin
SDK 17

## Design Patterns utilisés

### Strategy

Change le comportement de la carte lorsqu'elle est jouée.

![Diagramme UML Strategy](/img/DesignPattern_Strategy.png "Diagramme UML Strategy")

### Builder

Crée et une retourne une carte avec la configuration souhaitée.
<br> Il est uniquement possible de choisir la couleur, la valeur et le comportement (ex: carte normale, carte +2)

![Diagramme UML Builder](/img/DesignPattern_Builder.png "Diagramme UML Builder")

### Observer

Permet au joueur de notifier la partie qu'il n'a plus de cartes et qu'il a donc gagné.

![Diagramme UML Observer](/img/DesignPattern_Observer.png "Diagramme UML Observer")