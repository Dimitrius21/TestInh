package by.epam.lab;

public enum RoundMethod {
    FLOOR {
        double roundFunction(double d) {
            return Math.floor(d);
        }
    },
    CEIL {
        double roundFunction(double d) {
            return Math.ceil(d);
        }
    },
    ROUND {
        double roundFunction(double d) {
            return Math.round(d);
        }
    };

    abstract double roundFunction(double value);

    public static int roundValue(double roundedValue, RoundMethod roundMethod, int d) {
        int tenPow = pow10(d);
        int result = (int) roundMethod.roundFunction(roundedValue / tenPow) * tenPow;
        return result;
    }

    private static int pow10(int d) {
        if (d > 0) {
            d--;
            return 10 * pow10(d);
        }
        return 1;
    }

}
