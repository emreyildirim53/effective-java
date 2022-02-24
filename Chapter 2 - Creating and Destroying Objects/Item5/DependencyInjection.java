package Item5;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DependencyInjection
{
    private final Lexicon dictionary;
    public DependencyInjection(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) { return true; }
    public List<String> suggestions(String typo) {  return Collections.emptyList();}
}

class SpellChecker
{
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary)
    {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) { return false; }

    public List<String> suggestions(String typo) { return Collections.emptyList();}
}