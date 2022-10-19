import javax.swing.*;
import java.awt.*;

public class Grafico {
    private int[] grado = {90,90,90,90};

    public Grafico() {
        super();
        int[] grado;
    }

    public int[] calcularGrado(int[] ventas) {
        int totventas = 0;
        for (int i = 0; i < 4; i++){
            totventas = totventas + ventas[i];
        }
        for (int i = 0; i < 4; i++){
            grado[i] = (ventas[i] * 360) / totventas;
        }

        return grado;
    }

    public void fillArc(int[] grado) {
        //Declarar ángulos
        int dep1 = 90; //ángulo departamento 1
        int dep2 = 90; //"..." 2
        int dep3 = 90; //"..." 3
        int dep4 = 90; //"..." 4
        for (int i = 0; i < 4; i++){ //Asgingar a cada ángulo su valor
            if (i == 0){
                dep1 = grado[i]; //1
            } else if (i == 1){
                dep2 = grado[i]; //2
            } else if (i == 2){
                dep3 = grado[i]; //3
            } else if (i == 3){
                dep4 = grado[i]; //4
            }
        }
        new Frame(dep1, dep2, dep3, dep4);
    }

    public class Frame extends JFrame {

        Frame(int dep1, int dep2, int dep3, int dep4) {

            Panel panel = new Panel(dep1, dep2, dep3, dep4);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.add(panel);
            this.pack();
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }
    }

    public class Panel extends JPanel {

        //Angulos

        int dep1;
        int dep2;
        int dep3;
        int dep4;

        Panel(int angdep1, int angdep2, int angdep3, int angdep4) {
            this.setPreferredSize(new Dimension(500, 500));
            this.dep1 = angdep1;
            this.dep2 = angdep2;
            this.dep3 = angdep3;
            this.dep4 = angdep4;
        }

        public void paint(Graphics g) {

            Graphics2D depto1 = (Graphics2D) g;
            Graphics2D depto2 = (Graphics2D) g;
            Graphics2D depto3 = (Graphics2D) g;
            Graphics2D depto4 = (Graphics2D) g;

            depto1.setColor(Color.magenta); //Color del arco del departamento 1
            depto1.fillArc(1, 1, 500, 500, 0, dep1); //Arco del departamento 1
            depto2.setColor(Color.blue); //Color del arco del departamento 2
            depto2.fillArc(1, 1, 500, 500, dep1, dep2+dep1); //Arco del departamento 2
            depto3.setColor(Color.green); //Color del arco del departamento 3
            depto3.fillArc(1, 1, 500, 500, dep2+dep1, dep3+dep2); //Arco del departamento 3
            depto4.setColor(Color.orange); //Color del arco del departamento 4
            depto4.fillArc(1, 1, 500, 500, dep3+dep2, dep4+dep3); //Arco del departamento 4
        }
    }
}
