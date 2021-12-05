package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {


    @Test(expected = IllegalArgumentException.class)
    public void testEmptyConstructor() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();

        // expect exception here
        seriesAnalysis.average();
    }

    @Test(expected = InputMismatchException.class)
    public void testConstructor() {
        double[] temperatureSeries = {1, 2, 3, 4, 5, -301.0111};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] a = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double expResult = 1.0;

        double actualResult = b.average();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviationWithOneElementArray() {
        // setup input data and expected result
        double[] a = {-1.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double expResult = 0;

        // call tested method
        double actualResult = b.deviation();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] a = {};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);

        // expect exception here
        b.average();
    }

    @Test
    public void testDeviation() {
        double[] a = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double expResult = 3.7416;

        double actualResult = b.deviation();

        assertEquals(expResult, actualResult, 0.001);
    }

    @Test
    public void testMinWithOneElementArray() {
        // setup input data and expected result
        double[] a = {-1.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double expResult = -1.0;

        // call tested method
        double actualResult = b.min();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] a = {};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);

        // expect exception here
        b.min();
    }

    @Test
    public void testMin() {
        double[] a = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double expResult = -5;

        double actualResult = b.min();

        assertEquals(expResult, actualResult, 0.001);
    }

    @Test
    public void testMin2() {
        double[] a = {1.0, 1.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double expResult = 1;

        double actualResult = b.min();

        assertEquals(expResult, actualResult, 0.001);
    }

    @Test
    public void testMaxWithOneElementArray() {
        // setup input data and expected result
        double[] a = {-1.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double expResult = -1.0;

        // call tested method
        double actualResult = b.max();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] a = {};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);

        // expect exception here
        b.max();
    }

    @Test
    public void testMax() {
        double[] a = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double expResult = 5;

        double actualResult = b.max();

        assertEquals(expResult, actualResult, 0.001);
    }

    @Test
    public void testMax2() {
        double[] a = {1.0, 1.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double expResult = 1;

        double actualResult = b.max();

        assertEquals(expResult, actualResult, 0.001);
    }

    @Test
    public void testClosestWithOneElementArray() {
        // setup input data and expected result
        double[] a = {-1.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double expResult = -1.0;

        // call tested method
        double actualResult = b.findTempClosestToZero();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestWithEmptyArray() {
        double[] a = {};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);

        // expect exception here
        b.findTempClosestToZero();
    }

    @Test
    public void testClosest() {
        double[] a = {3.0, -5.0, -1.0, 5.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double expResult = -1;

        double actualResult = b.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.001);
    }

    @Test
    public void testClosest2() {
        double[] a = {1.0, -1.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double expResult = 1;

        double actualResult = b.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.001);
    }

    @Test
    public void testClosest3() {
        double[] a = {-1.0, 1.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double expResult = 1;

        double actualResult = b.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.001);
    }

    @Test
    public void testClosestToValueWithOneElementArray() {
        // setup input data and expected result
        double[] a = {-1.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double expResult = -1.0;

        // call tested method
        double actualResult = b.findTempClosestToValue(5);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToValueWithEmptyArray() {
        double[] a = {};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);

        // expect exception here
        b.findTempClosestToValue(-10);
    }

    @Test
    public void testClosestToValue() {
        double[] a = {3.0, -5.0, -1.0, 5.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double expResult = -1;

        double actualResult = b.findTempClosestToValue(0);

        assertEquals(expResult, actualResult, 0.001);
    }

    @Test
    public void testClosestToValue2() {
        double[] a = {1.0, -1.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double expResult = 1;

        double actualResult = b.findTempClosestToValue(0);

        assertEquals(expResult, actualResult, 0.001);
    }

    @Test
    public void testClosestToValue3() {
        double[] a = {-1.0, 1.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double expResult = 1;

        double actualResult = b.findTempClosestToValue(0);

        assertEquals(expResult, actualResult, 0.001);
    }

    @Test
    public void testFindTempsLessThen() {
        double[] a = {-1, 0, 1, 2, 3, 4, 5, 6, 7};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double[] expResult = {-1, 0, 1, 2, 3};

        double[] actualResult = b.findTempsLessThen(4);

        assertEquals(expResult.length, actualResult.length);
        if (expResult.length == actualResult.length)
            for (int i = 0; i < expResult.length; i++) {
                assertEquals(expResult[i], actualResult[i], 0.0001);
            }
    }

    @Test
    public void testFindTempsLessThenEmptyResult() {
        double[] a = {1, 2, 3, 4, 5, 6};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double[] expResult = {};

        double[] actualResult = b.findTempsLessThen(1);

        assertEquals(expResult.length, actualResult.length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThenEmpty() {
        double[] a = {};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);

        // expect exception here
        b.findTempsLessThen(-10);
    }

    @Test
    public void testFindTempsGreaterThen() {
        double[] a = {-1, 0, 1, 2, 3, 4, 5, 6, 7};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double[] expResult = {3, 4, 5, 6, 7};

        double[] actualResult = b.findTempsGreaterThen(2);

        assertEquals(expResult.length, actualResult.length);
        if (expResult.length == actualResult.length)
            for (int i = 0; i < expResult.length; i++) {
                assertEquals(expResult[i], actualResult[i], 0.0001);
            }
    }

    @Test
    public void testFindTempsGreaterThenEmptyResult() {
        double[] a = {1, 2, 3, 4, 5, 6};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        double[] expResult = {};

        double[] actualResult = b.findTempsGreaterThen(6);

        assertEquals(expResult.length, actualResult.length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThenEmpty() {
        double[] a = {};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);

        // expect exception here
        b.findTempsGreaterThen(-10);
    }

    @Test
    public void testSummaryStatistics() {
        double[] a = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        TempSummaryStatistics expResult = new TempSummaryStatistics(1, 3.7416, -5, 5);

        TempSummaryStatistics actualResult = b.summaryStatistics();

        assertEquals(expResult.getDevTemp(), actualResult.getDevTemp(), 0.0001);
        assertEquals(expResult.getAvgTemp(), actualResult.getAvgTemp(), 0.0001);
        assertEquals(expResult.getMaxTemp(), actualResult.getMaxTemp(), 0.0001);
        assertEquals(expResult.getMinTemp(), actualResult.getMinTemp(), 0.0001);
    }

    @Test
    public void testSummaryStatisticsOne() {
        double[] a = {69.0};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        TempSummaryStatistics expResult = new TempSummaryStatistics(69, 0, 69, 69);

        TempSummaryStatistics actualResult = b.summaryStatistics();

        assertEquals(expResult.getDevTemp(), actualResult.getDevTemp(), 0.0001);
        assertEquals(expResult.getAvgTemp(), actualResult.getAvgTemp(), 0.0001);
        assertEquals(expResult.getMaxTemp(), actualResult.getMaxTemp(), 0.0001);
        assertEquals(expResult.getMinTemp(), actualResult.getMinTemp(), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsEmpty() {
        double[] a = {};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        TempSummaryStatistics expResult = new TempSummaryStatistics(1, 3.7416, -5, 5);

        TempSummaryStatistics actualResult = b.summaryStatistics();
    }

    @Test
    public void testAddTemps() {
        double[] a = {-1, 0, 1, 2, 3, 4, 5, 6, 7};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        int expResult = 12;

        int actualResult = b.addTemps(new double[]{1, 2, 3});

        assertEquals(expResult, actualResult);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddTempsInvalidData() {
        double[] a = {-1, 0, 1, 2, 3, 4, 5, 6, 7};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        int expResult = 18;

        int actualResult = b.addTemps(new double[]{1, 2, -300});

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testAddTemps2() {
        double[] a = {-1, 0, 1, 2, 3, 4, 5, 6, 7};
        TemperatureSeriesAnalysis b = new TemperatureSeriesAnalysis(a);
        int expResult = 29;

        int actualResult = b.addTemps(new double[]{1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});

        assertEquals(expResult, actualResult);
    }

}


