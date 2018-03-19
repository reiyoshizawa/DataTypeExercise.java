package DataTypeExercises;

import java.util.Scanner;
//import java.math.BigDecimal;

/**
 * @author Rei Yoshizawa on 2018-03-16
 */
public class DataTypeExercise {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Ex 1
        System.out.println("Input a degree in Fahrenheit: ");
        String fahr = scan.nextLine();
        String result1 = fahrenheitToCelsius(Integer.valueOf(fahr));
        System.out.println(result1);

        // Ex 2
        System.out.println("Input a value for inch: ");
        String inches = scan.nextLine();
        String result2 = inchToMeter(Integer.valueOf(inches)); // Integer.valueOf(String) -> int
        System.out.println(result2);

        // Ex 3
        System.out.println("Input an integer between 0 and 1000: ");
        String digit = scan.nextLine();
        String result3 = allDigits(Integer.valueOf(digit));
        System.out.println(result3);

        // Ex 4
        System.out.println("Input the number of minutes: ");
        String numMinutes = scan.nextLine();
        String result4 = minutesToNumberOfYearsAndDays(Integer.valueOf(numMinutes)); // Integer.valueOf(String) -> int
        System.out.println(result4);

        // Ex 5
        System.out.println("Input weight in kg: ");
        String weight = scan.nextLine();
        System.out.println("Input height in meters: ");
        String height = scan.nextLine();
        String result5 = bmiCalculate(Integer.parseInt(weight), Double.parseDouble(height));
//        BigDecimal bdNum1 = new BigDecimal(result5);
//        BigDecimal result5 = bdNum1.setScale(2,BigDecimal.ROUND_UP);
        System.out.println(result5);

        // Ex 6
        System.out.println("Input distance in meters: ");
        String meters = scan.nextLine();
        System.out.println("Input hour ");
        String hour = scan.nextLine();
        System.out.println("Input minutes: ");
        String minutes = scan.nextLine();
        System.out.println("Input seconds:");
        String seconds = scan.nextLine();
        String result6 = displaySpeed(Integer.parseInt(meters),Integer.parseInt(hour),
                Integer.parseInt(minutes), Integer.parseInt(seconds));
        System.out.println(result6);

        // Ex 7
        System.out.println("Input the value: ");
        String num = scan.nextLine();
        String result7 = squareCubeFourthPower(Integer.valueOf(num)); // Integer.valueOf(String) -> int
        System.out.println(result7);

        // Ex 8
        System.out.println("Input first integer: ");
        String first = scan.nextLine();
        System.out.println("Input second integer: ");
        String second = scan.nextLine();
        String result8 = multipleNumber(Integer.valueOf(first), Integer.valueOf(second));
        System.out.println(result8);
    }

    /**
     * Ex 1
     * Returns a formatted answer that converts fahrenheit into celsius
     *
     * @param fahrenheit Fahrenheit in integer.
     * @return formatted answer (ex. 212.0 degree Fahrenheit is equal to 100.0 in Celsius)
     */
    public static String fahrenheitToCelsius(int fahrenheit) {
        double celsius = (fahrenheit - 32) / 1.8;
        return fahrenheit + " degree Fahrenheit is equal to " +  celsius + " in Celsius";
    }

    /**
     * Ex 2
     * Returns a formatted answer that converts number of inches into meters
     *
     * @param inches integer
     * @return formatted answer (ex. 1000.0 inch is 25.4 meters)
     */
    public static String inchToMeter(int inches) {
        double meters = inches *  0.0254;
        return inches + " inch is " + meters + " meters";
    }

    /**
     * Ex 3
     * Returns the numbers that add all the digits of the parameter
     *
     * @param digit integer (0 - 1000)
     * @return formatted answer (ex. The sum of all digits in 565 is 16)
     */
    public static String allDigits(int digit) {
        String strDigits = String.valueOf(digit);
        char[] arrayDigits = new char[strDigits.length()];
        int sumDigits = 0;
        for ( int i = 0; i < strDigits.length(); i++ ) {
            arrayDigits[i] = strDigits.charAt(i);
            sumDigits += Character.getNumericValue(arrayDigits[i]);
        }
        return "The sum of all digits in " + digit + " is " + sumDigits;
    }

    /**
     * Ex 4
     * Returns an answer that converts minutes into a number of years and days
     *
     * @param numMinutes the number of minutes
     * @return formatted answer (ex. 3456789 minutes is approximately 6 years and 210 days)
     */
    public static String minutesToNumberOfYearsAndDays(int numMinutes) {
        // 1 day = 60 * 12 = 1440
        int yearMinutes = 525600; // 1440 * 365
        int year = numMinutes / yearMinutes;
        int days = numMinutes % yearMinutes / 1440;
        return numMinutes + " minutes is approximately " + year + " years and " + days + " days";
    }

    /**
     * Ex 5
     * Returns body mass index (BMI)
     *
     * @param weight kg int
     * @param height meters double
     * @return formatted answer (ex. Body Mass Index is 22.857)
     */
    public static String bmiCalculate(int weight, double height) {
        return "Body Mass Index is " + weight / (height * height);
    }

    /**
     * Ex 6
     * Returns the speed, in meters per second, kilometers per hour and miles per hour
     *
     * @param meters double
     * @param hour double
     * @param minutes double
     * @param seconds double
     * @return formatted answer (ex. Your speed in meters/second is 0.11691531
                                     Your speed in km/h is 0.42089513
                                     Your speed in miles/h is 0.26158804)
     */
    public static String displaySpeed(double meters, double hour, double minutes, double seconds) {
        // hour 5 = 60 * 60 * 5
        // minutes 56 = 60 * 56
        // seconds 23 = 23
        double hourToSeconds = 60 * 60 * hour;
        double minutesToSeconds = 60 * minutes;
        double totalSeconds = hourToSeconds + minutesToSeconds + seconds;
        double metersToKm = meters / 1000;
        double metersToMiles = meters / 1609;

        double metersSecond = meters / totalSeconds;
        double kmHour = metersToKm / hour;
        double milesHour = metersToMiles / hour;

        return "Your speed in meters/second is " + metersSecond + "\r\n"
                + "Your speed in km/h is " + kmHour + "\r\n"
                + "Your speed in miles/h is " + milesHour;
    }

    /**
     * Ex 7
     * Returns the number of square, cube, forth power
     *
     * @param num integer
     * @return formatted answer (ex. Square: 25
                                     Cube: 125
                                     Fourth power: 625)
     */
    public static String squareCubeFourthPower(int num) {
        int square = num * 5;
        int cube = square * 5;
        int fourthPower = cube * 5;
        return "Square: " + square + "\r\n"
        + "Cube: " + cube + "\r\n"
        + "Fourth power: " + fourthPower;
    }

    /**
     * Ex 8
     * set two parameters and return sum, difference, product,
     * average, distance, max, min of two numbers for parameters
     *
     * @param first integer
     * @param second integer
     * @return formatted answer (ex. Sum of two integers: 30
                                     Difference of two integers: 20
                                     Product of two integers: 125
                                     Average of two integers: 15.00
                                     Distance of two integers: 20
                                     Max integer: 25
                                     Min integer: 5)
     */
    public static String multipleNumber(int first, int second) {
        int sum = first + second;
        int diff = first - second;
        int product = first * second;
        double average = (first + second) / 2;
        int distance = Math.abs(first - second);
        int max = Math.max(first, second);
        int min = Math.min(first, second);
        return "Sum of two integers: " + sum + "\r\n"
        + "Difference of two integers: " + diff + "\r\n"
        + "Product of two integers: " + product + "\r\n"
        + "Average of two integers: " + average + "\r\n"
        + "Distance of two integers: " + distance + "\r\n"
        + "Max integer: " + max + "\r\n"
        + "Min integer " + min;
    }

}
