import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {


    //Понадобятся при тестах
    Random r=new Random();


    //Тесты для проверки корректности функций поиска минимума, максимума, сложения и умножения

    @org.junit.jupiter.api.Test
    void min() {
        ArrayList<Long> arr=new ArrayList<>();
        int rnd=r.nextInt(100000);
        long actual=r.nextLong();
        arr.add(actual);

        for (int i=0;i<rnd;i++){
            arr.add(r.nextLong(1000000000));
            if (arr.getLast()<actual){
                actual=arr.getLast();
            }
        }
        long expected=Main.min(arr);

        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void max() {
        ArrayList<Long> arr=new ArrayList<>();
        int rnd=r.nextInt(100000);
        long actual=r.nextLong();
        arr.add(actual);

        for (int i=0;i<rnd;i++){
            arr.add(r.nextLong(1000000000));
            if (arr.getLast()>actual){
                actual=arr.getLast();
            }
        }
        long expected=Main.max(arr);

        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void sum() {
        ArrayList<Long> arr=new ArrayList<>();
        int rnd=r.nextInt(100000);
        long actual=r.nextLong();
        arr.add(actual);

        for (int i=0;i<rnd;i++){
            arr.add(r.nextLong(1000000000));
            actual+=arr.getLast();
        }
        long expected=Main.sum(arr);

        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void mult() {
        ArrayList<Long> arr=new ArrayList<>();
        int rnd=r.nextInt(100000);
        long actual=r.nextLong();
        arr.add(actual);

        for (int i=0;i<rnd;i++){
            arr.add(r.nextLong(1000000000));
            actual*=arr.getLast();
        }
        long expected=Main.mult(arr);

        assertEquals(expected,actual);
    }



    //График зависимости времени выполнения от кол-ва чисел в файле
//    @Test
//    void _minGraphic(){
//        ArrayList<Long> arr=new ArrayList<>();
//        ArrayList<Integer> tm=new ArrayList<>();
//        ArrayList<Integer> sz=new ArrayList<>();
//        int size=1000;
//        for (int j=1;j<6;j++) {
//            for (int i = 0; i < size*(int)Math.pow(10,j); i++) {
//                arr.add(r.nextLong(1000000000));
//            }
//            time = System.currentTimeMillis();
//            Main._min(arr);
//            tm.add((int) (System.currentTimeMillis() - time));
//            sz.add(arr.size());
//        }
//        Line2D line;
//        Graphics2D g;
//        for (int j=0;j<sz.size()-1;j++){
//            line=new Line2D.Double(sz[j],tm[j],sz[j+1],tm[j+1]);
//            g.draw(line);
//        }
//        JFrame testFrame=new JFrame();
//        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Graph graph = new Graph();
//        testFrame.add(graph);
//        testFrame.setBounds(100, 100, 764, 470);
//        testFrame.setVisible(true);
//        graph.paintComponent();
    }
}
