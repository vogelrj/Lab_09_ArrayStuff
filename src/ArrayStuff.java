import java.util.Random;
import java.util.Scanner;

public class ArrayStuff {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random generator = new Random();
        int ARRAY_LENGTH = 100;
        int[] dataPoints = new int[ARRAY_LENGTH];
        int dataSum = 0;
        int dataAve = 0;
        int searchNum = 0;
        int foundCount = 0;
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        double doubleAve = 0;
        for (int e = 0; e < dataPoints.length; e++){
            dataPoints[e] = generator.nextInt(100) + 1;
        }
        for (int e = 0; e < dataPoints.length; e++){
            System.out.printf("%1d | ", dataPoints[e]);
        }
        for (int e = 0; e<dataPoints.length;e++){
            dataSum = dataSum + dataPoints[e];
        }
        dataAve = dataSum / dataPoints.length;
        System.out.println("\nThe sum of the numbers in the random array is " + dataSum + " and the average is " + dataAve + ".");
        searchNum = SafeInput.getRangedInt(in,"Enter a value to search and we will see if it is in the random array ",1,100);
        System.out.println();
        for (int e = 0; e < dataPoints.length; e++){
            if(dataPoints[e] == searchNum){
                foundCount = foundCount + 1;
            }
        }
        if (foundCount == 1 ){
            System.out.println("The number " + searchNum + " was found " + foundCount + " time in the random array.");
        }
        else if (foundCount >1) {
            System.out.println("The number " + searchNum + " was found " + foundCount + " times in the random array.");
        }
        else{
            System.out.println("The number " + searchNum + " was not found in the random array.");
        }
        foundCount =0;
        searchNum = SafeInput.getRangedInt(in,"Enter a value and we will see where it first appears in the random array ",1,100);
        System.out.println();
        for (int e = 0; e < dataPoints.length; e++){
            if (dataPoints[e] == searchNum) {
                foundCount = foundCount + 1;
                System.out.println("The number " + searchNum + " is first found at index " + e);
                break;
            }
        }
        if (foundCount == 0){
            System.out.println("the number " + searchNum + " is not found in the random array.");
        }
        for (int e = 1; e < dataPoints.length; e++){
            if (minNum > dataPoints[e]){
                minNum = dataPoints[e];
            }
            if (maxNum < dataPoints[e]){
                maxNum = dataPoints[e];
            }
        }
        System.out.println("\nThe minimum value in the random array is " + minNum + " and the maximum value is " + maxNum + ".");
        System.out.println("\nAverage of dataPoints is: " + getAverage(dataPoints));
    }
    public static double getAverage(int value[]) {
        Random generator = new Random();
        int ARRAY_LENGTH = 20;
        double[] doubleArray = new double[ARRAY_LENGTH];
        double doubleAve = 0;
        double doubleSum = 0;
        for (int e = 0; e < doubleArray.length; e++){
            doubleArray[e] = generator.nextDouble(20) + 1;
        }
        for (int e = 0; e<doubleArray.length;e++){
            doubleSum = doubleSum + doubleArray[e];
        }
        doubleAve = doubleSum / doubleArray.length;
        return doubleAve;
    }

}
