import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Graph extends JPanel {
    public Graph() {
        setSize(500, 500);
    }

    public void paintComponent(Graphics g,ArrayList<Integer> scores) {
        Graphics2D gr = (Graphics2D) g;
        int x1,x2,y1,y2;
        for (int i = 0; i < scores.size()-3; i++) {
            x1 = scores.get(i);
            x2 = scores.get(i+1);
            y1 = scores.get(i+2);
            y2 = scores.get(i+3);
            gr.drawLine(x1,y1,x2,y2);
        }
    }
}