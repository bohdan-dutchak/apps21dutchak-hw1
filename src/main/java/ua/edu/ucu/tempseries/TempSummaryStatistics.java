package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private double avgTemp;
    private double devTemp;
    private double minTemp;
    private double maxTemp;

    public TempSummaryStatistics(double a, double b, double c, double d) {
        this.avgTemp = a;
        this.devTemp = b;
        this.minTemp = c;
        this.maxTemp = d;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }
}
