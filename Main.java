import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Long> ReadFile(String path) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Long> list = new ArrayList<>();
        while (scanner.hasNextLong()) {
            list.add(scanner.nextLong());
        }
        scanner.close();
        return list;
    }
    public static long min(ArrayList<Long> lst){
        long mn=lst.get(0);
        for (int i=1;i<lst.size();i++){
            if (mn>lst.get(i)) mn=lst.get(i);
        }
        return mn;
    }
    public static long max(ArrayList<Long> lst){
        long mx=lst.get(0);
        for (int i=1;i<lst.size();i++){
            if (mx<lst.get(i)) mx=lst.get(i);
        }
        return mx;
    }
    public static long sum(ArrayList<Long> lst){
        long sm=0;
        for (int i=0;i<lst.size();i++){
            sm+= lst.get(i);
        }
        return sm;
    }
    public static long mult(ArrayList<Long> lst){
        long mlt=1;
        for (int i=0;i<lst.size();i++){
            mlt*= lst.get(i);
        }
        return mlt;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Введите путь до файла: ");
        String path =sc.nextLine();
        System.out.print("Введите имя файла: ");
        String name=sc.nextLine();
        ArrayList<Long> list=ReadFile(path+"/"+name);
        System.out.println("Минимальное: "+ min(list));
        System.out.println("Максимальное: "+ max(list));
        System.out.println("Сумма: "+ sum(list));
        System.out.println("Произведение: "+ mult(list));
    }
}