import java.io.*;
import java.util.*;
import java.awt.*;

public class Names {
    private static final int DECADES = 14;
    private static final int STARTYEAR = 1880;
    private static final int WIDTH = 70;

    // Give an intro
    // ask for user
    // ask for gender
    // if found draw panel
    // if not print message
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("names.txt"));
        intro();
        String line = getInfo(scan);
        if (line == "") {
            notFound();
        } else {
            DrawingPanel panel = new DrawingPanel(WIDTH * DECADES, 550);
            Graphics g = panel.getGraphics();
            drawPanel(g);
            plotLine(g, line);
        }
    }

    private static void intro() {
        System.out.printf("This program allows you to search through the\n");
        System.out.printf("data from the Social Security Administration\n");
        System.out.printf("to see how popular a particular name has been\n");
        System.out.printf("since %d.\n\n", STARTYEAR);
    }

    private static void notFound() {
        System.out.println("name/sex combination not found");
    }

    private static String getInfo(Scanner input) throws FileNotFoundException {
        // get name and gender from console, store in variable
        Scanner console = new Scanner(System.in);
        System.out.print("name? ");
        String name = console.next();
        System.out.print("sex (M or F)? ");
        String sex = console.next();
        String userNameGender = name + " " + sex;

        // loop over the file line by line
        while (input.hasNextLine()) {
            // scan each line for name and gender match
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            String nameGender = lineScan.next() + " " + lineScan.next();
            if (nameGender.toLowerCase().equals(userNameGender.toLowerCase())) {
                return line;
            }
        }
        return "";

    }

    private static void drawPanel(Graphics g) {
        // draw the panel, black lines and decades labeled at the bottom
        g.setColor(Color.BLACK);
        g.drawLine(0, 25, WIDTH * DECADES, 25);
        g.drawLine(0, 550 - 25, WIDTH * DECADES, 550 - 25);
        int year = STARTYEAR;
        for (int i = 0; i < DECADES; i++) {
            g.drawLine(i * WIDTH, 0, i * WIDTH, 550);
            g.drawString(String.valueOf(year), i * WIDTH, 550);
            year += 10;

        }
    }

    private static void plotLine(Graphics g, String line) {
        // scanner object to process line
        Scanner lineScan = new Scanner(line);
        String nameGender = lineScan.next() + " " + lineScan.next().toUpperCase();
        g.setColor(Color.RED);

        // draw line and display rank for that decade
        int y = 0;
        int yPrev = 0;
        for (int i = 0; i < DECADES; i++) {
            int rank = lineScan.nextInt();
            String displayRank = nameGender + " " + rank;
            yPrev = y;
            y = (rank != 0) ? rank / 2 + 24 : 525;

            g.drawString(displayRank, i * WIDTH, y);
            g.drawLine((i * WIDTH) - WIDTH, yPrev, i * WIDTH, y);
        }
    }
}
