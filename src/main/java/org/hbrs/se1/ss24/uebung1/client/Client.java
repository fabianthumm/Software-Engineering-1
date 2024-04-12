package org.hbrs.se1.ss24.uebung1.client;

import org.hbrs.se1.ss24.uebung1.businesslogic.factory.TransformerFactory;

public class Client {
    public void printTransformation(int number) {

        String result = TransformerFactory.createRomanNumberTransformer().transformNumber(number);

        System.out.println("Die römische Schreibweise der Zahl " + number + " ist: " + result);
    }
}
