import com.fasterxml.jackson.annotation.JsonTypeId;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class CoordinadorDeClinica {
    @JsonTypeId
    public String contrasenaCoordinador;
    public String emailCoordinador;
    public Clinica clinicaCoordinador;

    @Override
    public String toString() {
        return "{" + "\n" +
                " emailCoordinador : " + emailCoordinador + "," + "\n" +
                " contrasenaCoordinador : " + contrasenaCoordinador + "," + "\n" +
                " clinicaCoordinador : " + clinicaCoordinador + "," + "\n" +
                "}";
    }

//    public static void main(String[] args) {
//
//        Scanner input = new Scanner(System.in);
//        while(true) {
//            System.out.println("Bienvenido Coordinado de clínica");
//            System.out.println("¿Qué desea realizar?");
//            System.out.println("1. editar clínica");
//            System.out.println("2. borrar clínica");
//            System.out.println("3. regitrar psiquiatra");
//            System.out.println("4. borrar psiquiatra");
//            System.out.println("5. suministrar medicamentos");
//            System.out.println("6. borrar medicamento");
//            System.out.println("0. salir");
//            String option = input.next();
//            if (option.equals("1")) {
//                editarClinica();
//            }
//            else if (option.equals("2")) {
//                borrarClinica();
//            }
//            else if(option.equals("3")){
//                registrarPsiquiatra();
//            }
//            else if(option.equals("4")){
//                borrarPsiquiatra();
//            }
//            else if(option.equals("5")){
//                suministrarMedicamentos();
//            }
//            else if(option.equals("6")){
//                borrarMedicamento();
//            }
//            else if(option.equals("0")){
//                break;
//            }
//
//        }
//
//    }
    public void editarClinica() {
        Scanner input = new Scanner(System.in);
        System.out.println("¿Qué atributo desea cambiar?");
        System.out.println("1. nombre de clínica");
        System.out.println("2. dirección");
        System.out.println("3. telfono");
        String cambio = input.next();

        if (cambio.equals("1")) {
            System.out.println("Ingrese el nuevo nombre de la clínica:");
            String nombre = input.nextLine();
            clinicaCoordinador.nombreClinica = nombre;
            //Código para cambiar el nombre de la clínica en los respectivos JSON!
        }
        else if (cambio.equals("2")) {
            System.out.println("Ingrese la nueva dirección de la clínica:");
            String direccion = input.nextLine();
            clinicaCoordinador.direccion = direccion;
            //Código para cambiar la dirección de la clínica en los respectivos JSON!
        }
        else if (cambio.equals("3")) {
            System.out.println("Ingrese el nuevo teléfono de la clínica:");
            int telefono = input.nextInt();
            clinicaCoordinador.telefono = telefono;
            //Código para cambiar el teléfono de la clínica en los respectivos JSON!
        }
        else {
            System.out.println("Ha ingresado una opción inválida");
            return;
        }


    }

    public void borrarClinica() {
        Scanner input = new Scanner(System.in);
        System.out.println("¿Está seguro que desea borrar la clínica?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        String borrar = input.next();

        if (!borrar.equals("1") || !borrar.equals("2")) {
            System.out.println("Ha ingresado una opción inválida");
        }
        else if (borrar.equals("2")) {
            return;
        }

        System.out.println("Antes de borrar la clínica, debe trsladar los datos, bienes " +
                "y personas de esta clínica a otra clínica ");
        System.out.println("A qué clínica desea trasladarlos:");
        //sacar lista de clínicas del json y mostrarlas acá
        System.out.println("1. Clínica 1");
        System.out.println("1. Clínica 1");
        System.out.println("1. Clínica 1");

        //hacer trslado de datos y eliminar clínica

    }

    public void registrarPsiquiatra() {
        Scanner input = new Scanner(System.in);

        //Pedir datos y validar los necesarios
        System.out.println("Ingrese el primer nombre (y segundo si tiene) del psiquiatra a registrar:");
        String nombres = input.nextLine();

        System.out.println("Ingrese los apellidos del psiquiatra a registrar:");
        String apellidos = input.nextLine();

        System.out.println("Ingrese el email del psiquiatra a registrar:");
        String email = input.nextLine();

        System.out.println("Ingrese la contraseña del psiquiatra a registrar:");
        String contrasena = input.nextLine();

        System.out.println("Ingrese el sexo del(la) psiquiatra: ");
        System.out.println("1. Masculino");
        System.out.println("2. Femenino");
        System.out.println("3. Otro");
        String sexo = input.next();
        if (sexo.equals("1")) {
            sexo = "masculino";
        }
        else if (sexo.equals("2")) {
            sexo = "femenino";
        }
        else if (sexo.equals("3")) {
            sexo = "femenino";
        }
        else {
            System.out.println("Ingresó una respuesta inválida");
        }

        System.out.println("Ingrese la dirección del psiquiatra a registrar:");
        String direccion = input.nextLine();

        System.out.println("Ingrese la edad del psiquiatra a registrar:");
        int edad = input.nextInt();
        if (edad < 18) {
            System.out.println("La edad ingresada es inválida, debe ser mayor a 18");
            return;
        }

        System.out.println("Ingrese el año de nacimiento");
        int año = input.nextInt();
        if (año > 2020 || año < 1920) {
            System.out.println("Año de nacimiento inválido");
            return;
        }
        System.out.println("Ingrese el mes de nacimiento en número");
        int mes= input.nextInt();
        if (mes > 12 || año < 1) {
            System.out.println("Mes de nacimiento inválido");
            return;
        }
        System.out.println("Ingrese el día de nacimiento");
        int dia = input.nextInt();
        if (dia > 31 || dia < 1) {
            System.out.println("Día de nacimiento inválido");
            return;
        }
        Date fechaNacimiento = new Date(año, mes - 1 , dia);

        System.out.println("Ingrese el teléfono del psiquiatra a registrar:");
        int telefono = input.nextInt();
        if (telefono < 0) {
            System.out.println("El teléfono ingresado es inválido, no puede ser negativo");
            return;
        }

        //Crear id del psiquiatra
        int idlistaDePsiquiatra = clinicaCoordinador.listaDePsiquiatras.size();


        //Psiquiatra nuevoPsiquiatra = new Psiquiatra(idPsiquiatra, nombres, apellidos, email, contrasena, sexo,
        // direccion, edad, fechaNacimiento, telefono);

    }

    public void borrarPsiquiatra() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el id del psiquiatra que desea eliminar de su clínica");
        int id = input.nextInt();

        if (id < 0) {
            System.out.println("Ha ingresado un id inválido");
            return;
        }

        boolean psExiste = false;
        for (int i = 0; i < clinicaCoordinador.listaDePsiquiatras.size(); i++) {
            Psiquiatra psiquiatra = clinicaCoordinador.listaDePsiquiatras.get(i);
            if (psiquiatra.idPsiquiatra == id) {
                psExiste = true;
                clinicaCoordinador.listaDePsiquiatras.remove(i);
                System.out.println("Se ha removido al psiquiatra con éxito");
                break;
            }
        }
        if (!psExiste) {
            System.out.println("No hay psiquiatra registrado con el id " + id);
        }
    }

    public void suministrarMedicamentos() {
        System.out.println("Para visualizar los medicamentos de la clínica, escoja respecto a cual" +
                " atributo los quiere organizar: ");
        System.out.println("1. Nombre");
        System.out.println("2. Cantidad");

        Collections.sort(clinicaCoordinador.listaDeMedicamentos, new MedicamentoComparatorNombre());


    }

    public void borrarMedicamento() {

    }



}



