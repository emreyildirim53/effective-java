package Item5;

import java.util.Collections;
import java.util.List;

// Inappropriate use of static utility - inflexible & untestable!
class SpellCheckerNoninstantiable {

    private static final Lexicon dictionary = null;

    private SpellCheckerNoninstantiable() {} // Noninstantiable

    public static boolean isValid(String word) {  return false;}

    public static List<String> suggestions(String typo) {  return Collections.emptyList();    }
    
}
