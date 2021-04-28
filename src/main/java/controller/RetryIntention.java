package controller;

public enum RetryIntention {
    RETRY(1, true),
    EXIT(2, false);
    private int value;
    private boolean isRetry;

    RetryIntention(int value, boolean isRetry) {
        this.value = value;
        this.isRetry = isRetry;
    }

    public boolean isRetry(){
        return isRetry;
    }

    public static RetryIntention valueOf(int value) {
        if (value == RETRY.value) {
            return RETRY;
        }
        if (value == EXIT.value) {
            return EXIT;
        }
        throw new IllegalArgumentException("1 또는 2를 입력해 주세요.");
    }
}
