import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraping {

    public static void main(final String[] args) {
        String pageText = urlToString("http://erdani.com/tdpl/hamlet.txt");
        int count = wordCount(pageText);
        System.out.println("Hamlet word count: " + count);

        System.out.println(oneWordCount("prince", pageText));
    }

    /**
     * Splits (by " ") content string parameter into array of words.
     * Returns length of this array, which is the word count of inputed string.
     *
     * @param content string that we are calculating word count for
     * @return number of words in content string
     */
    public static int wordCount(final String content) {
        String[] contentArr = content.split(" ");
        return contentArr.length;
    }
    /**
     * Splits (by " ") content string parameter into array of words.
     * Loops through array and counts the number of times the keyword appears
     *
     * @param keyword string we are searching for within content string
     * @param content string that we are searching through
     * @return the number of times the keyword string appears in content string
     */
    public static int oneWordCount(final String keyword, final String content) {
        //The following line allows us to ignore punctuation and capitalization
        String[] contentArr = content.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        int count = 0;
        for (int i = 0; i < contentArr.length; i++) {
            if (contentArr[i].equals(keyword)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

}
