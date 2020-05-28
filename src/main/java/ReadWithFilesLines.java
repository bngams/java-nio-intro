import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class ReadWithFilesLines {
    public static void main(String[] args) {
        readLines();
        readLinesWithFilter();
    }

    public static void readLines() {
        System.out.println("===== Read lines");
        String fileName = "days.txt";
        try (Stream stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readLinesWithFilter() {
        System.out.println("===== Read lines and filter");
        String fileName = "days.txt";
        try {
            Stream<String> lines = Files.lines(Paths.get(fileName));
            Optional hasEdi = lines.filter(s -> s.contains("edi")).findFirst();
            if(hasEdi.isPresent()){
                System.out.println(hasEdi.get());
            }
            //Fermer le flux
            lines.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
