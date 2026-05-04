public class StandardCalculator implements feeCalculator {
    public double calculateDistance(User source, User destination) {
        double deltaX = source.getXCoordinate() - destination.getXCoordinate();
        double deltaY = source.getYCoordinate() - destination.getYCoordinate();

        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    public double calculateDeliveryFee(double distance) {
        double ratePerUnit = 2500;
        return distance * ratePerUnit;
    }
}
