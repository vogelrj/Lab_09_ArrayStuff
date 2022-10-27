import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class ArrayStuff {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random generator = new Random();
        int ARRAY_LENGTH = 100;
        int[] dataPoints = new int[ARRAY_LENGTH];
        double[] dataPointsD = new double[ARRAY_LENGTH];
        int dataSum = 0;
        int dataAve = 0;
        int searchNum = 0;
        int foundCount = 0;
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        double doubleAve = 0;
        for (int e = 0; e < dataPoints.length; e++) {
            dataPoints[e] = generator.nextInt(100) + 1;
        }
        for (int e = 0; e < dataPoints.length; e++) {
            System.out.printf("%1d | ", dataPoints[e]);
        }
        for (int e = 0; e < dataPoints.length; e++) {
            dataSum = dataSum + dataPoints[e];
        }
        dataAve = dataSum / dataPoints.length;
        System.out.println("\n\nThe sum of the numbers in the random array is " + dataSum + " and the average is " + dataAve + ".");
        searchNum = SafeInput.getRangedInt(in, "Enter a value to search and we will see if it is in the random array ", 1, 100);
        System.out.println();
        for (int e = 0; e < dataPoints.length; e++) {
            if (dataPoints[e] == searchNum) {
                foundCount = foundCount + 1;
            }
        }
        if (foundCount == 1) {
            System.out.println("The number " + searchNum + " was found " + foundCount + " time in the random array.");
        } else if (foundCount > 1) {
            System.out.println("The number " + searchNum + " was found " + foundCount + " times in the random array.");
        } else {
            System.out.println("The number " + searchNum + " was not found in the random array.");
        }
        foundCount = 0;
        searchNum = SafeInput.getRangedInt(in, "Enter a value and we will see where it first appears in the random array ", 1, 100);
        System.out.println();
        for (int e = 0; e < dataPoints.length; e++) {
            if (dataPoints[e] == searchNum) {
                foundCount = foundCount + 1;
                System.out.println("The number " + searchNum + " is first found at index " + e);
                break;
            }
        }
        if (foundCount == 0) {
            System.out.println("The number " + searchNum + " is not found in the random array.");
        }
        for (int e = 0; e < dataPoints.length; e++) {
            if (minNum > dataPoints[e]) {
                minNum = dataPoints[e];
            }
            if (maxNum < dataPoints[e]) {
                maxNum = dataPoints[e];
            }
        }
        System.out.println("\nThe minimum value in the random array is " + minNum + " and the maximum value is " + maxNum + ".");
        System.out.println("\nAverage of dataPoints is: " + getAverage(dataPointsD));
        System.out.println("===============Extra Credit===============");
        System.out.println("\nUsing a static method the minimum value is " + min(dataPoints));
        System.out.println("\nUsing a static method the maximum value is " + max(dataPoints));
        System.out.println("\nUsing a static method the number " + searchNum + " was found " + occuranceScan(dataPoints,searchNum) + " times in the array.");
        System.out.println("\nUsing a static method the sum of the array is " + sum(dataPoints));
        System.out.println("\nUsing a static method the array contains the number " + searchNum + ": " + contains(dataPoints, searchNum));

    }

    public static double getAverage(double value[]) {
        Random generator = new Random();
        DecimalFormat df = new DecimalFormat("#.##");
        double doubleAve = 0;
        double doubleSum = 0;
        for (int e = 0; e < value.length; e++) {
            value[e] = generator.nextDouble(20) + 1;
        }
        for (int e = 0; e < value.length; e++) {
            doubleSum = doubleSum + value[e];
        }
        doubleAve = doubleSum / value.length;
        doubleAve = Double.parseDouble(df.format(doubleAve));
        return doubleAve;
    }
//Static Methods - Extra Credit
    public static int min(int values[]) {
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < values.length; i++) {
            if (minNum > values[i]) {
                minNum = values[i];
            }
        }
        return minNum;
    }
    public static int max(int values[]) {
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < values.length; i++) {
            if (maxNum < values[i]) {
                maxNum = values[i];
            }
        }
        return maxNum;
    }
    public static int occuranceScan(int values[], int target){
        int foundCount = 0;
        for (int e = 0; e < values.length; e++) {
            if (values[e] == target) {
                foundCount = foundCount + 1;
            }
        }
        return foundCount;
    }
    public static int sum(int values[]){
        int dataSum = 0;
        for (int e = 0; e < values.length; e++) {
            dataSum = dataSum + values[e];
    }
        return dataSum;
    }
    public static boolean contains(int values[], int target){
        boolean hasNumber = false;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target){
                hasNumber = (!hasNumber);
            }
        }
        return hasNumber;
    }
}
