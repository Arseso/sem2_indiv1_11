import ext.IO;
import obj.People;

import java.util.ArrayList;

public class main {
    private static final String FILE_NAME = "src/peoples.txt";


    public static void main(String[] args) {

        ArrayList<People> peoples = IO.inputFromFile(FILE_NAME);
        if(peoples == null) return;
        IO.printAbout(peoples);
        IO.printHi(peoples);
        IO.printSortedByName(peoples);
        IO.printSortedByAge(peoples);
        IO.printSortedByNameAndType(peoples);
    }




}
