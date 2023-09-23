package fabricasilla;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class silla {
	private String TipoMaterial;
    private String Color;
    private String Estilo;

    public silla(String TipoMaterial, String Color, String Estilo) {
        this.TipoMaterial = TipoMaterial;
        this.Color = Color;
        this.Estilo = Estilo;
    }

    silla() {
    }

    public String getTipoMaterial() {
        return TipoMaterial;
    }

    public void setTipoMaterial(String TipoMaterial) {
        this.TipoMaterial = TipoMaterial;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getEstilo() {
        return Estilo;
    }

    public void setEstilo(String Estilo) {
        this.Estilo = Estilo;
    }

    public void FabricarSilla(Materiales inventario) {
        if (verificarInventario(inventario)) {
            System.out.println("Fabricando una silla con los siguientes detalles:");
            System.out.println("Tipo de material: " + TipoMaterial);
            System.out.println("Color: " + Color);
            System.out.println("Estilo: " + Estilo);
            System.out.println("La silla ha sido fabricada con éxito.");

            // Guardar los detalles de la silla en un archivo
            guardarSillaEnArchivo();
        } else {
            System.out.println("No hay suficientes materiales para fabricar la silla.");
        }
    }

    public void ArmarSilla(Materiales inventario) {
        if (verificarInventario(inventario)) {
            System.out.println("Armando una silla con los siguientes detalles:");
            System.out.println("Tipo de material: " + TipoMaterial);
            System.out.println("Color: " + Color);
            System.out.println("Estilo: " + Estilo);
            System.out.println("La silla ha sido armada con éxito.");

            guardarSillaEnArchivo();
        } else {
            System.out.println("No hay suficientes materiales para armar la silla.");
        }
    }

    void guardarSillaEnArchivo() {
        String InventarioSilla = null;
        try (FileWriter archivo = new FileWriter(InventarioSilla, true); PrintWriter escritor = new PrintWriter(archivo)) {
            escritor.println("Tipo de material: " + TipoMaterial);
            escritor.println("Color: " + Color);
            escritor.println("Estilo: " + Estilo);
            escritor.println("----------------------------------");
        } catch (IOException e) {
            System.err.println("Error al guardar la silla en el archivo.");
            e.printStackTrace();
        }
    }

    private boolean verificarInventario(Materiales inventario) {
        int cantidadMaterialNecesario = 1; // Puedes ajustar esta cantidad según tus necesidades

        if (inventario.getDisponibilidad() >= cantidadMaterialNecesario) {
            return true; 
        } else {
            return false; 
        }
    }
     public void mostrarMenu(Materiales inventario) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de Silla");
            System.out.println("1. Fabricar Silla");
            System.out.println("2. Armar Silla");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    FabricarSilla(inventario);
                    break;
                case 2:
                    ArmarSilla(inventario);
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }
        } while (opcion != 3);
    }

    public static void main(String[] args) {
        Materiales inventario = new Materiales("MaterialPrueba", 100.0, 10);

        Silla silla = new Silla("Madera", "Café", "Clásico");
        silla.mostrarMenu(inventario);
    }

    void mostrarMenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

