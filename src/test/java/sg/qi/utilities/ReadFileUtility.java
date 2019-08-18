package sg.qi.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFileUtility {

    public static String[] readFile(String fileName) throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + System.getProperty("file.separator")
            + "src" + System.getProperty("file.separator") + "test" + System.getProperty("file.separator")
            + "resources" + System.getProperty("file.separator") + fileName + ".txt");
        Scanner scanner = new Scanner(file);
        ArrayList<String> items = new ArrayList<>();
        while (scanner.hasNextLine()) {
            items.add(scanner.nextLine());
        }
        return items.toArray(new String[0]);
    }

}