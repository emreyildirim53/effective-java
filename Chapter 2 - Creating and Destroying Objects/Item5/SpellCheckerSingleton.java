package Item5;

import java.util.Collections;
import java.util.List;

// Inappropriate use of singleton - inflexible & untestable!**  
public class SpellCheckerSingleton {
    private final Lexicon dictionary = new Lexicon();

    private SpellCheckerSingleton() {}

    public static SpellCheckerSingleton INSTANCE = new SpellCheckerSingleton();
    public boolean isValid(String word) { return true; }
    public List<String> suggestions(String typo) { return Collections.emptyList();
    }
}