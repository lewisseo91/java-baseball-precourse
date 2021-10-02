package baseball.domain;

public enum BallStatus {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String displayName;

    BallStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
