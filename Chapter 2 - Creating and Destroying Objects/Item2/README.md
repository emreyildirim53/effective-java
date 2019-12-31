
Çok Parametreli Constructor Yönetimi
====================================

Hellöööğğğ… 😉 Bol sayıda özelliği bulunan sınıfların nasıl yaratılacağı konusunda bir fikrin var mı? Mesela bir obje düşünelim ki en basitinden 10–15 parametreli olsun. 😉 Ne yaparsın? Nasıl inşa edersin?

<img class="cp t u gm ak" src="https://miro.medium.com/max/11296/1*i0G9rL35VZ-FCy2EZH0jaw.jpeg" width="5648" height="3917" role="presentation"/>

Düz mantık düşünelim. Her parametreyi kapsayacak şekilde bir constructor yaratırım şelale gibi her birini birbirine katmanlı bir şekilde bağlarım. Örneğin;

```
public class Computer  
{  
    private final String brand;  
    private final ComputerType computerType;  
    private final String OS;  
    private final String brandMotherboard;  
    private final String brandCPU;  
    private final String familyCPU;  
    private final float speedCPU;  
    private final DiskType diskTypes;  
    private final int capacityDisk;  
    private final int capacityRAM;  
    private final int capacityDisplayCard;  
    private final int capacityBattery;  
    private final float screenInch;  
    private final String resolution;  
    private final KeyboardType typeKeyboard;  
    private final boolean hasDiskDriver;  
    private final boolean hasWebcam;  
    private final boolean hasSpeaker;  
    private final boolean hasTrackpad;  
    private final boolean hasPrinter;  
...
```

elimde bir Computer sınıfı olsun ve gerekli gereksiz özellikler barındırsın. Bu özelliklerle birlikte istenilen herhangi bir Computer meydana getirebilmeliyim. Bu da ancak her parametreyle yaratılabilecek constructor ile sağlanabilir. Şöyle ki:

```
public Computer(String brand)  
{  
    this(brand, null);  
}public Computer(String brand, ComputerType computerType)  
{  
    this(brand, computerType, null);  
}  
  
public Computer(String brand, ComputerType computerType, String OS)  
{  
    this(brand, computerType, OS, null);  
}  
  
public Computer(String brand, ComputerType computerType, String OS, String brandMotherboard)  
{  
    this(brand, computerType, OS, brandMotherboard, brand, null, 0);  
}  
  
public Computer(String brand, ComputerType computerType, String OS, String brandMotherboard,  
                String brandCPU, String familyCPU, float speedCPU)  
{  
    this(brand, computerType, OS, brandMotherboard, brandCPU, familyCPU, speedCPU, null, 0);  
}...  
....  
.....  
......public Computer(String brand, ComputerType computerType, String OS, String brandMotherboard,  
                String brandCPU, String familyCPU, float speedCPU, DiskType diskTypes, int capacityDisk,  
                int capacityRAM, int capacityDisplayCard, int capacityBattery, float screenInch,  
                String resolution, KeyboardType typeKeyboard, boolean hasDiskDriver, boolean hasWebcam,  
                boolean hasSpeaker, boolean hasTrackpad, boolean hasPrinter)  
{  
    this.brand = brand;  
    this.computerType = computerType;  
    this.OS = OS;  
    this.brandMotherboard = brandMotherboard;  
    this.brandCPU = brandCPU;  
    this.familyCPU = familyCPU;  
    this.speedCPU = speedCPU;  
    this.diskTypes = diskTypes;  
    this.capacityDisk = capacityDisk;  
    this.capacityRAM = capacityRAM;  
    this.capacityDisplayCard = capacityDisplayCard;  
    this.capacityBattery = capacityBattery;  
    this.screenInch = screenInch;  
    this.resolution = resolution;  
    this.typeKeyboard = typeKeyboard;  
    this.hasDiskDriver = hasDiskDriver;  
    this.hasWebcam = hasWebcam;  
    this.hasSpeaker = hasSpeaker;  
    this.hasTrackpad = hasTrackpad;  
    this.hasPrinter = hasPrinter;  
}
```

Yukarıda “_şelale şeklinde birbirine katmanlı bağlanan constructor_” desem de literatürde şelaleye benzetmektense açılıp kapatılabilir teleskopa benzetmişler 🤷🏻‍♂️ Detaylı araştırmak isteyenler için: **Telescoping Constructor**

Gel biz hedef olarak kendimize bir bilgisayar belirleyelim ve her yöntemde o bilgisayarı yaratmaya çalışalım.

> **Requirements List**  
> \* Asus  
> \* Laptop  
> \* SSD  
> \* 4GB RAM  
> \* 15"

```
Computer computer = new Computer("ASUS",  
       ComputerType._LAPTOP_, "", "", "", "", 0f, DiskType._SSD_, 0, 4);
```

Gözünü rahatsız eden bir şeyler oldu mu? Benim kanadı mesela 😁 Hangi parametre marka, hangisi RAM kapasitesi, boş veya sıfır olan değerler ne? Okuması ne kadar zor değil mi? Birde arada ihtiyacım olmayan özellikleri de göndermiş oldum. Bunun önüne geçmek istersem ve telescoping constructor’da ısrar ediyorsam. İstediğim parametreleri referans alan constructor’lar oluşturmam gerekir. 20 tane özelliğin kombinasyonunu sen düşün ben düşünemedim. 🤦🏻‍♂️

Bu yöntem ilk aklıma gelen oldu. Minnacık daha düşündüğümde Java Beans yöntemi aklıma geldi. Bi’de onu denemekte fayda var. Computer classımızın parametreleri aynı olsun, ihtiyaç listemdeki özellikte bir bilgisayarı Java Beans ile yaratalım.

```
public void setBrand(String brand)  
{  
    this.brand = brand;  
}  
  
public void setComputerType(ComputerType computerType)  
{  
    this.computerType = computerType;  
}  
  
public void setOS(String OS)  
{  
    this.OS = OS;  
}  
  
...
```

Uzatmayacağım, özetle tüm parametrelerin set metodunu yazmış oldum. Sonrasında İstediğim özelliklerde bir sınıf yarattım ki o da burada 👇🏼

```
Item2.JavaBeans.Computer computer = new Item2.JavaBeans.Computer();  
computer.setBrand("Asus");  
computer.setComputerType(ComputerType._LAPTOP_);  
computer.setDiskTypes(DiskType._SSD_);  
computer.setCapacityRAM(4);  
computer.setScreenInch(15);
```

Daha düzenli, okunabilir ve temiz görünüyor. (Başak burçları bunu beğendi👍🏼)

Peki güvenli mi? Kullanılabilirliği ne alemde? Şöyle söyleyebilirim ki bir öncekiyle kıyaslarsam bu sayıda bir parametre ile (20) ben bu arkadaşı seçerdim. Fakat bu arkadaşın da çoklu satırda değer ataması yaptığı için yönetim zorluğu var. JavaBeans yöntemi kullanarak oluşturulan nesneler değiştirilebilir yani _immutable_ değildir. Büyük bir code base’de akışların birinde objenin tek değeri set edilmiş ve obje değiştirilmiş olabilir. Sonrasında okuyan kişi arasın dursun 😱 Tek satırda tanımlanmayışı paralel programlamada da ciddi ve bulunması-anlamlandırılması zor buglara neden olabiliyor.

eeeee… o olmaz bu olmaz ne yazacak bu millet 🤬 diyorsan eğer sakin, uğraşı diğerlerine göre birazcık fazla olsada çiçek gibi bir yöntem **Builder Pattern** var.

* * *

Mekanın sahibi: **Builder Pattern;**

Yine parametrelerim aynı birde ekstradan **Builder** adlı bir classım var. Bu class içerisinde zorunlu ve opsiyonel olan parametreleri belirliyorum. Bu parametreler asıl classımdakilerle aynı bu yüzden iki tarafı sürekli eş tutmam gerekiyor buda biraz👌🏼 uğraştırıyor.

```
public static class Builder {  
      
    private final String brand;                 #required  
    private final ComputerType computerType;    #required  
  
    private String OS                   = "";  
    private String brandMotherboard     = "";  
    private String brandCPU             = "";  
    private String familyCPU            = "";  
    private float speedCPU              = 0f;  
    ...  
      
    public Builder(String brand, ComputerType computerType) {  
        this.brand        = brand;  
        this.computerType = computerType;  
    }  
      
    public Builder brandMotherboard(String val)  
    {  
        brandMotherboard = val;  
        return this;   
    }  
    public Builder brandCPU(String val)  
    {  
        brandCPU = val;  
        return this;  
    } ...  
    ...  
    ... public Computer build()  
    {  
        return new Computer(this);  
    }  
}
```

Yaratmış olduğum bu Builder Class’ı Computer Class’ıma bağlıyorum.

```
public class Computer   
{  
    private final String brand;  
    private final ComputerType computerType;  
    private final String OS;  
    ... public Computer(Builder builder)  
    {  
        brand = builder.brand;  
        computerType = builder.computerType;  
        OS = builder.OS;  
        brandMotherboard = builder.brandMotherboard;  
        brandCPU = builder.brandCPU;  
        ...  
    }  
}
```

Artık Computer classımı builder ile oluşturabilirim.

```
Computer computer =new Computer.Builder("Asus", ComputerType._LAPTOP_)  
.diskTypes(DiskType._SSD_).capacityRAM(4).screenInch(15).build();
```

Zorunlu parametreleri builder constructor’la, opsiyonel parametreleri de setter metodlarla ekleyip sonrasında build() ediyorum ve istediğim parametrelere sahip okunabilir, düzenli, temiz , tek seferde üretilmiş objeyi elde etmiş oluyorum. 🎉

Unutmadan söyleyeyim. Bu repo'nın daha detaylı açıklamasını [**medium**](https://medium.com/@53.emreyildirim/%C3%A7ok-parametreli-constructor-y%C3%B6netimi-65bcf4a4350d) hesabımda bulabilirsin. Beğendiysen orada da alkışını bekliyorum.

Au revoi 🙋🏻‍♂️
