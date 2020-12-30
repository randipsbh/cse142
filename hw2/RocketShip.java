public class RocketShip {
    private static final int SIZE = 5;
    
    public static void main(String[] args) {
        top();
        separator();
        bodyTop();
        separator();
        bodyBottom();
        separator();
        top(); // base
    }

    private static void top() {
        int height = 2*SIZE - 1;
        for (int i = 0; i < height; i++) {
            int spaces = height - i;
            int slashes = i + 1;
            int asterisks = 2;
            repeat(" ", spaces);
            repeat("/", slashes);
            repeat("*", asterisks);
            repeat("\\", slashes);
            System.out.println();
        }
    }

    private static void bodyTop() {
        diamondTop();
        diamondBottom();
    }

    private static void bodyBottom() {
        diamondBottom();
        diamondTop();
    }

    private static void diamondTop() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("|");
            int dots = SIZE - i - 1;
            int hats = i + 1;
            repeat(".", dots);
            repeat("/\\", hats);
            repeat(".", 2 * dots);
            repeat("/\\", hats);
            repeat(".", dots);
            System.out.println("|");
        }
    }

    private static void diamondBottom() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("|");
            int dots = i;
            int vees = SIZE - i;
            repeat(".", dots);
            repeat("\\/", vees);
            repeat(".", 2 * dots);
            repeat("\\/", vees);
            repeat(".", dots);
            System.out.println("|");
        }
    }

    private static void separator() {
        System.out.print("+");
        repeat("=*", 2 * SIZE);
        System.out.println("+");
    }

    private static void repeat(String s, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(s);
        }
    }
}
