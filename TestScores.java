import java.util.Random;
import java.util.Scanner;

public class TestScores {
    static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {

        Random rand = new Random();

        final int size = rand.nextInt(3, 11);
        int[] testScores = new int[size];
        char[] letterGrades = new char[size];

        System.out.println("Enter your " + size + " test scores:");

        for(int i = 0; i < testScores.length; i++) {
            System.out.println("Enter test " + (i + 1) + " score:");
            testScores[i] = scnr.nextInt();
        }

        for(int i = 0; i < testScores.length; i++) {
            letterGrades[i] = getLetterGrade(testScores[i]);
        }

        printGrades(testScores, letterGrades);
        printHighestScore(testScores);
        printLowestScore(testScores);
        printAverageScore(testScores);

        scnr.close();
    }

    public static char getLetterGrade(int testScores) {
        char grade = 'A';
        if(testScores >= 90) {
            grade = 'A';
        }
        else if(testScores >= 80) {
            grade = 'B';
        }
        else if(testScores >= 70) {
            grade = 'C';
        }
        else if(testScores >= 60) {
            grade = 'D';
        }
        else {
            grade = 'F';
        }
        return grade;
    }

    public static void printGrades(int[] testScores, char[] letterGrades) {
        System.out.printf("\n%-20s  %10s", "Score", "Grade\n");
        for(int i = 0; i < testScores.length; i++) {
            System.out.printf("%-20s  %10s\n", testScores[i], letterGrades[i]);
        }
    }

    public static void printHighestScore(int[] testScores) {
        int max = 0;
        for(int i = 0; i < testScores.length; i++) {
            if(testScores[i] > max) {
                max = testScores[i];
            }
        }
        System.out.println("The highest score is " + max);
    }

    public static void printLowestScore(int[] testScores) {
        int low = 100;
        for(int i = 0; i < testScores.length; i++) {
            if(testScores[i] < low) {
                low = testScores[i];
            }
        }
        System.out.println("The lowest score is " + low);
    }

    public static void printAverageScore(int[] testScores) {
        double average = 0.0;
        int count = 0;
        for(int i = 0; i < testScores.length; i++) {
            average = average + testScores[i];
            count++;
        }
        average = average / count;
        System.out.printf("The average score is %.1f", average);
    }
}
