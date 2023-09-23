package fabricasilla;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Material {
	

	    private int a;

		public Material(String nombre, double precio, int a) {
	        this.a = a;
	    }

	  
	    public void menuGestionMateriales() {
	        try (Scanner scanner = new Scanner(System.in)) {
				int op;

				do {
				    System.out.println("Menú de Gestión de Materiales");
				    System.out.println("1. Comprar Material");
				    System.out.println("2. Almacenar ");
				    System.out.println("3. Separar");
				    System.out.println("4. Salir");
				    System.out.print("Selecciona una opción: ");
				    op = scanner.nextInt();

				    switch (op) {
				        case 1:
				            comprar();
				            break;
				        case 2:
				            almacenar();
				            break;
				        case 3:
				            separar();
				            break;
				        case 4:
				            System.out.println("¡Hasta luego!");
				            break;
				        default:
				            System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
				    }
				} while (op != 3);
			}
	    }

	    public void comprar() {
	        try (Scanner registroCompra = new Scanner(System.in)) {
				System.out.println("Ingrese el nombre del material a comprar:");
				String nombreMaterial = registroCompra.nextLine();

				System.out.println("Ingrese la cantidad de " + nombreMaterial + " a comprar:");
				int cantidadAComprar = registroCompra.nextInt();

				if (cantidadAComprar <= 0) {
				    System.out.println("La cantidad a comprar debe ser mayor que cero.");
				    return;
				}

				if (cantidadAComprar > a) {
				    System.out.println("No hay suficientes " + nombreMaterial + " disponibles para comprar.");
				    return;
				}

				System.out.println("Ingrese el precio por unidad de " + nombreMaterial + ":");
				double precioUnidad = registroCompra.nextDouble();

				this.a -= cantidadAComprar;

				registrarCompraEnArchivo(nombreMaterial, cantidadAComprar, precioUnidad);

				System.out.println(cantidadAComprar + " unidades de " + nombreMaterial + " compradas con éxito.");
			}
	    }

	    private void registrarCompraEnArchivo(String nombreMaterial, int cantidadComprada, double precioUnidad) {
	        try (FileWriter archivo = new FileWriter("/Users/josesalazar/NetBeansProjects/Tarea1/tarea1/registro_compras.txt", true); PrintWriter escritor = new PrintWriter(archivo)) {
	            java.util.Date fechaActual = new java.util.Date();
	            String fechaCompra = fechaActual.toString();
	            double costoTotal = cantidadComprada * precioUnidad;

	            escritor.println("Fecha: " + fechaCompra);
	            escritor.println("Material: " + nombreMaterial);
	            escritor.println("Cantidad comprada: " + cantidadComprada);
	            escritor.println("Precio por unidad: $" + precioUnidad);
	            escritor.println("Costo total: $" + costoTotal);
	            escritor.println("----------------------------------");
	        } catch (IOException e) {
	            System.err.println("Error al registrar la compra en el archivo.");
	            e.printStackTrace();
	        }
	    }

	    public void almacenarMaterial() {
	        Scanner registroMaterial = new Scanner(System.in);

	        System.out.println("Ingrese el nombre del nuevo material:");
	        String nombreMaterial = registroMaterial.nextLine();

	        System.out.println("Ingrese la cantidad de " + nombreMaterial + " a agregar al inventario:");
	        int cantidadAgregar = registroMaterial.nextInt();

	        if (cantidadAgregar <= 0) {
	            System.out.println("La cantidad a agregar debe ser mayor que cero.");
	            return;
	        }

	        this.a += cantidadAgregar;

	        registrarAdicionEnArchivo(nombreMaterial, cantidadAgregar);

	        System.out.println(cantidadAgregar + " unidades de " + nombreMaterial + " agregadas al inventario con éxito.");
	    }

	    private void registrarAdicionEnArchivo(String nombreMaterial, int cantidadAgregada) {
	        try (FileWriter archivo = new FileWriter("/Users/josesalazar/NetBeansProjects/Tarea1/tarea1/registro_inventario.txt", true); PrintWriter escritor = new PrintWriter(archivo)) {
	            java.util.Date fechaActual = new java.util.Date();
	            String fechaAdicion = fechaActual.toString();

	            escritor.println("Fecha: " + fechaAdicion);
	            escritor.println("Material: " + nombreMaterial);
	            escritor.println("Cantidad agregada: " + cantidadAgregada);
	            escritor.println("----------------------------------");
	        } catch (IOException e) {
	            System.err.println("Error al registrar la adición al inventario en el archivo.");
	            e.printStackTrace();
	        }
	    }

	    public void separarMaterial() {
	        try (Scanner registroSeparacion = new Scanner(System.in)) {
				System.out.println("Ingrese el nombre del material a separar:");
				String nombreMaterial = registroSeparacion.nextLine();

				System.out.println("Ingrese la cantidad de " + nombreMaterial + " a separar del inventario:");
				int cantidadSeparar = registroSeparacion.nextInt();

				if (cantidadSeparar <= 0) {
				    System.out.println("La cantidad a separar debe ser mayor que cero.");
				    return;
				}

				if (cantidadSeparar > a) {
				    System.out.println("No hay suficientes " + nombreMaterial + " disponibles para separar.");
				    return;
				}

				this.a -= cantidadSeparar;

				registrarSeparacionEnArchivo(nombreMaterial, cantidadSeparar);

				System.out.println(cantidadSeparar + " unidades de " + nombreMaterial + " separadas del inventario con éxito.");
			}
	    }

	    private void registrarSeparacionEnArchivo(String nombreMaterial, int cantidadSeparada) {
	        try (FileWriter archivo = new FileWriter("/Users/josesalazar/NetBeansProjects/Tarea1/tarea1/registro_separacion.txt", true); PrintWriter escritor = new PrintWriter(archivo)) {
	            java.util.Date fechaActual = new java.util.Date();
	            String fechaSeparacion = fechaActual.toString();

	         
	            escritor.println("Fecha: " + fechaSeparacion);
	            escritor.println("Material: " + nombreMaterial);
	            escritor.println("Cantidad separada: " + cantidadSeparada);
	            escritor.println("----------------------------------");
	        } catch (IOException e) {
	            System.err.println("Error al registrar la separación en el archivo.");
	            e.printStackTrace();
	        }
	    }

	   

	}



