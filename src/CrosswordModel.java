import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrosswordModel {
    static List<String> russianWords = new ArrayList<>();
    static List<String> englishWords = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        russianWords.add("кошка");
        russianWords.add("печь");
        russianWords.add("зерно");
        russianWords.add("мишень");
        russianWords.add("печень");
        russianWords.add("ласка");
        russianWords.add("гармонь");
        russianWords.add("надежда");
        russianWords.add("заноза");
        russianWords.add("полено");
        for (String s : russianWords)
        englishWords.add(Translator.translate("ru", "en", s));
        for (String s: englishWords)
            System.out.println(s);
    }
}
