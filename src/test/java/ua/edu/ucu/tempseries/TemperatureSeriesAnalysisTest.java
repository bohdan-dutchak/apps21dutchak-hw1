package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Test;

public class TemperatureSeriesAnalysisTest {

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


}


