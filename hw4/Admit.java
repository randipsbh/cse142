import java.util.*;

public class Admit {
    public static void main(String[] args) {
        intro();
        Scanner scan = new Scanner(System.in);
        double s1 = getOverallScore(scan, 1);
        double s2 = getOverallScore(scan, 2);
        System.out.printf("First applicant overall score = %.1f\n", s1);
        System.out.printf("Second applicant overall score = %.1f\n", s2);
        System.out.printf("The %s applicant seems to be better\n", (s1 > s2) ? "first" : "second");
    }

    public static double getOverallScore(Scanner scan, int id) {
        // Print header
        System.out.printf("Information for applicant #%d:\n", id);
        // get exam score
        double exam = getExam(scan);
        // get gpa score
        double gpa = getGPA(scan);
        // return overall score
        return exam + gpa;
    }

    public static double getExam(Scanner scan) {
        System.out.print("do you have 1) SAT scores or 2) ACT scores? ");
        int examType = scan.nextInt();
        if (examType == 1) {
            return getSAT(scan);
        } else {
            return getACT(scan);
        }
    }

    public static double getACT(Scanner scan) {
        System.out.print("ACT English? ");
        int english = scan.nextInt();
        System.out.print("ACT math? ");
        int math = scan.nextInt();
        System.out.print("ACT reading? ");
        int reading = scan.nextInt();
        System.out.print("ACT science? ");
        int science = scan.nextInt();
        double examScore = actExamScore(english, math, reading, science);
        System.out.printf("exam score = %.1f\n", examScore);
        return examScore;
    }

    public static double getSAT(Scanner scan) {
        System.out.print("SAT math? ");
        int math = scan.nextInt();
        System.out.print("SAT critical reading? ");
        int reading = scan.nextInt();
        System.out.print("SAT writing? ");
        int writing = scan.nextInt();
        double examScore = satExamScore(math, reading, writing);
        System.out.printf("exam score = %.1f\n", examScore);
        return examScore;
    }

    public static double getGPA(Scanner scan) {
        System.out.print("overall GPA? ");
        double overall = scan.nextDouble();
        System.out.print("max GPA? ");
        double maxGpa = scan.nextDouble();
        System.out.print("Transcript Multiplier? ");
        double tsm = scan.nextDouble();
        double gpaScore = computeGpaScore(overall, maxGpa, tsm);
        System.out.printf("GPA score = %.1f\n\n", gpaScore);
        return gpaScore;
    }

    public static void intro() {
        System.out.println("This program compares two applicants to");
        System.out.println("determine which one seems like the stronger");
        System.out.println("applicant. For each candidate I will need");
        System.out.println("either SAT or ACT scores plus a weighted GPA.");
        System.out.println();
    }

    public static double satExamScore(int math, int reading, int writing) {
        double score = (2 * math + reading + writing) / 32;
        return score;
    }

    public static double actExamScore(int english, int math, int reading, int science) {
        double score = (english + 2 * math + reading + science) / 1.8;
        return score;
    }

    public static double computeGpaScore(double overall, double maxGpa, double tsm) {
        return (overall / maxGpa) * 100 * tsm;
    }
}
