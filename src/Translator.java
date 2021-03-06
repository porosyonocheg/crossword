import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/** Переводит заданные слова с русского языка на английский через Google Translate, используя google script
 * @author Сергей Шершавин*/

public class Translator {

    public static void main(String[] args) throws IOException {
        String text = "Привет, Мир!";
        System.out.println("Translated text: " + translate("ru", "en", text));
    }

    static String translate(String langFrom, String langTo, String text) throws IOException {
        String urlStr = "https://script.google.com/macros/s/AKfycbxIywxT-dWmolSllyTj3-cjw_P1KDmyQd93po8VBE09fzQNBKfpuHHd/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
