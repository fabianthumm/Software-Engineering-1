package org.hbrs.se1.ss24.uebung1.businesslogic.factory;

import org.hbrs.se1.ss24.uebung1.businesslogic.GermanFormatNumberTransformer;
import org.hbrs.se1.ss24.uebung1.businesslogic.NumberTransformer;
import org.hbrs.se1.ss24.uebung1.businesslogic.RomanNumberTransformer;

public class TransformerFactory {
    public static NumberTransformer createRomanNumberTransformer() {
        return new RomanNumberTransformer();
    }

    public static NumberTransformer createGermanFormatNumberTransformer() {
        return new GermanFormatNumberTransformer();
    }
}
