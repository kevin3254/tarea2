package fabricasilla;
import java.util.Scanner;

import fabricasilla.Materiales;
import fabricasilla.Silla;
public class Fabrica {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FabricaDeSillas fabrica = new FabricaDeSillas();
        Materiales dato2 = new Materiales();
        Pedido dato3 = new Pedido();
        Silla dato1 = new Silla();

        //Materiales mate = new Materiales();
        int opcion;
        
        do {
            System.out.println("Menú Principal");
            System.out.println("1. Fabricar Silla");
            System.out.println("2. Administrar Inventario");
            System.out.println("3. Gestionar Pedidos");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    dato1.mostrarMenu();
                    break;
                case 2:
                    dato2.comprarMateriales();
                    
                    break;
                
                case 3:
                    dato3.menuPedido(dato2, dato1);
                    
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }
        } while (opcion != 4);
    }
}
	
	
}
