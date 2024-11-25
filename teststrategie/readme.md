# Aufgaben
Source: https://gitlab.com/ch-tbz-it/Stud/m450/m450/-/blob/main/Unterlagen/teststrategie/UEBUNGEN.md <br>

## Übung 1


### Abstrakte Testfälle

| Testfall | Kaufpreis Bedingung   | Erwarteter Rabatt |
|----------|-----------------------|--------------------|
| 1        | Kaufpreis < 15'000 CHF | 0%                 |
| 2        | 15'000 CHF ≤ Kaufpreis ≤ 20'000 CHF | 5%                 |
| 3        | 20'000 CHF < Kaufpreis ≤ 25'000 CHF | 7%                 |
| 4        | Kaufpreis > 25'000 CHF | 8.5%               |

### Konkrete Testfälle

| Testfall | Kaufpreis (CHF) | Erwarteter Rabatt |
|----------|-----------------|--------------------|
| 1        | 12'000          | 0%                 |
| 2        | 17'500          | 5%                 |
| 3        | 22'000          | 7%                 |
| 4        | 30'000          | 8.5%               |

---

## Übung 2

**Webseite:** Annahme Webseite einer Autovermietung (z.B. www.example-autovermietung.ch)

### 5 Wichtigsten Testfälle für funktionale Black-Box Tests

| ID | Beschreibung                                               | Erwartetes Resultat                                                                                                                                | Effektives Resultat              | Status    | Mögliche Ursache                                        |
|----|----------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------|-----------|---------------------------------------------------------|
| 1  | **Reservierungsformular absenden mit gültigen Daten**   | Buchungsbestätigung wird angezeigt und per E-Mail versendet.                                                                                       | Buchungsbestätigung angezeigt und E-Mail erhalten | Erfolgreich | -                                                       |
| 2  | **Reservierungsformular mit ungültigem Datum absenden** | Fehlermeldung wird angezeigt, die darauf hinweist, dass das Datum ungültig ist, und das Formular wird nicht abgesendet.                          | Fehlermeldung wird angezeigt    | Erfolgreich | Validierung der Datumsangaben fehlerhaft                 |
| 3  | **Filterfunktion für Fahrzeugtypen testen**             | Nach Auswahl eines Fahrzeugtyps werden nur Fahrzeuge dieses Typs in der Ergebnisliste angezeigt.                                                 | Nur Fahrzeuge des gewählten Typs werden angezeigt | Erfolgreich | -                                                       |
| 4  | **Login mit ungültigen Anmeldedaten**                     | Fehlermeldung wird angezeigt, dass die Anmeldedaten falsch sind, und der Login wird verweigert.                                                    | Fehlermeldung wird angezeigt    | Erfolgreich | Authentifizierungsmechanismus fehlerhaft                |
| 5  | **Kontaktformular absenden**                            | Bestätigungsmeldung wird angezeigt, dass die Anfrage erfolgreich übermittelt wurde, und eine Bestätigungs-E-Mail wird an den Benutzer gesendet. | Bestätigungsmeldung angezeigt und E-Mail erhalten | Erfolgreich | -                                                       |

## Übung 3

### Black-Box Testfälle (Benutzersicht)

| **Test-ID** | **Testfallbeschreibung**                                                       | **Erwartetes Ergebnis**                                  |
|-------------|---------------------------------------------------------------------------------|---------------------------------------------------------|
| BB1         | Kontoerstellung mit gültigen Eingabewerten (Name, Währung, Startbetrag)         | Konto wird erstellt, und die Details werden korrekt angezeigt. |
| BB2         | Einzahlung eines positiven Betrags auf ein Konto                                | Der Kontostand erhöht sich um den eingezahlten Betrag.   |
| BB3         | Abhebung eines Betrags innerhalb des Kontostands                                | Der Kontostand verringert sich korrekt um den abgehobenen Betrag. |
| BB4         | Abhebung eines Betrags, der den Kontostand übersteigt                           | Abhebung wird abgelehnt, und der Kontostand bleibt unverändert. |
| BB5         | Abfrage des Kontostands eines bestehenden Kontos                                | Der aktuelle Kontostand wird korrekt angezeigt.         |
| BB6         | Überweisung von einem Konto auf ein anderes mit gleicher Währung               | Beträge werden korrekt abgezogen und hinzugefügt.       |
| BB7         | Überweisung von einem Konto auf ein anderes mit unterschiedlicher Währung       | Beträge werden korrekt umgerechnet und übertragen.      |
| BB8         | Anzeige der Liste aller Konten                                                 | Alle Konten werden mit Namen, IDs und Währungen angezeigt. |
| BB9         | Löschen eines Kontos                                                           | Konto wird aus der Liste entfernt.                      |
| BB10        | Wechselkursabfrage für zwei gültige Währungen                                   | Korrekte Wechselkursinformationen werden angezeigt.     |
| BB11        | Menüeingabe mit ungültigem Zeichen                                             | Fehlermeldung wird angezeigt, und das Menü wiederholt sich. |

---

### White-Box Testfälle (Code-spezifisch)

| **Test-ID** | **Methode**                     | **Testfallbeschreibung**                                               | **Erwartetes Ergebnis**                                  |
|-------------|---------------------------------|-------------------------------------------------------------------------|---------------------------------------------------------|
| WB1         | `Account.deposit()`             | Einzahlung eines positiven Betrags                                     | Betrag wird korrekt zum Kontostand hinzugefügt.         |
| WB2         | `Account.withdraw()`            | Abhebung eines zulässigen Betrags                                      | Betrag wird abgezogen, Rückgabewert ist `true`.         |
| WB3         | `Account.withdraw()`            | Abhebung eines unzulässigen Betrags (über Kontostand)                  | Rückgabewert ist `false`, Kontostand bleibt unverändert. |
| WB4         | `Bank.getAccount()`             | Aufrufen eines bestehenden Kontos anhand der ID                        | Korrektes Konto wird zurückgegeben.                    |
| WB5         | `Bank.printAccountDetails()`    | Anzeige der Details eines existierenden Kontos                         | Alle Kontoinformationen werden korrekt ausgegeben.      |

### Verbesserungsvorschläge

1. **Validierung der Eingaben verbessern:**
   - Mehr Regex checks bei Währungseingaben.

2. **Enum für Währungen erweitern:**
   - Für währungen ein Enum verwenden.

3. **Klarheit der Menüs:**
   - Mehr Hilfetexte und Bestätigungen für funktionen mit starken folgen z.b Acount löschen
