### Einfache Notizen zum Text

#### **Gründe für das Testen**
- Software ist überall: Geräte, Maschinen, Unternehmen.
- Qualität der Software ist entscheidend für Erfolg.
- Testen hilft, Fehler zu finden und Qualität sicherzustellen.

---

#### **Fehler und Mangel**
- **Fehler:** System verhält sich anders als gewünscht (IST ≠ SOLL).
- **Mangel:** System erfüllt Anforderungen, aber nicht vollständig oder korrekt (z. B. schlechte Darstellung).

---

#### **Fehlermaskierung**
- Fehler wird durch andere Programmteile verdeckt.
- Fehler zeigt sich erst später, wenn andere Teile geändert werden.

---

#### **Kann alles getestet werden?**
- Vollständiges Testen ist unmöglich (zu viele Kombinationen).
- Tests müssen wichtige Fehler finden, redundanzfrei sein und viel Code prüfen.

---

#### **Testaufwand**
- Testaufwand hängt vom möglichen Schaden ab.
- Kritische Systeme (z. B. lebensgefährliche Fehler) müssen intensiver getestet werden.

---

#### **V-Modell**
- Entwicklung (linker Ast) und Testen (rechter Ast) laufen parallel.
- Testarten:
  1. **Komponententest:** Einzelne Bausteine prüfen.
  2. **Integrationstest:** Zusammenspiel von Bausteinen prüfen.
  3. **Systemtest:** Gesamtsystem prüfen.
  4. **Abnahmetest:** Kunde prüft, ob alles passt.

---

#### **SCRUM und iteratives Testen**
- Software wird in kleinen Schritten entwickelt (Inkremente).
- Tests müssen wiederholt werden (wichtig: Automatisierung).
- Jede Version wird getestet, bevor sie als fertig gilt.

---

#### **Wichtige Kriterien für Tests**
- Fehlerwahrscheinlichkeit hoch.
- Keine doppelten Tests.
- Unabhängige Tests.
- Möglichst viel Code abdecken.
