import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws ScannerException {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if (string.charAt(0) != '"') {
            throw new ScannerException("Первый оператор не может быть числом");
        }
        char operator = Operator.getOperator(string);
        String[] operands = StringsArray.separator(string, operator);
        for (int i = 0; i < operands.length; i++) {
            operands[i] = operands[i].replace("\"", "");
        }
        StringBuilder result = new StringBuilder("\"");
        switch (operator) {
            case '+':
                for (String operand: operands) {
                    result.append(operand);
                }
                result.append('\"');
                if (result.length() > 40) result.replace(41, result.length(), "...");
                System.out.println(result);
                break;
            case '-':
                result.append(operands[0].replace(operands[1], ""));
                result.append('\"');
                if (result.length() > 40) result.replace(41, result.length(), "...");
                System.out.println(result);
                break;
            case '*':
                result.append(String.valueOf(operands[0]).repeat(Math.max(0, Integer.parseInt(operands[1]))));
                result.append('\"');
                if (result.length() > 40) result.replace(41, result.length(), "...");
                System.out.println(result);
                break;
            case '/':
                result.append(operands[0], 0, operands[0].length() / Integer.parseInt(operands[1]));
                result.append('\"');
                if (result.length() > 40) result.replace(41, result.length(), "...");
                System.out.println(result);
        }
    }
}
