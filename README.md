# Übung 1

#### Aufgabe 1.1 (Wiederholung Java, Erstes Muster, Blackbox-Testing)
Diese Vorlesung behandelt Methoden zur Entwicklung komplexer Software-Systeme. Zur Vorbereitung werden in dieser Übung Grundlagen der objektorientierten Programmierung in Java wiederholt und vertieft. In den Kapiteln zu Entwurfsmustern und Softwaretesten werden diese Vorkenntnisse vorausgesetzt.

Gegeben sind die Klasse `Client` sowie das Interface `NumberTransformer`, herunterladbar auf dem GitLab-Repository der Vorlesung:

https://gitlab.com/hackeloeer/codesSS2024

---
#### Aufgabe 1.1.1
Implementieren Sie zwei verschiedene Varianten einer Implementierung des Interfaces `NumberTransformer`:

Eine Variante `RomanNumberTransformer`, die beim Aufruf von `transformNumber()` die übergebene Zahl als römische Zahl zurückliefert. Diese Variante soll beim Aufruf von `getTransformerType()` den String `„Transformer für römische Zahlen“` zurückliefern. Eine Beispielimplementierung der Konversion in römische Zahlen wird hier gegeben:

```java
String[] romanSymbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"}; 

int[] romanValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000}; 

int number = 1234; // z.B. 

StringBuilder romanNumeral = new StringBuilder(); 
for (int i = romanValues.length - 1; i >= 0; i--) { 
	while (number >= romanValues[i]) {
	romanNumeral.append(romanSymbols[i]);
	number -= romanValues[i];
	} 
} 

String result = romanNumeral.toString();
```

Eine Variante `GermanFormatNumberTransformer`, die beim Aufruf von `transformNumber()` die übergebene Zahl in deutscher Zahlenformatierung (Beispiel: „1425“ wird zu „1.425“) unter Verwendung der Java-Framework-Klasse `DecimalFormat` zurückliefert. Diese Variante soll beim Aufruf von `getTransformerType()` den String `„Transformer für deutsche Zahlenformatierungen“` zurückliefern.

Beide Implementierungen sollen nur Zahlen zwischen 1 und 3000 akzeptieren und bei Aufrufen außerhalb dieses Wertebereichs die gleiche Fehlermeldung als String zurückgeben.

- **Frage 1:** Wie können Sie unter Berücksichtigung der Prinzipien des objektorientierten Entwurfs dafür sorgen, dass der Code, der den beiden Implementierungen gemeinsam ist, nicht dupliziert wird?

#### Lösung 1.1.1

- **Antwort 1:** Ich gehe davon aus, dass das Interface `NumberTransformer` nicht editiert werden darf und habe daher eine neue abstrakte Klasse `BasisNumberTransformer` verwendet, um durch Vererbung nur an einer Stelle im Quelltext den Wertebereich zu prüfen.

---
#### Aufgabe 1.1.2
Implementieren Sie die Klasse Client so, dass eine der Methode `printTransformation()` übergebene Zahl in die korrespondierende römische Zahl umgewandelt und diese ausgegeben wird, wobei Ihre Implementierung des `RomanNumberTransformer` aus Aufgabe 1.1.1 genutzt wird. Die Implementierung darf **keine** Instanz der Klasse `RomanNumberTransformer` oder einer anderen Klasse mit dem Schlüsselwort `new` unmittelbar erzeugen!

- **Frage 2:** Wie kann die Objekterzeugung mit Hilfe einer zusätzlichen Klasse durchgeführt werden? In welchem Package sollte diese zusätzliche Klasse liegen?
- **Frage 3:** Welches Entwurfsmuster liegt für diesen Anwendungsfall nahe? Welchen Vorteil bringt die Nutzung dieses Entwurfsmusters?

#### Lösung 1.1.2
Die Implementierung befindet sich unter: 
https://github.com/fabianthumm/Software-Engineering-1/

- **Antwort 2:** Die Objekterzeugung kann durch eine zusätzliche Klasse Namens `TransformerFactory` umgesetzt werden. Dies sollte im Package `factory` angelegt werden.
- **Antwort 3**: Dabei wird das _Factory_ Entwurfsmuster verwendet, welches die Erzeugung von Objekten kapselt und eine Schnittstelle zum Erstellen von Objekten bereitstellt, ohne dass der `Client` die genaue Klasse kennen muss, die erstellt wird.

---
#### Aufgabe 1.1.3
Erstellen Sie einen Blackbox-Test für Ihre Implementierung der Methode `transformNumber()` der Klasse `RomanNumberTransformer`. Zur Vorgehensweise beachten Sie bitte die bereitgestellte Quelle (Spillner und Linz, 2012) auf LEA im Ordner zur Übung Nr. 1. Sie können sich grob an der bereitgestellten Klasse `TestRomanNumberTransformer` orientieren.

Die Tests müssen sich in einer separaten Test-Klasse in einem eigenen Test-Package befinden. Bestimmen Sie die auftretenden Äquivalenzklassen, identifizieren Sie jeweils einen geeigneten Repräsentanten und implementieren Sie Positiv- und Negativtestfälle, welche eine _hinreichende_ Testabdeckung erzeugen. Es wird geraten, hierzu das Framework JUnit5 zu verwenden. Die Abhängigkeiten für JUnit 5 kann IntelliJ IDEA automatisch herunterladen und im Projektverzeichnis ablegen, wenn eine Testklasse mit JUnit-Annotationen angelegt wird.

Spezifizieren Sie die Testfälle und die Äquivalenzklassen in der Excel-Vorlage „TemplateTestCase“ (siehe LEA, Ordner zur Übung Nr.1).

- **Frage 4:** Warum sollten Testfälle in einer separaten Test-Klasse implementiert werden? 
- **Frage 5:** Wozu dienen die Äquivalenzklassen im Blackbox-Test? 
- **Frage 6:** Warum lässt sich für die Klasse Client nicht ohne weiteres ein Blackbox-Test umsetzen?

_Literaturempfehlung für den Black-Box-Test:_
Spillner, A. und Linz, T.: Basiswissen für den Softwaretest. dpunkt.Verlag, 5. Auflage. 2012 (Kapitel 5, siehe Kopie auf LEA, Ordner Übung Nr. 1)

#### Lösung 1.1.3

Gültige und ungültige Äquivalenzklassen sowie ihre Repräsentanten und die erwarteten Ergebnisse:

| Parameter | Äquivalenzklasse          | Repräsentant | Erwartetes Ergebnis                       |
| --------- | ------------------------- | ------------ | ----------------------------------------- |
| `number`  | $\text{gÄK}_1: 1\leq x \leq 3000$  | 1245         | `"MCCXLV"`                                |
| `number`  | $\text{gÄK}_2: x=1$       | 1            | `"I"`                                     |
| `number`  | $\text{gÄK}_3: x=3000$    | 3000         | `"MMM"`                                   |
| `number`  | $\text{uÄK}_1: x<0$       | -17          | `"Eingabe ausserhalb des Wertebereichs!"` |
| `number`  | $\text{uÄK}_2: x=-\infty$ | MIN_INT      | `"Eingabe ausserhalb des Wertebereichs!"` |
| `number`  | $\text{uÄK}_3: x=0$       | 0            | `"Eingabe ausserhalb des Wertebereichs!"` |
| `number`  | $\text{uÄK}_4: x\geq3001$ | 5429         | `"Eingabe ausserhalb des Wertebereichs!"` |
| `number`  | $\text{uÄK}_5: x=\infty$  | MAX_INT      | `"Eingabe ausserhalb des Wertebereichs!"` |

Die Äquivalenzklassen können nicht zusammengefasst werden, obwohl sie alle das gleiche erwartete Ergebnis abdecken. Nur so kann der Wertebereich nach oben und unten getestet werden. Es ist auch sinnvoll, den Testfall mit $x=0$ zu berücksichtigen, da eine Nullbelegung häufig zu ungewollten Programmfehlern führt und daher ebenfalls getestet werden sollte.

- **Antwort 4:** Um eine klare Trennung zwischen Testcode und Produktionscode zu gewährleisten, sollten Testfälle in einer separaten Test-Klasse implementiert werden.  
- **Antwort 5:** Die Äquivalenzklassen im Blackbox-Test dienen dazu, den Eingabebereich in Äquivalenzklassen zu unterteilen. Jede Klasse enthält äquivalente Eingabewerte, die ein ähnliches Verhalten des Systems erwarten lassen. Dies ermöglicht eine effiziente Testabdeckung, da es nicht immer möglich ist, jede Eingabe zu testen.
- **Antwort 6**: In der Klasse `Client` ist die Methode `printTransformation(int): void` schwer zu testen, da der Rückgabetyp `void` ist und somit keine unterschiedlichen Rückgabewerte für die verschiedenen `int` Eingaben getestet werden können.

---
#### Aufgabe 1.2 (Modellierung mit UML-Klassendiagrammen)
Modellieren Sie nun Ihr Software-System aus der Aufgabe 1.1 (einschließlich der Test- Klasse) als UML-Klassendiagramm. Hierfür können Sie eines der folgenden Tools verwenden: 

- Draw.io: https://app.diagrams.net/ Browserbasiert, keine lokale Installation notwendig. 
- UMLet 15.0: http://www.umlet.com/ Modellierungstool für Windows / Macintosh / Linux. Unterstützt keine Sequenzdiagramme. 

Beziehungen zwischen den Klassen können Sie für diese Übung in Form einer einfachen Verwendungsbeziehung modellieren. Bitte exportieren Sie das Modell in ein PDF- Dokument und laden Sie dieses auf LEA hoch.

_Literaturempfehlung zu UML: Seidl, Martina et al.:_
UML @ Classroom – An Introduction to Object-Oriented Modelling. Springer, 2015. (in Englisch, online verfügbar in der Bibliothek). Eine gute Einführung zu Klassendiagrammen finden sie in diesem Buch in Abschnitt 4.

#### Lösung 1.2

