package org.hbrs.se1.ss24.uebung1.businesslogic;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class GermanFormatNumberTransformer extends  BasisNumberTransformer {

    @Override
    String transformValidNumber(int number) {
        // Um die deutsche Zahlenformatierung zu erhalten.
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.GERMAN);
        symbols.setGroupingSeparator('.');

        //
        DecimalFormat germanFormat = new DecimalFormat("#,###", symbols);
        return germanFormat.format(number);
    }

    @Override
    public String getTransformerType() {
        return "Transformer für römische Zahlen";
    }
}
