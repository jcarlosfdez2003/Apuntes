package apuntes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;

public class LimitarDecimales {
    public static void main(String[] args) {

        double valor = 123.456789;
        System.out.println("Valor original: " + valor);
        System.out.println();
        // ===============================
        // 1. Mostrar / formatear con X decimales (sin cambiar valor interno)
        // ===============================

        // ===============================
        // 1.1 con String.format / printf
        // ===============================
        String s2 = String.format(Locale.US, "%.2f", valor);
        String s3 = String.format(Locale.US, "%.3f", valor);
        System.out.println("Formateado con String.format (2 decimales): " + s2);
        System.out.println("Formateado con String.format (3 decimales): " + s3);

        // ===============================
        // 1.2 con DecimalForma
        // ===============================
        DecimalFormat dfExacto2 = new DecimalFormat("0.00"); // siempre 2 decimales
        dfExacto2.setRoundingMode(RoundingMode.HALF_UP);
        String dfe2 = dfExacto2.format(valor);
        System.out.println("Formateado con DecimalFormat (exacto 2 decimales): " + dfe2);

        DecimalFormat dfHasta2 = new DecimalFormat("#.##"); // hasta 2 decimales
        dfHasta2.setRoundingMode(RoundingMode.HALF_UP);
        String dfh2 = dfHasta2.format(valor);
        System.out.println("Formateado con DecimalFormat (hasta 2 decimales): " + dfh2);

        System.out.println();

        // ===============================
        // 2. Redondear / limitar el valor numérico
        // ===============================

        // ===============================
        // 2.1 usando Math.round (para 2 decimales)
        // ===============================
        double redondeado = Math.round(valor * 100.0) / 100.0;
        System.out.println("Redondeo con Math.round a 2 decimales: " + redondeado);

        // ===============================
        // 2.2 con BigDecimal + setScale (redondeo, truncado)
        // ===============================

        // — redondeo con HALF_UP
        BigDecimal bd = new BigDecimal(Double.toString(valor));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        double bdRedondeado = bd.doubleValue();
        System.out.println("Redondeo con BigDecimal (HALF_UP, 2 decimales): " + bdRedondeado);

        // — truncar (RoundingMode.DOWN)
        BigDecimal bd2 = new BigDecimal(Double.toString(valor));
        bd2 = bd2.setScale(2, RoundingMode.DOWN);
        double bdTruncado = bd2.doubleValue();
        System.out.println("Truncado con BigDecimal (DOWN, 2 decimales): " + bdTruncado);

        // También ejemplo con 3 decimales
        BigDecimal bd3 = new BigDecimal(Double.toString(valor));
        bd3 = bd3.setScale(3, RoundingMode.HALF_UP);
        System.out.println("Redondeo con BigDecimal (HALF_UP, 3 decimales): " + bd3.doubleValue());

        BigDecimal bd3tr = new BigDecimal(Double.toString(valor));
        bd3tr = bd3tr.setScale(3, RoundingMode.DOWN);
        System.out.println("Truncado con BigDecimal (DOWN, 3 decimales): " + bd3tr.doubleValue());

    }

}
