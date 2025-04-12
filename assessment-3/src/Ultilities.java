
// using from assessment 2
public class Utilities {
    public Utilities() {
    }

    public static String truncateString(String stringToTruncate, int length) {
        return stringToTruncate.length() <= length ? stringToTruncate : stringToTruncate.substring(0, length);
    }

    public static String printStars(int num) {
        String theStars = "\n";

        for(int i = 0; i < num; ++i) {
            theStars = theStars + "*";
        }

        return theStars;
    }
}
