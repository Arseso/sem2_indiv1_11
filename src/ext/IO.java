package ext;

import obj.People;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IO {


    protected static ArrayList<People> inputFromFile(String filename) {
        ArrayList<String> strings = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String s;
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

    protected static void printHi(ArrayList<People> peoples) {
        System.out.println("Приветствия: ");
        ArrayList<People> black = new ArrayList<>();
        for(People p1 : peoples){
            for(People p2 : peoples) if(p1!=p2 && !black.contains(p2)) p1.hi(p2);
            for(People p2 : peoples) if(p1!=p2 && !black.contains(p2)) p2.hi(p1);
            black.add(p1);

        }
    }

    protected static void printSortedByName(ArrayList<People> peoples) {
        System.out.println("Отсортировано по имени: ");
        Comparator<People> comparator = Comparator.comparing(People::getName);
        peoples.sort(comparator);
        printAbout(peoples);
    }

    protected static void printSortedByAge(ArrayList<People> peoples) {
        System.out.println("Отсортировано по возрасту: ");
        Comparator<People> comparator = Comparator.comparing(People::getAge);
        peoples.sort(comparator);
        printAbout(peoples);
    }

    protected static void printSortedByNameAndType(ArrayList<People> peoples) {
//        работает не так как надо
        System.out.println("Отсортировано по имени и типу: ");
        Comparator<People> comparator = Comparator.comparing(People::getName);
        comparator.thenComparing(People::getType);
        peoples.sort(comparator);
        printAbout(peoples);
    }
    protected static void printAbout(ArrayList<People> p){
        for(People people : p) people.about();
    }

    private static ArrayList<People> strToPeople(ArrayList<String> strings) {
        ArrayList<People> arr = new ArrayList<>();
        for (String s : strings) {
            String[] sArr = s.split("\\:", 3);
            if (Integer.parseInt(sArr[1]) != 0 || getType(sArr[2]) != -1)
                arr.add(new People(sArr[0], Integer.parseInt(sArr[1]), getType(sArr[2])));
            else return null;
        }
        return arr;
    }

    private static int getType(String s) {
        return switch (s) {
            case "Реалист" -> People.TYPE_REAL;
            case "Формалист" -> People.TYPE_FORMAL;
            case "Неформал" -> People.TYPE_INFORMAL;
            default -> -1;
        };
    }
}
