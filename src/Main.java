public class Main implements Runnable {

    Divisiones div = new Divisiones();
    Thread r1 = new Thread(div);
    public Main() {
        super();

        Thread principal = new Thread(this);
        principal.start();

    }
    public void run() {
        boolean ciclo = true; //Continuar con las acutalizaciones de la gráfica
        while (ciclo == true) {
            try {
                Thread.currentThread().sleep(5000);//Dormir el Thread principal y actualizar después de 5 segundos
                r1.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        //Departamentos app = new Departamentos();
        //Thread runapp = new Thread(app);
        //runapp.start();
        final Main app = new Main();
        Thread runapp = new Thread(app);
        runapp.start();
    }
}
