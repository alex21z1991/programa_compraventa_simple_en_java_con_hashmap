
import java.util.*;

public class compra_venta {

    public static void main(String[] args) {

        HashMap<String, Integer> compra = new HashMap<>();
        HashMap<String, Integer> venta = new HashMap<>();

        Scanner ingresar = new Scanner(System.in);

        compra.put("nintendo nes", 20000);
        compra.put("play station 4", 200000);
        compra.put("objeto de prueba", 0);

        int opcion = 0;
        int plata_usuario = 0;

        while (opcion != 5) {

            System.out.println("===== MENU =====");
            System.out.println("1. compra de objetos");
            System.out.println("2. venta de objetos");
            System.out.println("3. ingresar dinero");
            System.out.println("4. mostrar saldo");
            System.out.println("5. salir");

            opcion = ingresar.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Objetos disponibles:");

                    for (Map.Entry<String, Integer> e : compra.entrySet()) {
                        System.out.println(e.getKey() + " $" + e.getValue());
                    }

                    System.out.println("¿Alguno te interesa? 1) si 2) no");
                    int opcion1 = ingresar.nextInt();
                    ingresar.nextLine();

                    if (opcion1 == 1) {
                        System.out.println("Ingrese el nombre del objeto:");
                        String objetocomprado = ingresar.nextLine();

                        if (compra.containsKey(objetocomprado)) {

                            int precio = compra.get(objetocomprado);

                            if (plata_usuario >= precio) {
                                plata_usuario -= precio;

                                System.out.println("Compra realizada");
                                System.out.println("Saldo restante $" + plata_usuario);

                                venta.put(objetocomprado, precio);
                                compra.remove(objetocomprado);

                            } else {
                                System.out.println("No te alcanza");
                            }

                        } else {
                            System.out.println("Ese objeto no existe");
                        }
                    }
                    break;

                case 2:
                    System.out.println("¿Tienes objetos para vender? 1) si 2) no");
                    int opcionventa = ingresar.nextInt();
                    ingresar.nextLine();

                    if (opcionventa == 1) {
                        System.out.println("Nombre del objeto:");
                        String objetoventa = ingresar.nextLine();

                        System.out.println("Precio:");
                        int precioventa = ingresar.nextInt();

                        compra.put(objetoventa, precioventa);
                        System.out.println("Objeto agregado para venta");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese dinero:");
                    int plata = ingresar.nextInt();
                    plata_usuario += plata;
                    break;

                case 4:
                    System.out.println("Saldo actual $" + plata_usuario);
                    break;
            }

            System.out.println();
        }
    }
}
