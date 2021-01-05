import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Personality {
    private static final int FOUR = 4;

    public static void main(String[] args) throws FileNotFoundException {
        intro();
        // store file names in an array: 0 = input file, 1 = output file
        String[] fileNames = getFileNames();
        Scanner input = new Scanner(new File(fileNames[0]));
        PrintStream out = new PrintStream(new File(fileNames[1]));

        String name = "";
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.length() == 70) {
                // store A count and B count in arrays;
                int[] aType = getCount(line, 'a');
                int[] bType = getCount(line, 'b');
                // get array of percentages for B type
                int[] percentagesB = getPercentageB(aType, bType);
                // get and store personality type
                String personality = getPersonality(percentagesB);
                // output to file
                outputToFile(percentagesB, name, personality, out);

            } else {
                // store name
                name = line;
            }
        }
    }

    private static String[] getFileNames() {
        // scanner object to get input and output file names
        String[] fileNames = new String[2];
        Scanner console = new Scanner(System.in);
        System.out.print("input file name? ");
        fileNames[0] = console.next();
        System.out.print("output file name? ");
        fileNames[1] = console.next();
        return fileNames;
    }

    private static int[] getCount(String line, char type) {
        // loop through line, store count of the type in an array
        int[] arr = new int[FOUR];
        for (int i = 0; i < line.length(); i++) {
            char ans = Character.toLowerCase(line.charAt(i));
            if (ans == type) {
                if ((i + 1) % 7 == 1) {
                    arr[0]++;
                }
                if ((i + 1) % 7 == 2 || (i + 1) % 7 == 3) {
                    arr[1]++;
                }
                if ((i + 1) % 7 == 4 || (i + 1) % 7 == 5) {
                    arr[2]++;
                }
                if ((i + 1) % 7 == 0 || (i + 1) % 7 == 6) {
                    arr[3]++;
                }
            }
        }
        return arr;
    }

    private static int[] getPercentageB(int[] aType, int[] bType) {
        // loop through a and b concurrently
        int[] arr = new int[FOUR];
        for (int i = 0; i < FOUR; i++) {
            // store the percentage of b in an array
            arr[i] = (int) Math.round(100 * bType[i] / (aType[i] + bType[i]));
        }
        return arr;
    }

    private static String getPersonality(int[] typeArr) {
        String s = "";
        for (int i = 0; i < FOUR; i++) {
            // case: type B personality traits
            if (typeArr[i] > 50) {
                if (i == 0) {
                    s += "I";
                } else if (i == 1) {
                    s += "N";
                } else if (i == 2) {
                    s += "F";
                } else {
                    s += "P";
                }
                // case: type A personality traits
            } else if (typeArr[i] < 50) {
                if (i == 0) {
                    s += "E";
                } else if (i == 1) {
                    s += "S";
                } else if (i == 2) {
                    s += "T";
                } else {
                    s += "J";
                }
                // percentage is 50
            } else {
                s += "X";
            }
        }
        // return
        return s;
    }

    private static void outputToFile(int[] bPercentages, String name, String personality, PrintStream out)
            throws FileNotFoundException {
        // print output to file
        out.printf("%s: " + Arrays.toString(bPercentages) + " = %s\n", name, personality);
    }

    private static void intro() {
        System.out.println("This program processes a file of answers to the");
        System.out.println("Keirsey Temperament Sorter. It converts the");
        System.out.println("various A and B answers for each person into");
        System.out.println("a sequence of B-percentages and then into a");
        System.out.println("four-letter personality type.");
        System.out.println();
    }
}
