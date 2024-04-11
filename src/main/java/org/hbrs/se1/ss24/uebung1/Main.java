package org.hbrs.se1.ss24.uebung1;

import org.hbrs.se1.ss24.uebung1.businesslogic.GermanFormatNumberTransformer;
import org.hbrs.se1.ss24.uebung1.businesslogic.NumberTransformer;
import org.hbrs.se1.ss24.uebung1.businesslogic.RomanNumberTransformer;
import org.hbrs.se1.ss24.uebung1.client.Client;

public class Main {

    public static void main(String[] args){

        NumberTransformer TestRomanNumberTransformer = new RomanNumberTransformer();
        NumberTransformer TestGermanFormatNumberTransformer = new GermanFormatNumberTransformer();


        System.out.println("TestRomanNumberTransformer: " + TestRomanNumberTransformer.transformNumber(1245));
        System.out.println("TestRomanNumberTransformer: " + TestRomanNumberTransformer.getTransformerType());

        System.out.println("TestGermanFormatNumberTransformer: " + TestGermanFormatNumberTransformer.transformNumber(1245));
        System.out.println("TestGermanFormatNumberTransformer: " + TestGermanFormatNumberTransformer.getTransformerType());

        Client TestClient = new Client();
        TestClient.printTransformation(1245);
    }
}
