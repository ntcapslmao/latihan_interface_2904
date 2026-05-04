public interface FeeCalculator {
    public double calculateDistance(User source, User destination);
    public double calculateDeliveryFee(double distance);
}
