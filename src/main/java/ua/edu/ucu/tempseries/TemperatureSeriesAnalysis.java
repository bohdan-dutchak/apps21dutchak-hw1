package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

import static java.lang.Math.*;

public class TemperatureSeriesAnalysis {
    private double[] data = null;
    private int size;
    private int capacity;

    public TemperatureSeriesAnalysis() {
        this.size = 0;
        this.capacity = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        if (validateData(temperatureSeries)) {
            this.size = temperatureSeries.length;
            this.capacity = this.size;
            this.data = new double[this.size];
            for (int i = 0; i < this.size; i++) {
                this.data[i] = temperatureSeries[i];
            }
        } else {
            throw new InputMismatchException("Input error!");
        }
    }

    public double average() {
        if (!validation()) {
            throw new IllegalArgumentException("Error in average()");
        }
        double sum = 0;
        for (int i = 0; i < this.size; i++) {
            sum += this.data[i];
        }
        return sum / this.size;
    }

    public double deviation() {
        if (!validation()) {
            throw new IllegalArgumentException("Error in deviation()");
        }
        double deviationSum = 0;
        double mean = average();
        for (int i = 0; i < this.size; i++) {
            deviationSum += (this.data[i] - mean) * (this.data[i] - mean);
        }
        return sqrt(deviationSum / this.size);
    }

    public double min() {
        if (!validation()) {
            String error = "Error in min(). There is no data inputted";
            throw new IllegalArgumentException(error);
        }
        double min = this.data[0];
        for (int i = 1; i < this.size; i++) {
            if (this.data[i] < min) {
                min = this.data[i];
            }
        }
        return min;
    }

    public double max() {
        if (!validation()) {
            String error = "Error in max(). There is no data inputted";
            throw new IllegalArgumentException(error);
        }
        double max = this.data[0];
        for (int i = 1; i < this.size; i++) {
            if (this.data[i] > max) {
                max = this.data[i];
            }
        }
        return max;
    }

    public double findTempClosestToZero() {
        if (!validation()) {
            String error = "Error in findTempClosestToZero()";
            throw new IllegalArgumentException(error);
        }
        double min = this.data[0];
        for (int i = 1; i < this.size; i++) {
            if (abs(this.data[i]) < min) {
                min = this.data[i];
            }
            if (abs(min) == this.data[i]) {
                min = abs(min);
            }
        }
        return min;
    }

    public double findTempClosestToValue(double tempValue) {
        if (!validation()) {
            String error = "Error in findTempClosestToValue()";
            throw new IllegalArgumentException(error);
        }
        double min = this.data[0];
        for (int i = 1; i < this.size; i++) {
            if (abs(this.data[i] - tempValue) < abs(min - tempValue)) {
                min = this.data[i];
            }
            if (abs(this.data[i] - tempValue) == abs(min - tempValue)) {
                min = Math.max(this.data[i], min);
            }

        }
        return min;
    }

    public double[] findTempsLessThen(double tempValue) {
        if (!validation()) {
            String error = "Error in findTempsLessThen()";
            throw new IllegalArgumentException(error);
        }
        int n = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] < tempValue) {
                n++;
            }
        }
        double[] result = new double[n];
        n = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] < tempValue) {
                result[n] = this.data[i];
                n++;
            }
        }
        return result;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (!validation()) {
            String error = "Error in findTempsGreaterThen()";
            throw new IllegalArgumentException(error);
        }
        int n = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] > tempValue) {
                n++;
            }
        }
        double[] result = new double[n];
        n = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] > tempValue) {
                result[n] = this.data[i];
                n++;
            }
        }
        return result;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (!validation()) {
            String error = "Error in TempSummaryStatistics()";
            throw new IllegalArgumentException(error);
        }
        double a = average(), b = deviation(), c = min(), d = max();
        final TempSummaryStatistics RES = new TempSummaryStatistics(a, b, c, d);
        return RES;
    }

    public int addTemps(double[] temps) {
        if (validateData(temps)) {
            int n = temps.length;

            while (n + this.size > this.capacity) {
                this.capacity *= 2;
            }

            double[] newdata = new double[this.capacity];
            for (int i = 0; i < this.size; i++) {
                newdata[i] = this.data[i];
            }
            for (int i = 0; i < n; i++) {
                newdata[i + this.size] = temps[i];
            }
            this.size += n;
            this.data = newdata;

            return this.size;
        } else {
            throw new InputMismatchException("Invalid input");
        }
    }

    private boolean validation() {
        if (this.data == null || this.size < 1) {
            return false;
        }
        return true;
    }

    private boolean validateData(double[] arr) {
        final double MINTEMP = -273;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < MINTEMP) {
                return false;
            }
        }
        return true;
    }
}
