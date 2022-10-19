import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Divisiones extends Grafico implements Runnable {

    public Divisiones() {
        //super();
    }

    public void run() {
        //Scanner sc = new Scanner(System.in);
        int[] ventas = {100, 100, 100, 100};
        int[] grado = new int[4];
        int vdep;
        for (int i = 0; i < 4; i++){
            vdep = (int) (Math.random()*(1500 - 1) + 100);
            System.out.println("Ventas del departamento " + (i + 1) + ": " + vdep);
            ventas[i] = vdep;
        }
        grado = calcularGrado(ventas);
        fillArc(grado);

    }
}
