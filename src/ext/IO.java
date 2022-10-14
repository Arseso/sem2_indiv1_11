package ext;

import obj.People;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IO {


    public static ArrayList<People> inputFromFile(String filename) {
        ArrayList<String> strings = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String s;
            s = br.readLine();
            while ((s = br.readLine()) != null) {
                strings.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            return null;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }

        return strToPeople(strings);
    }

    public static void printHi(ArrayList<People> peoples) {
        System.out.println("???????????: ");
        ArrayList<People> black = new ArrayList<>();
        for(People p1 : peoples){
            for(People p2 : peoples) if(p1!=p2 && !black.contains(p2)) p1.hi(p2);
            for(People p2 : peoples) if(p1!=p2 && !black.contains(p2)) p2.hi(p1);
            black.add(p1);

        }
    }

    public static void printSortedByName(ArrayList<People> peoples) {
        System.out.println("Sorted by Name: ");
        Comparator<People> comparator = Comparator.comparing(People::getName);
        peoples.sort(comparator);
        printAbout(peoples);
    }

    public static void printSortedByAge(ArrayList<People> peoples) {
        System.out.println("Sorted by age: ");
        Comparator<People> comparator = Comparator.comparing(People::getAge);
        peoples.sort(comparator);
        printAbout(peoples);
    }

    public static void printSortedByNameAndType(ArrayList<People> peoples) {
        System.out.println("Sorted by name and type: ");
        Comparator<People> comparatorType = Comparator.comparing(People::getType);
        Comparator<People> comparatorName = Comparator.comparing(People::getName);
        peoples.sort(comparatorName.thenComparing(comparatorType));
        printAbout(peoples);
    }
    public static void printAbout(ArrayList<People> p){
        for(People people : p) people.about();
    }

    private static ArrayList<People> strToPeople(ArrayList<String> strings) {
        ArrayList<People> arr = new ArrayList<>();
        for (String s : strings) {
            String[] sArr = s.split("\\s+", -1);

            int age = 0;

            try{ age = Integer.parseInt(sArr[1]); } catch (NumberFormatException e){ System.out.println(e); };
            if (sArr.length ==3 && age>0 && getType(sArr[2]) != -1)
                arr.add(new People(sArr[0], age, getType(sArr[2])));
            else {
                System.out.println("Для человека " + sArr[0] + " данные указаны неверно, строка пропущена");
                continue;
            };
        }
        return arr;
    }

    private static int getType(String s) {
        return switch (s) {
            case "Real" -> People.TYPE_REAL;
            case "Formal" -> People.TYPE_FORMAL;
            case "Informal" -> People.TYPE_INFORMAL;
            default -> -1;
        };
    }
}
