public class Challenge42 {
    public static void main(String[] args) {
        String value1 = "20°F";
        value1 = value1.toUpperCase();

        if (validator(value1)) {
            System.out.println(converter(value1));
        }

        System.out.println("El programa termino");
    }

    private static Boolean validator(String value) {

        if (!value.trim().contains("°") || !value.trim().contains("°")) {
            System.out.println("No exite ° ");
            return false;
        }

        if (!value.trim().contains("°C")) {

            if (value.trim().contains("°F"))
                return true;

            System.out.println("No hay unidad de medida");
            return false;
        }

        return true;
    }

    private static Double converter(String value) {

        if (value.trim().contains("C")) {

            System.out.println("Convirtiendo de Celsius a Fahrenheit");
            Double celcius = Double.valueOf(value.trim().replace("°C", ""));

            Double fathr = celcius * 1.8 + 32.0;

            return fathr;
        }

        System.out.println("Convirtiendo de Fahrenheit a Celcius");
        Double fathr = Double.valueOf(value.trim().replace("°F", ""));

        Double celcius = (fathr - 32.0) + 1.8;

        return celcius;
    }
}
