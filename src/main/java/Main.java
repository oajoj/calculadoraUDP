import consumer.Consumer;
import publisher.Publisher;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        new Publisher().start();
        Consumer consumer = new Consumer();
        Boolean flag = true;
        Scanner scan = new Scanner(System.in);

        while (flag) {
            System.out.println("Insira a expressão\nPara sair digite \"end\" ");
            String value = scan.nextLine();

            if(value.contains("end")){
                consumer.closeSocket();
                flag = false;

                continue;
            }

            consumer.sendMessage(value);
        }
    }
}
