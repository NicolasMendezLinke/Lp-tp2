package parrot;

/**
 * Representa um papagaio que calcula sua velocidade e seu grito
 * com base no tipo da espécie e outras características como
 * número de cocos, voltagem e se está pregado.
 */
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
        double penalty = LOAD_FACTOR * numberOfCoconuts;
        double finalSpeed = BASE_SPEED - penalty;
        return Math.max(MIN_SPEED, finalSpeed);
    }

    private double calculateNorwegianBlueSpeed() {
        if (isNailed) {
            return MIN_SPEED;
        }

        double generatedSpeed = voltage * BASE_SPEED;
        return Math.min(MAX_NORWEGIAN_SPEED, generatedSpeed);
    }

    public String getCry() {
        return switch (type) {
            case EUROPEAN -> "Sqoork!";
            case AFRICAN -> "Sqaark!";
            case NORWEGIAN_BLUE -> voltage > 0 ? "Bzzzzzz" : "...";
        };
    }
}

