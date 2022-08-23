package pack;

import java.util.Optional;

public class TwoTrack<T> {

    private final Success<T> success;
    private final Failure failure;

    private TwoTrack(Failure failure) {
        this.success = null;
        this.failure = failure;
    }

    private TwoTrack(Success<T> success) {
        this.success = success;
        this.failure = null;
    }

    public static <T> TwoTrack<T> failure(String message) {
        return new TwoTrack<>(new Failure(message));
    }

    public static <T> TwoTrack<T> success(T input) {
        return new TwoTrack<>(new Success<>(input));
    }

    public Optional<T> getValue() {
        if (success == null) {
            return Optional.empty();
        }

        return Optional.of(success.getValue());
    }

    public String getMessage() {
        if (failure == null) {
            return "";
        }

        return failure.getMessage();
    }

    public boolean isSuccess() {
        return success != null;
    }
}
