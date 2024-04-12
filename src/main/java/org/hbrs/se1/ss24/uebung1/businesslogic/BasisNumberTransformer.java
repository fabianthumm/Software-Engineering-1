package org.hbrs.se1.ss24.uebung1.businesslogic;

public abstract class BasisNumberTransformer implements NumberTransformer {

    /*
    Ich gehe davon aus, dass das Interface "NumberTransformer" nicht editiert werden darf
    und habe daher eine neue abstrakte Klasse "BasisNumberTransformer" verwendet, um durch Vererbung
    nur an einer Stelle im Quelltext den Wertebereich zu prüfen.
     */

    @Override
    public String transformNumber(int number) {

        // Pruefen ob number im Wertebereich ist
        if (number < 1 || number > 3000) {
            return "Eingabe ausserhalb des Wertebereichs!";
        }
        return transformValidNumber(number);
    }

    abstract String transformValidNumber(int number);

}
