package org.hbrs.se1.ss24.uebung1.client;

import org.hbrs.se1.ss24.uebung1.businesslogic.RomanNumberTransformer;

public class Client {
    public void printTransformation(int number) {

        String result = RomanNumberTransformer.Factory.createRomanNumberTransformer().transformNumber(number);

        System.out.println("Die römische Schreibweise der Zahl " + number + " ist: " + result);
    }
}
