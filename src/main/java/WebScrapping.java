import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScrapping {

    public static void main(String[] args) {
        String pageText = urlToString("http://erdani.com/tdpl/hamlet.txt");
        int count = wordCount(pageText);
        System.out.println("Hamlet word count: " + count);

        System.out.println(oneWordCount("prince", pageText));
    }

    /**
     * Splits string parameter into array of words.
     * Returns length of this array, which is word count of inputed string.
     *
     * @param content url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static int wordCount(final String content) {
        String[] contentArr = content.split(" ");
        return contentArr.length;
    }
    /**
     *
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static int oneWordCount(final String keyword, final String content) {
        String[] contentArr = content.split(" ");
        int count = 0;
        for(int i = 0; i < contentArr.length; i++) {
            if(contentArr[i].equalsIgnoreCase(keyword)) {
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
