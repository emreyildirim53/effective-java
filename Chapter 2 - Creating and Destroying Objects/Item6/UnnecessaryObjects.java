package Item6;

import java.util.regex.Pattern;

public class UnnecessaryObjects
{
    String str1 = new String("Emre Yıldırım");  // DON'T DO THIS!
    
    String str2 = "Emre Yıldırım"; // DO THIS!

    public static void main(String[] args)
    {
        Boolean aTrue = Boolean.valueOf("true");    // DON'T DO THIS!
        Boolean aFalse = new Boolean("false") ;  // DO THIS!
    }

    // Performance can be greatly improved!
    static boolean isRomanNumeral(String s)
    {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    // Reusing expensive object for improved performance
    public static class RomanNumerals
    {
        private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

        static boolean isRomanNumeral(String s)
        {
            return ROMAN.matcher(s).matches();
        }
    }

    // Hideously slow! Can you spot the object creation?
    private static long sum()
    {
        Long sum = 0L;  // Use long instead of long
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
        {
            sum += i;
        }
        
        return sum;
    }
}
