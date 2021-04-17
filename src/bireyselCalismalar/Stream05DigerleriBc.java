package bireyselCalismalar;

import streamOrnekler.Methodlar;

import java.util.stream.IntStream;

public class Stream05DigerleriBc {
    public static void main(String[] args) {

        System.out.println(toplam(4)); //10
        System.out.println(toplam1(6)); //21
        toplamYazdir(10);
        tekSayilarinToplami(4, 7);
        System.out.println(tekSayilarinToplamiDondur(4, 7));
        System.out.println(tekSayilarinToplamiDondurLambda(4,7));

    }


    //****************************************************************************************************
    // ÖRNEK25: 1'den belirtilen değere kadar olan tamsayıları toplayan ve sonucu döndüren metodu yazınız.
    //****************************************************************************************************

    public static int toplam(int deger){
        return IntStream.range(1, deger+1).sum();
    }

    public static  int toplam1(int deger){
        return IntStream.rangeClosed(1,deger).sum();
    }

    public static void toplamYazdir(int deger){
        System.out.println(IntStream.rangeClosed(1,deger).sum());
    }


    //****************************************************************************************************
    // ÖRNEK26: Berlirtilen aralıktaki tek sayıların toplamını yazdıran metodu tanımlayınız.
    //****************************************************************************************************

    public static void tekSayilarinToplami(int ilk, int son){
        System.out.println(IntStream.rangeClosed(ilk,son).filter(Methodlar::tekMi).sum());;
    }

    public static int tekSayilarinToplamiDondur(int ilk, int son){
       return IntStream.rangeClosed(ilk,son).filter(Methodlar::tekMi).sum();
    }

    public static int tekSayilarinToplamiDondurLambda(int ilk,int son){
        return IntStream.rangeClosed(ilk, son).filter(x-> x%2!=0).sum();
    }

}
