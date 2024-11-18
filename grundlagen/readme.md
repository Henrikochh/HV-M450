# Aufgaben
Source: https://gitlab.com/ch-tbz-it/Stud/m450/m450/-/blob/main/Unterlagen/grundlagen/UEBUNGEN.md <br>
Notizen: https://docs.google.com/document/d/1n_1yi5gtLufgZqIPOjo2_unpKwOOj2O6AzQpZaJ-CPY/edit?usp=sharing

## Aufgabe 1

### 1. Unit Tests (Modultests):
   - **Beschreibung**: Diese Tests überprüfen einzelne Komponenten oder Funktionen der Software, um sicherzustellen, dass sie unabhängig korrekt funktionieren.
   - **Durchführung**: Der Entwickler schreibt Testfälle für jede Funktion oder Methode, wobei Mock-Objekte verwendet werden, um Abhängigkeiten zu isolieren. Im betrieb verwenden wir meistens das tool JUnit in Java dafür.

### 2. Integrationstests:
   - **Beschreibung**: Integrationstests prüfen das Zusammenspiel mehrerer Module oder Komponenten in der Software.
   - **Durchführung**: Mehrere Module, die bereits durch Unit Tests validiert wurden, werden gemeinsam getestet. Dabei wird überprüft, ob die Module ordnungsgemäss zusammenarbeiten. Beispiele sind API-Tests oder Datenbank-Integrationstests.

### 3. Systemtests:
   - **Beschreibung**: Systemtests überprüfen das vollständige und integrierte System, um sicherzustellen, dass es den funktionalen und nicht-funktionalen Anforderungen entspricht.
   - **Durchführung**: Das gesamte System wird in einer Umgebung getestet, die der Produktionsumgebung möglichst ähnlich ist. Hier werden reale Benutzerszenarien simuliert, um das Programm unter realistischen Bedingungen zu überprüfen.

## Aufgabe 2

### 1. Softwarefehler (Bug): 
  - **Beispiel**: Ein Button in einer App, der nicht auf Klicks reagiert, obwohl er sichtbar ist. Dies ist ein Fehler im Code, der zu einem unerwarteten Verhalten führt.
### 2. Softwaremangel:
  - **Beispiel**: Ein Webshop erlaubt nur die Eingabe von maximal 10 Zeichen im Feld für den Strassennamen. Kunden mit längeren Strassennamen können ihre Adresse nicht vollständig eingeben. Dies ist ein Mangel, da die Anforderung der Benutzer nicht erfüllt wird.
### 3. Beispiel für hohen Schaden durch einen Softwarefehler:
  - Ein Softwarefehler in einem medizinischen Gerät, wie so einem geraet das medikamente verabreicht, führt zu einer fehlerhaften Dosierung. Das kann das leben eines menschen kostens. Und deshalb müssen diese Geräte auch für alle Fälle getestet werden.
