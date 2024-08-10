public class Operator {
    public static char getOperator(String string) throws ScannerException {
        char operator;
        if (string.contains(" + ")) {
            operator = string.charAt(string.indexOf("+"));
        } else if (string.contains(" - ")) {
            operator = string.charAt(string.indexOf("-"));
        } else if (string.contains(" * ")) {
            operator = string.charAt(string.indexOf("*"));
        } else if (string.contains(" / ")) {
            operator = string.charAt(string.indexOf("/"));
        } else throw new ScannerException("Недопустимая операция");
        return operator;
    }
}
