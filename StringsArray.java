public class StringsArray {
    public static String[] separator(String string, char operator) throws ScannerException {
        String[] strings = switch (operator) {
            case '+' -> string.split(" \\+ ");
            case '*' -> string.split(" \\* ");
            default -> string.split(" " + operator + " ");
        };
        if (strings[0].length() > 12) throw new ScannerException("Длинна первой строки превысла 10 символов");
        if (operator == '*' || operator == '/') {
            if (strings[1].length() > 2) {
                throw new ScannerException("Второй оператор должен быть целым числом от 1 до 10");
            }
            if (strings[1].contains("\"") || strings[1].contains("\\.")) {
                throw new ScannerException("Второй оператор должен быть целым числом от 1 до 10");
            }
            if (strings[1].length() == 2 && !strings[1].contains("10")) {
                throw new ScannerException("Второй оператор должен быть целым числом от 1 до 10");
            }
        }
        if (operator == '+' || operator == '-') {
            if (!strings[1].contains("\"")) throw new ScannerException("Второй оператор должен быть строкой");
            if (strings[1].length() > 12) throw new ScannerException("Длинна второй строки превысла 10 символов");
        }
        return strings;
    }
}
