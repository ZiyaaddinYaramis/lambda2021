package streamOrnekler;
import java.util.List;
import java.util.stream.*;

public class Stream05Digerleri {
    public static void main(String[] args) {

        System.out.println("TOPLAM:" + topla(4));
        System.out.println("TOPLAM:" + topla1(4));
        toplaYazdir(4);
        System.out.println("==========");
        tekSayilariToplaYazdir(1,7);
        System.out.println("Faktoriyel=" + faktoriyel(10));
        System.out.println("Faktoriyel=" + faktoriyel1(20));
        System.out.println("Faktoriyel=" + faktoriyel2(34));
        System.out.println("NOtları 50'den büyük olanlar:" + doubleDiziCevirList());

    }



    //****************************************************************************************************
    // ÖRNEK25: 1'den belirtilen değere kadar olan tamsayıları toplayan ve sonucu döndüren metodu yazınız.
    //****************************************************************************************************
    // Instream.range(a,b) metodu parantez içerisinde verilen aralıklarda bir int stream oluşturur.
    // Ancak, üst aralık (b) dahil değildir.

    public static int topla(int deger){
        return IntStream.range(1,  deger + 1).sum(); // range aralik demektir. deger'e +1 eklememizin sebebi; 1. paremetrenin
                                                     // dahil olup ikinci parametrenin dahil olmamasindan kaynaklidir. (int startInclusive,int endExclusive)
    }

    // Instream.rangeCLosed(a,b) metodu parantez içerisinde verilen aralıklarda bir int stream oluşturur.
    // alt(a) ve üst aralık (b) dahildir.
    public static int topla1(int deger){
        return IntStream.rangeClosed(1,  deger).sum(); // rangeClosed'de iki paremetre'de dahildir (int startInclusive,int endInclusive)
    }


    public static void toplaYazdir(int deger){

        IntStream.rangeClosed(1,deger).forEach(System.out::println);
    }




    //****************************************************************************************************
    // ÖRNEK26: Berlirtilen aralıktaki tek sayıların toplamını yazdıran metodu tanımlayınız.
    //****************************************************************************************************


    public static void tekSayilariToplaYazdir(int alt, int ust){
        System.out.println(IntStream.rangeClosed(alt,ust).filter(Methodlar::tekMi).sum()); // sum() terminaldir. tek bir deger döndurur
                                                                                           // ve stream'de ancak bir tane terminal islem olabilir
    }




    //****************************************************************************************************
    // ÖRNEK27: Berlirtilen sayının faktoriyelini hesaplayan metodunu tanımlayınız.
    //****************************************************************************************************
    // iterate metodu aslında döngülere benzer. Başlangıcı ve artım miktarı parametre olarak verilebilir.
    // Döngünün biteceği sayı ise limit() metodu ile gösterilir.

    public static Integer faktoriyel(int n){
        /*
        return IntStream.rangeClosed(1,n).reduce(1,(x,y)->x*y);


        reduce ardisik ilerleyen islenler icin uygundur
    reduce(1,(x,y) -> x*y)

           1 ==> identifier (tanimlayici) yani baslangic degeri

             (x,y) -> x*y ==> lambda ifadesi

                reduce(1,(x , y) -> x*y)
                          1   1 => 1
                          1   2 => 2
                          2   3 => 6
                          6   4 => 24
                         24   5 => 120
                         *    6
                         *    7
         */

           return IntStream.iterate(1, t->t+1).limit(n).reduce(1,(x,y)->x*y);
    }


    // InStream gibi LongStream ve DoubleStream'ler de bulunmaktadır.
    public static Long faktoriyel1(int n){
        return LongStream.rangeClosed(1,n).reduce(1,(x, y)->x*y);
    }

    // DoubleStream de range() metodu bulunmamaktadır.
    // (Teorik olarak mantıklı değil. Çünkü, belirtilen aralıkta sonsuz adet double sayı olabilir).
    // Ama iterate() metodu ile kullanıcı aralık, arttırım miktarı v.b vererek işlemler yapabilir.
    public static double faktoriyel2(int n){
        return DoubleStream.iterate(1, t->t+1).limit(n).reduce(1,(x, y)->x*y);
    }

    //*********************************************************************************************
    // ÖRNEK28: Bir double diziyi (notlar) Stream nesnesine dönüştürerek bu dizi içerisinde bulunan
    // sayıların 50 den büyük olanlarını ayrı bir listeye kaydererek yazdıran metodu tanımlayınız
    //**********************************************************************************************
    public static List<Double> doubleDiziCevirList() {
        Double[] notlar = {88.5, 52.3, 88.9, 100.0, 99.6, 42.0, 10.0};
        Stream<Double> streamNotlar = Stream.of(notlar);
        return streamNotlar.filter(t -> t > 50.0).collect(Collectors.toList());
    }

}
