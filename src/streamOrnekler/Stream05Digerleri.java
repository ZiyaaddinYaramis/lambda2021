package streamOrnekler;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Stream05Digerleri {
    public static void main(String[] args) {

        System.out.println("TOPLAM:" + topla(4));
        System.out.println("TOPLAM:" + topla1(4));
        toplaYazdir(4);
        System.out.println("==========");
        tekSayilariToplaYazdir(1,7);



        System.out.println("Faktoriyel=" + faktoriyel(20));
        System.out.println("Faktoriyel=" + faktoriyel1(20));
    }



    //****************************************************************************************************
    // ÖRNEK25: 1'den belirtilen değere kadar olan tamsayıları toplayan ve sonucu döndüren metodu yazınız.
    //****************************************************************************************************


    public static int topla(int deger){
        return IntStream.range(1,  deger + 1).sum(); // range aralik demektir. deger'e +1 eklememizin sebebi; 1. paremetrenin
                                                     // dahil olup ikinci parametrenin dahil olmamasindan kaynaklidir. (int startInclusive,int endExclusive)
    }


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
    public static int faktoriyel(int n){
        return IntStream.rangeClosed(1,n).reduce(1,(x,y)->x*y);
    }

    public static long faktoriyel1(int n){
        return LongStream.rangeClosed(1,n).reduce(1,(x, y)->x*y);
    }




}
