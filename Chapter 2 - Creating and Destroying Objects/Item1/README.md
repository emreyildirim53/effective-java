
> medium-to-markdown@0.0.3 convert /Users/emre.yildirim/Desktop/medium-to-desktop/medium-to-markdown
> node index.js "https://medium.com/@53.emreyildirim/static-factory-method-mu-constructor-m%C4%B1-7f00722a7535"

Static Factory Method mu? Constructor mı?
=========================================

[![Emre Yıldırım](https://miro.medium.com/fit/c/96/96/2*JR386aaXHBbRCkoHIr1__Q.png)](https://medium.com/@53.emreyildirim?source=post_page-----7f00722a7535----------------------)[Emre Yıldırım](https://medium.com/@53.emreyildirim?source=post_page-----7f00722a7535----------------------)Follow[Dec 29](https://medium.com/@53.emreyildirim/static-factory-method-mu-constructor-mı-7f00722a7535?source=post_page-----7f00722a7535----------------------) · 3 min read

<img class="cp t u fz ak" src="https://miro.medium.com/max/12000/1\*RSb13ih-eWr9crmpmFKVxw.jpeg" width="6000" height="4000" role="presentation"/>

~ static factory method ~

Selamlar, ülkemizi muasır medeniyetler seviyesine çıkarmak için yine, yeni ve yeniden karşındayım. Bu yazıda kitabımızın ilk bölümü olan **Creating and Destroying Objects (Obje Yaratma ve Yok etme** adımlarından ilki olan **Static factory methods instead of constructors (Yapıcılar Yerine Statik Fabrikalar)** bölümünden bahsedeceğim. Hangi kitap, ne bölümü? Diye soruların varsa şayet, seni [ilk yazıma](https://medium.com/@53.emreyildirim/efektif-bir-java-3d35cbb085c) göz ucuyla bakmaya davet ediyorum.

Nedir bu constructor? ya static factory method? Factory dediğin tasarım modeli olan factory deseni mi? Bu tarz konu içeriğindeki kelimelere anlam yüklemeye dayalı soruların varsa ilk önce bunları cevaplayayım. Öncelikle buradaki statik fabrika ile tasarım deseni olan fabrika metodunun (Factory Pattern) bir alakası yok. Aslında yeri gelmişken fabrika metod desenini de hatırlayalım. Bilgilerimizi tazeleyelim.

> Fabrika Desen **(Factory Pattern)**; aynı abstract sınıf veya interface’den türeyen nesnelerin üretiminden sorumlu yapıdır. Hali hazırda geliştirmiş olduğun uygulama üzerine yeni özellik eklemek istediğinde mevcut yapıyı zora sokmadan kullanabileceğin bir tasarım modelidir.

Peki, güzel. Nedir bu static factory? Burada bahsedeceğim static factory, aslında sen ve benim gibi zamanında programlama işine yeni adım atmış. Bu dönemde de elde ettiği veya zorla dayatıldığı teorik bilgiler içerisinde kaybolmuş yararlı bilgilerden bir tanesi.

Nesneye yönelik programlamaya ilk giriştiğin zamanları hatırla. Sana ilk önce temel yapı taşı olan sınıfı (class) anlattılar. Hani ihtiyacın olan ortak değerleri içine eklediğin. Yaş, en, boy, kilo, renk, hacim gibi betimleyici özellikleri de ekledin çiz, boya, ölç, ara gibi eylemleri de. Bunları tanımlarken getter(), setter() da kullandın, yapıcıları da (constructor). Giriş seviyesinde sana öğretilen bu bilgiler, işler daha karmaşıklaştığında yetmemeye başlıyor. Yetmemeyi geçtim sana engel dahi olabiliyor.

Aslında, ilk olarak burda yazımızın başlığı olan nedenleri sıralamak istiyorum.

_Neden yapıcılar yerine statik fabrikalar? Şöyle ki:_

**Constructor’lar doğrudan sınıfın sahip olduğu ismi alırken, static factory’lerde daha anlamlı isimlendirme ile kodun okunabilirliğini zenginleştirebiliyorsun.**

Constructor ile yaratılmış bir sınıfım olsun:

```
public class Yumurta{  
   public Yumurta(boolean sucuklu){  
      //yumurta yap  
   }  
}// Yumurta sınıfına girmeden 'true' değerinin ne olduğunu anlayamam  
Yumurta yumurta = new Yumurta(true)
```

static factory ile nasıl oluyor görelim.

```
public class Yumurta{  
   public static Yumurta sucukluYumurta(){  
     //sucuklu yumurta yap  
   }  
   public static Yumurta peynirliYumurta(){  
     //peynirli yumurta yap  
   }  
}// Görüldüğü üzere kodu daha iyi okuyorsun. Afiyet olsun.  
Yumurta yumurta = Yumurta.sucukluYumurta()  
Yumurta yumurta = Yumurta.peynirliYumurta()
```

**Constructor’lar ile her defasında yeni sınıf oluşturarak sistemde ağır yüklere yol açabilecekken, static factory yöntemiyle bir sınıf oluşturup bu sınıfı çoklayabilirsin hatta kontrol altında tutabilirsin.** [**Singleton Class**](https://www.geeksforgeeks.org/singleton-class-java/) **üretmek için ideal 😉**

> **EnumSet** public bir constructor kullanmaz bunun yerine statik factory metod ile üretilir. Enum türü 64 veya daha az elemana sahipse RegularEnumSet, 65 veya daha fazla elemana sahipse JumboEnumSet nesnesi dönerek yönetmiş olur.

```
public class Pizza  
{  
    private boolean sliced;  
  
    public Pizza(boolean sliced)  
    {  
        this.sliced = sliced;  
    } @Override  
    public String toString()  
    {  
        return "Pizza{sliced=" + sliced +'}';  
    }  
}public class PizzaFactory  
{  
    private static PizzaFactory _pizzaFactoryInstance_;  
  
    private String pizzaSize;  
    private boolean hasPepperoni;  
    private boolean hasCheese;  
  
    // singleton object control over the instance with static     factory model  
    public static PizzaFactory getInstance(String pizzaSize, boolean hasPepperoni, boolean hasCheese)  
    {  
        PizzaFactory pizzaFactory = new PizzaFactory();  
  
        if (_pizzaFactoryInstance_ != null)  
        {  
            pizzaFactory = _pizzaFactoryInstance_;  
        }  
        else  
        {  
            pizzaFactory.pizzaSize = pizzaSize;  
            pizzaFactory.hasPepperoni = hasPepperoni;  
            pizzaFactory.hasCheese = hasCheese;  
            _pizzaFactoryInstance_ \= pizzaFactory;  
        }  
  
        return pizzaFactory;  
    }  
  
    public static String slicedPizza()  
    {  
        return "Sliced pizza.";  
    }  
  
    public static String unSlicedPizza()  
    {  
        return "Unsliced pizza.";  
    }  
  
    @Override  
    public String toString()  
    {  
        return "PizzaFactory{" +  
                "pizzaSize='" + pizzaSize + '\\'' +  
                ", hasPepperoni=" + hasPepperoni +  
                ", hasCheese=" + hasCheese +  
                '}';  
    }  
}
```

* * *

Unutmadan söyleyeyim. Yazıların içerisinde yer alan kod parçalarını [**github**](https://github.com/emreyildirim53/effective-java)  hesabımdan paylaşıyor olacağım girip inceleyebilir beğenirsen yıldızlandırabilirsin ☺️

Adiós 🙋🏻‍♂️
