
import java.util.Scanner;

/**
 * Created by nickk on 4/18/2017.
 */
class BaseballStats {
    public static void main(String[] args) {
        System.out.println("Welcome to the Batting Average Calculator!");
        Scanner scan = new Scanner(System.in);
        boolean player = true;

        while (player) {

            System.out.println("How many at-bats did you have? ");
            int userAtBat = scan.nextInt();
            int[] arr1 = new int[userAtBat];
            validateInput(arr1, scan);

            battingAverage(arr1);  //batting average
            System.out.println();
            slugPercentage(arr1);  //slugging percentage
            System.out.println();

            scan.nextLine();
            boolean validateInput = true;
            while (validateInput) {
                System.out.println("Another batter? (y/n): ");
                String playBall = scan.nextLine();
                if (playBall.equalsIgnoreCase("n")) {
                    System.out.println("Goodbye!");
                    player = false;
                } else if (playBall.equalsIgnoreCase("y")) {
                    player = true;
                } else if (playBall.equalsIgnoreCase("no") || playBall.equalsIgnoreCase("yes")) {
                    System.out.println("Invalid input. Please enter only 'y' or 'n'.");
                    player = false;
                }
            }
        }
    }



    public static void validateInput(int[] arr1, Scanner scan) {
        for (int i = 0; i < arr1.length; i++) {
            boolean correct = true;
            while (correct) {
                System.out.println("Result for at-bat " + i + ": ");
                int baseEarned = scan.nextInt();
                if (baseEarned >= 0 && baseEarned <= 4) {
                    arr1[i] = baseEarned;
                    correct = false;
                } else {
                    System.out.println("Invalid input. Please enter number between 0 and 4.");
                    correct = true;
                }
            }
        }
    }

    //"%.3f" prints 3 decimals
    public static void battingAverage(int[] arr1) {
        double batBase = 0.0;
        double batAvg = 0.0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > 0) {
                batBase = batBase + 1;
                batAvg = batBase / arr1.length;
            }
        }
        System.out.printf("Batting average: " + "%.3f", batAvg);
    }

    public static void slugPercentage(int[] arr1) {
        double totalBases = 0.0;
        double percentage = 0.0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > 0) {
                totalBases = totalBases + arr1[i];
                percentage = totalBases / arr1.length;
            }
        }
        System.out.printf("Slugging Percentage: " + "%.3f", percentage);
    }

}
