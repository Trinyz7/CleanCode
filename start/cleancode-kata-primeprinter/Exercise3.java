public class Exercise3 {

    public double calculate(double amount, int type, int years) {
        if (type == 1) {
            return amount;
        }

        double discountRate = (years > 5) ? 0.05 : years / 100.0;
        double discountMultiplier = 1 - discountRate;

        double typeDiscountMultiplier = getTypeDiscountMultiplier(type);
        double discountedAmount = amount * typeDiscountMultiplier;

        return discountedAmount * discountMultiplier;
    }

    private double getTypeDiscountMultiplier(int type) {
        switch (type) {
            case 2:
                return 0.9;
            case 3:
                return 0.7;
            case 4:
                return 0.5;
            default:
                throw new IllegalArgumentException("Invalid account type: " + type);
        }
    }
}
