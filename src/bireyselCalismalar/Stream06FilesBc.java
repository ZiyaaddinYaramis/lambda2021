package bireyselCalismalar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Stream06FilesBc {

    public static void main(String[] args) throws IOException {

        String path = "src/streamOrnekler/mars.txt";
        //Stream<String> satirlar =  Files.lines(Path.of("src/streamOrnekler/mars.txt"));
                    // satirlar adinda bir stream olusturduk
                    // satirlar. deyince stream methodlarini kullanabiliriz


        Stream<String> satirlar = Files.lines(Path.of(path));

        satirlar.forEach(System.out::println);

        System.out.println("===========================================================");

        Files.lines(Paths.get(path))
        //Files.lines(Paths.get("src/streamOrnekler/mars.txt"))
                //.map(t-> t.toUpperCase()).forEach(System.out::println);
                .map(String::toUpperCase).forEach(System.out::println);


        String Path1 = "src/streamOrnekler/LambdaNotlar";
        Stream<String> lambdaNotlari = Files.lines(Path.of(Path1));

        lambdaNotlari.forEach(System.out::println);


    }


}
