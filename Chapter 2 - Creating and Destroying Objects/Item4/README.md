
Hello, in this article, we will consider item 4 of Creating and Destroying Objects, which is the first unit of Effective Java. 

Although the name of the item in the book is "Enforce noninstantiability with a private constructor", I preferred to use it only as a Private Constructor. Don't you think it's weird too? We are creating a class and you exclude this class by setting the method you can create to private. Honestly, that's what came to mind when I first read the title. After reading it, I realized why. Let me share with you examples right away.

In some cases I may want to keep only the values of certain variables or the actions of static functions. In such cases, of course, it is important for me that these values are not changed by someone else. In fact, this is exactly the main reason, even let me tell you, regardless of what level you are developing, you have used this structure before.

Are these two classes _java.lang.Maths_ or _java.util.Arrays_ familiar to you? Do you remember ever using _new Maths()_ or _new Arrays()_? No, right? When you go inside the class and examine it, you can easily see the private constructor (_private Math() {} | private Arrays() {}_). Why are they like this? Because exactly the situation I just described applies here. In order to use it in mathematical operations, for example, the number _e_ and the number _PI_ need to be kept somewhere. These are the variables I mentioned and want to be constant, of course, functions such as _floor_, _log_, _cos_ are also kept in this class.

I would like to mention a small but important case. As you can see, our variables are defined as static _(public static final double PI = 3.14...; | public static final double E = 2.71...;)_. Unless you use it, having classes with private constructors in the code will cause unnecessary memory usage.

```
// Noninstantiable utility class
public class UtilityClass
{
    // Suppress default constructor for noninstantiability  
    private UtilityClass()
    {
        throw new AssertionError();
    }
}
```
_throw new AssertionError();_ is just a precaution to prevent it from being accidentally called within the class. We have already ensured that this constructor cannot be accessed from anywhere else with private.