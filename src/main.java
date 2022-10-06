import ext.IO;
import obj.People;

import java.util.ArrayList;

public class main extends IO {
    private static final String FILE_NAME = "src/peoples.txt";


    public static void main(String[] args) {

        ArrayList<People> peoples = inputFromFile(FILE_NAME);
        if(peoples == null) return;
        printAbout(peoples);
        printHi(peoples);
        printSortedByName(peoples);
        printSortedByAge(peoples);
        printSortedByNameAndType(peoples);
    }




}
