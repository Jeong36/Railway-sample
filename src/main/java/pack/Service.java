package pack;

import java.util.function.Function;

import static pack.Utility.flatmap;
import static pack.Utility.pipe;

public class Service {

    private final Function<String, TwoTrack<String>> inputNotBlank = input -> {
        if(input.equals("")) {
            return TwoTrack.failure("Input must not be blank");
        }
        return TwoTrack.success(input);
    };

    private final Function<String, TwoTrack<String>> input50 = input -> {
        if (input.length() > 50) {
            return TwoTrack.failure("Input must not be longer than 50 chars");
        }
        return TwoTrack.success(input);
    };

    private final Function<String, TwoTrack<String>> inputStartsWithNoneA = input -> {
        if (input.startsWith("A")) {
            return TwoTrack.failure("Input must not be chars with prefix A");
        }
        return TwoTrack.success(input);
    };

    public TwoTrack<String> process(String input) {

        return pipe(
            flatmap(inputNotBlank),
            flatmap(input50),
            flatmap(inputStartsWithNoneA)).apply(TwoTrack.success(input));
    }
}
