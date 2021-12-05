package publisher.util;

import java.nio.charset.StandardCharsets;

public class PublisherUtil {

    public static byte[] doMath(String msg) {
        try {
            String[] values = msg.split(" ");

            String operation = values[1];
            float firstValue = Float.parseFloat(values[0]);
            float secondValue = Float.parseFloat(values[2]);
            float finalValue;

            switch (operation) {
                case "+":
                    finalValue = firstValue + secondValue;
                    break;
                case "-":
                    finalValue = firstValue - secondValue;
                    break;
                case "*":
                    finalValue = firstValue * secondValue;
                    break;
                case "/":
                    if(secondValue == 0) {
                        throw new ArithmeticException("Impossível dividir por zero");
                    } else {
                        finalValue = firstValue / secondValue;
                    }
                    break;
                default:
                    throw new RuntimeException("Padrão de entrada incorreto. Tente algo como \"5 + 5\" ");
            }

            String finalMessage = "O resultado da expressão " + firstValue + " " + operation + " " + secondValue + " é " + finalValue;
            return finalMessage.getBytes(StandardCharsets.UTF_8);
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
            return "Padrão de entrada incorreto. Tente algo como \"5 + 5\" ".getBytes(StandardCharsets.UTF_8);
        } catch (Exception e){
            e.printStackTrace();
            return "Impossível processar solicitação".getBytes(StandardCharsets.UTF_8);
        }
    }
}
