import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Main {
    
     //Понадобятся при тестах
    Random r=new Random();
    long time;
    
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


    
    //Тесты для проверки скорости работы программы при увеличении размера входного файла

    void minTimeTest() {
        ArrayList<Long> arr=new ArrayList<>();
        int size=1000;
        for (int j=1;j<6;j++) {
            for (int i = 0; i < size*(int)Math.pow(10,j); i++) {
                arr.add(r.nextLong(1000000000));
            }
            time = System.currentTimeMillis();
            min(arr);
            System.out.println("Скорость работы при размере "+arr.size()+" элементов = "+(System.currentTimeMillis() - time)+" мс");
        }
    }

    void maxTimeTest() {
        ArrayList<Long> arr=new ArrayList<>();
        int size=1000;
        for (int j=1;j<6;j++) {
            for (int i = 0; i < size*(int)Math.pow(10,j); i++) {
                arr.add(r.nextLong(1000000000));
            }
            time = System.currentTimeMillis();
            max(arr);
            System.out.println("Скорость работы при размере "+arr.size()+" элементов = "+(System.currentTimeMillis() - time)+" мс");
        }
    }

    void sumTimeTest() {
        ArrayList<Long> arr=new ArrayList<>();
        int size=1000;
        for (int j=1;j<6;j++) {
            for (int i = 0; i < size*(int)Math.pow(10,j); i++) {
                arr.add(r.nextLong(1000000000));
            }
            time = System.currentTimeMillis();
            sum(arr);
            System.out.println("Скорость работы при размере "+arr.size()+" элементов = "+(System.currentTimeMillis() - time)+" мс");
        }
    }

    void multTimeTest() {
        ArrayList<Long> arr=new ArrayList<>();
        int size=1000;
        for (int j=1;j<6;j++) {
            for (int i = 0; i < size*(int)Math.pow(10,j); i++) {
                arr.add(r.nextLong(1000000000));
            }
            time = System.currentTimeMillis();
            mult(arr);
            System.out.println("Скорость работы при размере "+arr.size()+" элементов = "+(System.currentTimeMillis() - time)+" мс");
        }
    }



    //Тесты для проверки времени процессорного исполнения программы

    //Метод для подсчета времени процессора
    private static long getCpuTime() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        return bean.isCurrentThreadCpuTimeSupported() ? bean.getCurrentThreadCpuTime() : 0L;
    }


    void minCPUTest(){
        ArrayList<Long> arr=new ArrayList<>();
        int rnd=r.nextInt(10000000);
        long actual=r.nextLong();
        arr.add(actual);
        for (int i=0;i<rnd;i++){
            arr.add(r.nextLong(1000000000));
            actual*=arr.getLast();
        }
        long startCPUTime = getCpuTime();
        min(arr);
        long endCPUTime = getCpuTime();

        long cpuTime = endCPUTime - startCPUTime;
        System.out.println("Процессорное время: " + cpuTime + " наносекунд");
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
        System.out.println();
        System.out.println("Тест функции минимума:\n", minTimeTest());
        System.out.println("Тест функции максимума:\n", maxTimeTest());
        System.out.println("Тест функции суммы:\n", sumTimeTest());
        System.out.println("Тест функции произведения:\n", multTimeTest());
        System.out.println();
        System.out.println("Тест функции минимума:\n", minCPUTest());
    }
}
