//This song prints a cumulative song, by using a single 'println' for each unique lyric.

public class Song {
    public static void main(String[] args) {
        verse1();
        System.out.println();
        verse2();
        System.out.println();
        verse3();
        System.out.println();
        verse4();
        System.out.println();
        verse5();
        System.out.println();
        verse6();
        System.out.println();
        verse7();
    }

    public static void verse1() {
        fly();
        lastLine();
    }

    public static void verse2() {
        spider();
        swallowSpider();
        lastLine();
    }

    public static void verse3() {
        bird();
        swallowBird();
        lastLine();
    }

    public static void verse4() {
        cat();
        swallowCat();
        lastLine();
    }

    public static void verse5() {
        dog();
        swallowDog();
        lastLine();
    }

    public static void verse6() {
        snake();
        swallowSnake();
        lastLine();
    }

    public static void verse7() {
        System.out.println("There was an old woman who swallowed a horse,");
        System.out.println("She died of course.");
    }

    public static void fly() {
        System.out.println("There was an old woman who swallowed a fly.");
    }

    public static void spider() {
        System.out.println("There was an old woman who swallowed a spider,");
        System.out.println("That wriggled and iggled and jiggled inside her.");
    }

    public static void bird() {
        System.out.println("There was an old woman who swallowed a bird,");
        System.out.println("How absurd to swallow a bird.");

    }

    public static void cat() {
        System.out.println("There was an old woman who swallowed a cat,");
        System.out.println("Imagine that to swallow a cat.");
    }

    public static void dog() {
        System.out.println("There was an old woman who swallowed a dog,");
        System.out.println("What a hog to swallow a dog.");
    }

    public static void snake() {
        System.out.println("There was an old woman who swallowed a snake,");
        System.out.println("How great to swallow a snake.");
    }

    public static void swallowSpider() {
        System.out.println("She swallowed the spider to catch the fly,");
    }

    public static void swallowBird() {
        System.out.println("She swallowed the bird to catch the spider,");
        swallowSpider();
    }

    public static void swallowCat() {
        System.out.println("She swallowed the cat to catch the bird,");
        swallowBird();

    }

    public static void swallowDog() {
        System.out.println("She swallowed the dog to catch the cat,");
        swallowCat();

    }

    public static void swallowSnake() {
        System.out.println("She swallowed the snake to catch the dog");
        swallowDog();
    }

    public static void lastLine() {
        System.out.println("I don't know why she swallowed that fly,");
        System.out.println("Perhaps she'll die.");
    }
}
