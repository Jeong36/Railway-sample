package pack;

import java.util.function.Function;
import java.util.stream.Stream;

public class Utility {

    public static <T> Function<TwoTrack<T>, TwoTrack<T>> flatmap(Function<T, TwoTrack<T>> fn) {
        return input -> {
            if (input.isSuccess() && input.getValue().isPresent()) {
                return fn.apply(input.getValue().get());
            }
            return TwoTrack.failure(input.getMessage());
        };
    }

    @SafeVarargs
    public static <T> Function<TwoTrack<T>, TwoTrack<T>> pipe(Function<TwoTrack<T>, TwoTrack<T>>... fns) {

        return Stream.of(fns)
            .reduce(twoTrack -> twoTrack, Function::andThen);
    }
}
