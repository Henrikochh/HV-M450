# Übungen
Source: https://gitlab.com/ch-tbz-it/Stud/m450/m450/-/blob/main/Unterlagen/unit-testing/UEBUNGEN.md

## Aufgabe 1 - Simpler Rechner
Wird in person gezeigt.
## Aufgabe 2 - JUnit Zusammenfassung
**1. Testmethoden & -klassen:**

*   **`@Test`:**  Kennzeichnet eine Testmethode.
*   **Testklasse:** Enthält Testmethoden, Name endet üblicherweise auf `Test`.

**Beispiel:**

```java
@Test
void testAddition() {
    // Testcode
}
```

**2. Assertions:**

*   **`Assertions`:** Methoden zum Überprüfen von Ergebnissen.
*   **Wichtige Assertions:**
    *   `assertEquals(erwartet, ergebnis)`
    *   `assertTrue(bedingung)`
    *   `assertThrows(exceptionTyp, code)`

**Beispiel:**

```java
assertEquals(5, 2 + 3);
assertThrows(IllegalArgumentException.class, () -> {});
```

**3. Setup & Teardown:**

*   **`@BeforeEach`:**  Code, der vor *jedem* Test läuft.
*   **`@AfterEach`:** Code, der nach *jedem* Test läuft.
*   **`@BeforeAll`:** Code, der *einmal* vor allen Tests der Klasse läuft (statisch).
*   **`@AfterAll`:** Code, der *einmal* nach allen Tests der Klasse läuft (statisch).

**4. Weiteres:**

*   **`@Disabled`:** Deaktiviert Tests.
*   **`@Timeout`:** Begrenzt die Ausführungszeit.
*   **`@TestMethodOrder` & `@Order`:** Steuert die Reihenfolge der Testausführung.

## Aufgabe 3 - Banken Simulation
Im Projekt geht es um eine bank. Man kan mehrere konten haben. Es wird zwischen PromoYouthSavingsAccount, welcher den Savings account extended und dem Salray account die beide wieder um die klasse Account extenden. Von der bank klasse kann man neue Accounts erstellen und weitere Aktionen, wie den aktuellen Kontostand abrufen. In der Booking klasse werden Transaktionen ausgefuhrert. Durch die BankUtils klasse werden dan unteranderemv die Daten der transaktion formatiert ausgegeben.  <br><br>
![image](https://github.com/user-attachments/assets/c5811e20-9faf-4403-994b-244d525bbca5)

## Aufgabe 4 - Unit-Tests implementieren
Wird in person gezeigt.

