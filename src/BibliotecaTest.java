import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class BibliotecaTest {

    public static void main(String[] args) {
        Scanner opcion = new Scanner(System.in);
        Scanner entrada = new Scanner(System.in);
        Scanner idx = new Scanner(System.in);
        Scanner nombrex = new Scanner(System.in);
        Scanner aPaternox = new Scanner(System.in);
        Scanner aMaternox = new Scanner(System.in);
        ArrayList<Datos> Personas = new ArrayList<>();
        int option = 0;
        int i, id;
        do {
            System.out.print("*BIENVENIDO A LA DATA CENTER DE LA BIBLIOTECA*\n\n");
            System.out.println("[1]- Registrar");
            System.out.println("[2]- Buscar");
            System.out.println("[3]- Modificar");
            System.out.println("[4]- Eliminar");
            System.out.println("[0] -Salir");
            try {
                option = opcion.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("POR FAVOR INGRESA UN NUMERO VALIDO!!");
                opcion.next();
                continue;
            }
            if (option == 0) {
                System.out.print("ADIOS BUEN DIA!");
            }
            switch (option) {

                case 1:

                    System.out.print("INGRESA LA CANTIDAD QUE QUIERAS REGISTRAR: ");
                    try {
                        i = entrada.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("POR FAVOR INGRESA UN NUMERO VALIDO!!");
                        entrada.nextInt();
                        continue;
                    }
                    for (int x = 0; x < i; x++) {
                        System.out.print("INGRESA TU ID: ");
                        try {
                            id = idx.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("POR FAVOR INGRESA UN NUMERO VALIDO!!");
                            idx.next();
                            continue;
                        }
                        System.out.println("INGRESA TU NOMBRE: ");
                        String nombre = nombrex.nextLine();
                        System.out.println("INGRESA TU APELLIDO PATERNO: ");
                        String aPaterno = aPaternox.nextLine();
                        System.out.println("INGRESA TU APELLIDO MATERNO: ");
                        String aMaterno = aMaternox.nextLine();
                        Datos nuevaPersona = new Datos(id, nombre, aPaterno, aMaterno);
                        Personas.add(nuevaPersona);
                        System.out.println("REGISTRO EXITOSO");
                    }
                    break;
                case 2:
                    System.out.println("INGRESA ID PARA BUSCAR A LA PERSONA");
                    try {
                        id = idx.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("POR FAVOR INGRESA UN NUMERO VALIDO!!");
                        idx.next();
                        continue;
                    }
                    boolean BuscarPersona = false;
                    for (Datos nuevaPersona : Personas) {
                        if (nuevaPersona.id == id) {
                            System.out.println("BUSQUEDA COMPLETA\n");
                            System.out.println("ID: " + nuevaPersona.id + "\nNOMBRE: " + nuevaPersona.nombre + "\nAPELLIDO PATERNO: " + nuevaPersona.aPaterno + "\nAPELLIDO MATERNO: " + nuevaPersona.aMaterno + "\n");
                            BuscarPersona = true;
                            break;
                        }
                    }
                    if (!BuscarPersona) {
                        System.out.println("PERSONA NO ENCONTRADA:");
                    }
                    break;
                case 3:
                    int idModificar;
                    System.out.println("INGRESA ID PARA MODIFICAR LOS DATOS:");
                    try {
                        idModificar = idx.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("POR FAVOR INGRESA UN NUMERO VALIDO!!");
                        idx.next();
                        continue;
                    }
                    boolean modificarDatos = false;
                    for (i = 0; i < Personas.size(); i++) {
                        Datos persona = Personas.get(i);
                        if (persona.id == idModificar) {
                            System.out.println("PERSONA ENCONTRADA, INGRESA LOS NUEVOS DATOS:");
                            System.out.print("NUEVO NOMBRE: ");
                            String nuevoNombre = nombrex.nextLine();
                            System.out.print("NUEVO APELLIDO PATERNO: ");
                            String nuevoApaterno = aPaternox.nextLine();
                            System.out.print("NUEVO APELLIDO MATERNO: ");
                            String nuevoAmaterno = aMaternox.nextLine();

                            Personas.set(i, new Datos(idModificar, nuevoNombre, nuevoApaterno, nuevoAmaterno));

                            System.out.println("MODIFICACION EXITOSA");
                            modificarDatos = true;
                            break;
                        }
                    }
                    if (!modificarDatos) {
                        System.out.println("PERSONA NO ENCONTRADA!!");
                    }
                    break;
                case 4:
                    int idEliminar;
                    System.out.println("INGRESA ID PARA ELIMINAR");
                    try {
                        idEliminar = idx.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("POR FAVOR INGRESA UN NUMERO VALIDO!!");
                        idx.next();
                        continue;
                    }
                    boolean eliminarPersona = false;
                    for (Datos nuevaPersona : Personas) {
                        if (nuevaPersona.id == idEliminar) {
                            Personas.remove(nuevaPersona);
                            System.out.println("ELIMIACION EXITOSA");
                            eliminarPersona = true;
                            break;
                        }
                    }
                    if (!eliminarPersona) {
                        System.out.println("PERSONA NO ENCONTRADA!!");
                    }
                    break;
                

            }
            entrada.close();
            idx.close();
            nombrex.close();
            aPaternox.close();
            aMaternox.close();
            opcion.close();

        } while (option != 0);
    }
}

