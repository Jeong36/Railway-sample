package pack;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final var service = new Service();

        final var list = List.of("",
            "abcfejiwfjewifjewifjewifjewifjewoifjeiwofjiewofjiewofjwiofjweoifjweiofjweiffewfewfewfewwefewf",
            "Aerererererere",
            "hello");

        list.forEach(input -> {
            final var result = service.process(input);
            final var isSuccess = result.isSuccess();
            System.out.println("`" + input + "`: " + isSuccess + (isSuccess ? "" : ", " + result.getMessage()));
        });
    }
}
