package baseball.domain;

public enum RestartStatus {
    RESTART("1"),
    FINISH("2");

    public String value;

    RestartStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
