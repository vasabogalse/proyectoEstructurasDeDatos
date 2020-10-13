import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class CoordinadorDeClinica implements handleJSON{
    public int cedulaCoordinador;
    public String contrasenaCoordinador;
    public String emailCoordinador;
    public Clinica clinicaCoordinador;

    public CoordinadorDeClinica() {
    }


    public static void main(String[] args) {

        handleDB db = new handleDB();
        db.readAllJSON();






        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Bienvenido Coordinado de clínica");
            System.out.println("¿Qué desea realizar?");
            System.out.println("1. editar clínica");
            System.out.println("2. borrar clínica");
            System.out.println("3. regitrar psiquiatra");
            System.out.println("4. borrar psiquiatra");
            System.out.println("5. suministrar medicamentos");
            System.out.println("6. borrar medicamento");
            System.out.println("0. salir");
            String option = input.next();
//            if (option.equals("1")) {
//               coordinadorDePrueba.editarClinica();
//            }
//            else if (option.equals("2")) {
//                coordinadorDePrueba.borrarClinica();
//            }
//            else if(option.equals("3")){
//                coordinadorDePrueba.registrarPsiquiatra();
//            }
//            else if(option.equals("4")){
//                coordinadorDePrueba.borrarPsiquiatra();
//            }
//            else if(option.equals("5")){
//                coordinadorDePrueba.suministrarMedicamentos();
//            }
//            else if(option.equals("6")){
//                coordinadorDePrueba.borrarMedicamento();
//            }
//            else if(option.equals("0")){
//                break;
//            }

        }

    }



    public void editarClinica() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("¿Qué atributo desea cambiar?");
            System.out.println("1. nombre de clínica");
            System.out.println("2. dirección");
            System.out.println("3. telfono");
            System.out.println("0. Regresar al menú principal");
            String cambio = input.next();
            if (cambio.equals("1")) {
                System.out.println("Ingrese el nuevo nombre de la clínica:");
                input.nextLine();
                String nombre = input.nextLine();
                clinicaCoordinador.nombreClinica = nombre;
                System.out.println("Se ha cambiado el nombre de la clinica exitosamente");
                //Código para cambiar el nombre de la clínica en los respectivos JSON!
            }
            else if (cambio.equals("2")) {
                System.out.println("Ingrese la nueva dirección de la clínica:");
                input.nextLine();
                String direccion = input.nextLine();
                clinicaCoordinador.direccion = direccion;
                System.out.println("Se ha cambiado la dirección de la clinica exitosamente");
                //Código para cambiar la dirección de la clínica en los respectivos JSON!
            }
            else if (cambio.equals("3")) {
                System.out.println("Ingrese el nuevo teléfono de la clínica:");
                int telefono = input.nextInt();
                clinicaCoordinador.telefono = telefono;
                System.out.println("Se ha cambiado el teléfono de la clinica exitosamente");
                //Código para cambiar el teléfono de la clínica en los respectivos JSON!
            }

            else if (cambio.equals("0")) {
                return;
            }
            else {
                System.out.println("Ha ingresado una opción inválida");
                continue;
            }
        }

    }

    public void borrarClinica() {
        Scanner input = new Scanner(System.in);
        handleDB db = new handleDB();
        ArrayList<Clinica> clinicas = db.getClinicas();
        ArrayList<CoordinadorDeClinica> coordinadores = db.getCoordinadores();


        while(true) {
            System.out.println("¿Está seguro que desea borrar la clínica?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            String borrar = input.next();
            if (!borrar.equals("1") && !borrar.equals("2")) {
                System.out.println("Ha ingresado una opción inválida");
                continue;
            }
            else if (borrar.equals("2")) {
                return;
            }
            else {
                break;
            }
        }


        System.out.println("Ingrese el NIT de la clínica a borrar: ");
        int nitDel = input.nextInt();
        System.out.println("Antes de borrar la clínica, debe trsladar los datos, bienes " +
                "y personas de esta clínica a otra clínica ");
        System.out.println("Ingrese el NIT de la clínica a la que quiere realizar el traslado: ");
        int nitTras = input.nextInt();
        Collections.sort(clinicas, ClinicSort.nitOrder);
        //sacar lista de clínicas del json y mostrarlas acá
        int indexDel = Collections.binarySearch(db.getClinicas(), new Clinica(nitDel, "cl", "dir", 123), ClinicSort.nitOrder);
        if (indexDel < 0) {
            System.out.println("La clínica a eliminar no se encuentra en la base de datos");
            return;
        }
        int indexTras = Collections.binarySearch(db.getClinicas(), new Clinica(nitTras, "cl", "dir", 123), ClinicSort.nitOrder);
        if (indexDel < 0) {
            System.out.println("La clínica a la que se trasladará la información no se encuentra en la base de datos");
            return;
        }


        for (Medicamento medicamento : db.getClinicas().get(indexDel).listaDeMedicamentos) {
            clinicas.get(indexTras).listaDeMedicamentos.add(medicamento);
        }

        for (Psiquiatra psiquiatra : db.getClinicas().get(indexDel).listaDePsiquiatras) {
            clinicas.get(indexTras).listaDePsiquiatras.add(psiquiatra);
        }

        db.getClinicas().remove(indexDel);
        System.out.println("Se ha realizado la transferencia de información exitosamente");
        System.out.println("Se ha eliminado la clínica");






    }

    public void registrarPsiquiatra() {
        Scanner input = new Scanner(System.in);

        //Pedir datos y validar los necesarios
        System.out.println("Ingrese el primer nombre (y segundo si tiene) del psiquiatra a registrar:");
        input.nextLine();
        String nombres = input.nextLine();

        System.out.println("Ingrese los apellidos del psiquiatra a registrar:");
        input.nextLine();
        String apellidos = input.nextLine();

        System.out.println("Ingrese el email del psiquiatra a registrar:");
        input.nextLine();
        String email = input.nextLine();

        System.out.println("Ingrese la contraseña del psiquiatra a registrar:");
        input.nextLine();
        String contrasena = input.nextLine();

        System.out.println("Ingrese el sexo del(de la) psiquiatra: ");
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
        input.nextLine();
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
        Scanner input = new Scanner(System.in);
        handleDB db = new handleDB();
        System.out.println("Para visualizar los medicamentos de la clínica, escoja respecto a cual" +
                " atributo los quiere que estén organizados: ");
        System.out.println("1. Nombre");
        System.out.println("2. Cantidad");
        String optcompa = input.next();



        if (optcompa.equals("1")) {
            Collections.sort(clinicaCoordinador.listaDeMedicamentos, new MedicamentoComparatorNombre());
        }
        else if (optcompa.equals("2")) {
            Collections.sort(clinicaCoordinador.listaDeMedicamentos, new MedicamentoComparatorCantidad());
        }
        else {
            System.out.println("Ingresó una opción inválida");
            return;
        }

        Medicamento med = new Medicamento();
        med.listarMedicamento(clinicaCoordinador);
        med.notificarCantidad(clinicaCoordinador);


        System.out.println("¿Qué desea hacer?");
        System.out.println("1. Agregar suministros de un medicamento existente");
        System.out.println("2. Agregar un medicamento nuevo");

        String optadd = input.next();
        if (optadd.equals("1")) {
            System.out.println("Ingrese el id del medicamento al que le desea aumentar la cantidad: ");
            int idMed = input.nextInt();
            if (idMed < 1 || idMed > clinicaCoordinador.listaDeMedicamentos.size()) {
                System.out.println("Ha ingresado un numero fuera del rango de medicamentos disponibles");
                return;
            }

            for (int i = 0; i < clinicaCoordinador.listaDeMedicamentos.size(); i++) {
                if (clinicaCoordinador.listaDeMedicamentos.get(i).idMedicamento == idMed) {
                    idMed = i;
                    break;
                }
            }

            System.out.println("Ingrese la cantidad de unidades a agregar al medicamento " +
                    clinicaCoordinador.listaDeMedicamentos.get(idMed).nombreMedicamento);
            int cantidadSum = input.nextInt();
            if (cantidadSum < 1) {
                System.out.println("Tiene que ingresar como mínimo una unidad");
                return;
            }

            clinicaCoordinador.listaDeMedicamentos.get(idMed).cantidadDisponible += cantidadSum;
            for (int i = 0; i < db.getClinicas().size(); i++) {
                if (db.getClinicas().get(i).nit == clinicaCoordinador.nit) {
                    for (int j = 0; j < db.getClinicas().get(i).listaDeMedicamentos.size(); j++) {
                        if (db.getClinicas().get(i).listaDeMedicamentos.get(j).idMedicamento == idMed) {
                            db.getClinicas().get(i).listaDeMedicamentos.get(j).cantidadDisponible += cantidadSum;
                            break;
                        }
                    }
                    break;
                }
            }
            System.out.println("Se ha suministrado el medicamento al inventario exitosamente");
            //Actualizar el medicamento modificado a la lista de medicamentos general (la que está en sistema de gestión)


        }
        else if (optadd.equals("2")) {
            System.out.println("Ingrese el nombre del medicamento a adicionar al inventario: ");
            input.nextLine();
            String nombre = input.nextLine();

            System.out.println("Ingrese la cantidad de unidades disponibles del medicamento: ");
            int cantidad = input.nextInt();
            if (cantidad < 1) {
                System.out.println("La cantidad debe ser igual o mayor a una unidad");
                return;
            }

            int id = clinicaCoordinador.listaDeMedicamentos.size() + 1;
            int nitClinicaMed = clinicaCoordinador.nit;


            Medicamento nuevoMedicamento = new Medicamento(id, nombre, cantidad, nitClinicaMed);
            clinicaCoordinador.listaDeMedicamentos.add(nuevoMedicamento);

            //Agregar el medicamento creado a la lista de medicamentos general (la que está en sistema de gestión)
            db.getMedicamentos().add(nuevoMedicamento);

            //Agregar el medicamento al json de clinicas
//            for (int i = 0; i < db.getClinicas().size(); i++) {
//                if (db.getClinicas().get(i).nit == clinicaCoordinador.nit) {
//                    db.getClinicas().get(i).listaDeMedicamentos.add(nuevoMedicamento);
//                }
//
//            }

            System.out.println("Medicamento creado e ingresado a inventario con éxito");

        }
        else {
            System.out.println("Ingresó una opción inválida");
            return;
        }
    }

    public void borrarMedicamento() {
        handleDB db = new handleDB();
        Scanner input = new Scanner(System.in);
        Medicamento med = new Medicamento();
        med.listarMedicamento(clinicaCoordinador);


        System.out.println("Ingrese el id del medicamento que desea eliminar: ");
        int idMedDel = input.nextInt();
        while (idMedDel < 0) {
            System.out.println("Ha ingresado un id negativo, intente de nuevo");
            idMedDel = input.nextInt();
        }

        for (int i = 0; i < db.getMedicamentos().size(); i++) {
            if (db.getMedicamentos().get(i).idMedicamento == idMedDel) {
                db.getMedicamentos().remove(i);
                for (int j = 0; j < clinicaCoordinador.listaDeMedicamentos.size(); j++) {
                    if (clinicaCoordinador.listaDeMedicamentos.get(j).idMedicamento == idMedDel) {
                        clinicaCoordinador.listaDeMedicamentos.remove(j);
                    }
                }
                System.out.println("Se ha eliminado el medicamento exitosamente");
                break;
            }
            else {
                System.out.println("No se encontró ningún medicamento con el id " + idMedDel);
            }
        }

    }

    @Override
    public String toString() {
        return "{" + "\n" +
                " emailCoordinador : " + emailCoordinador + "," + "\n" +
                " contrasenaCoordinador : " + contrasenaCoordinador + "," + "\n" +
                " clinicaCoordinador : " + clinicaCoordinador.nombreClinica + "," + "\n" +
                "}";
    }

}



