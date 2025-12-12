import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.*;
import java.time.LocalTime;

public class MiniCrawler {

    public static String fetchPage(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        byte[] data = url.openStream().readAllBytes();
        return new String(data, StandardCharsets.UTF_8);
    }

    public static ArrayList<String> extractLinks(String html) {
        ArrayList<String> links = new ArrayList<>();
        Pattern pattern = Pattern.compile("href=\"(http[s]?://[^\"]+)\"");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            links.add(matcher.group(1));
        }
        return links;
    }

    public static int countWords(String html) {
        String text = html.replaceAll("<[^>]*>", " ").replaceAll("&[^;]+;", " ");
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        try {
            String startUrl = "https://www.cia.gov/the-world-factbook/countries/united-states/";
            ArrayList<String> toVisit = new ArrayList<>();
            ArrayList<String> visited = new ArrayList<>();
            int totalWords = 0;

            System.out.println("Crawler started at: " + LocalTime.now());

            toVisit.add(startUrl);
            int maxPages = 6;

            while (!toVisit.isEmpty() && visited.size() < maxPages) {
                String url = toVisit.remove(0);
                if (visited.contains(url)) continue;

                System.out.println("\nCrawling: " + url);
                String html = fetchPage(url);
                visited.add(url);

                int pageWords = countWords(html);
                totalWords += pageWords;

                System.out.printf("Words on this page: %,d\n", pageWords);

                ArrayList<String> links = extractLinks(html);
                for (String link : links) {
                    if (!visited.contains(link) && !toVisit.contains(link)) {
                        toVisit.add(link);
                    }
                }
            }

            System.out.println("\nCrawler finished at: " + LocalTime.now());
            System.out.printf("Total pages visited: %d\n", visited.size());
            System.out.printf("Total words across all pages: %,d\n", totalWords);

            System.out.println("\nVisited Pages:");
            for (String v : visited) 
            {
                System.out.println("→ " + v);
            }

        } catch (Exception e) {
            System.out.println("Abra ka Dabra: " + e.getMessage());
        }
    }
}
