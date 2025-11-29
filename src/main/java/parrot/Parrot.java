package parrot;

public class Parrot {

    private static final double BASE_SPEED = 12.0;
    private static final double LOAD_FACTOR = 9.0;
    private static final double MAX_NORWEGIAN_SPEED = 24.0;
    private static final double MIN_SPEED = 0.0;

    private final ParrotTypeEnum type;
    private final int numberOfCoconuts;
    private final double voltage;
    private final boolean isNailed;

    public Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public double getSpeed() {
        return switch (type) {
            case EUROPEAN -> calculateEuropeanSpeed();
            case AFRICAN -> calculateAfricanSpeed();
            case NORWEGIAN_BLUE -> calculateNorwegianBlueSpeed();
        };
    }

    private double calculateEuropeanSpeed() {
        return BASE_SPEED;
    }

    private double calculateAfricanSpeed() {
        double coconutWeightPenalty = LOAD_FACTOR * numberOfCoconuts;
        double speedAfterPenalty = BASE_SPEED - coconutWeightPenalty;
        return Math.max(MIN_SPEED, speedAfterPenalty);
    }

    private double calculateNorwegianBlueSpeed() {
        if (isNailed) {
            return MIN_SPEED;
        }

        double voltageGeneratedSpeed = voltage * BASE_SPEED;
        double limitedSpeed = Math.min(MAX_NORWEGIAN_SPEED, voltageGeneratedSpeed);

        return limitedSpeed;
    }

    public String getCry() {
        return switch (type) {
            case EUROPEAN -> "Sqoork!";
            case AFRICAN -> "Sqaark!";
            case NORWEGIAN_BLUE -> voltage > 0 ? "Bzzzzzz" : "...";
        };
    }
}
