import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class SistemaDeGestionClinica {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Clinica> clinicas = new ArrayList<>();
    public static ArrayList<Psiquiatra> psiquiatras = new ArrayList<>();
    public static ArrayList<String> pacientes = new ArrayList<>();
    public static ArrayList<Medicamento> medicamentos = new ArrayList<>();
    public static ArrayList<CoordinadorDeClinica> coordinadores = new ArrayList<>();

    public static void main(String[] args) {
        handleDB db = new handleDB();
        db.readAllJSON();

//        Clinica cl = new Clinica(); // create an object from the class require
//        clinicas = cl.readJSON(Clinica.class,"clinicas"); // deserialization of JSON file (read file)
//
//        Medicamento med = new Medicamento();
//        medicamentos = med.readJSON(Medicamento.class, "medicamentos");
//
//        CoordinadorDeClinica coord = new CoordinadorDeClinica();
//        coordinadores = coord.readJSON(CoordinadorDeClinica.class, "coordinadores");

        System.out.println("---------------------------------------");

        coordinadores.get(0).clinicaCoordinador = clinicas.get(0);
        coordinadores.get(1).clinicaCoordinador = clinicas.get(1);
        coordinadores.get(2).clinicaCoordinador = clinicas.get(2);
        coordinadores.get(3).clinicaCoordinador = clinicas.get(3);

//        coord.writeJSON(coordinadores, "coordinadores");



        clinicas.get(0).coordinadorDeClinica = coordinadores.get(0);
        clinicas.get(1).coordinadorDeClinica = coordinadores.get(1);
        clinicas.get(2).coordinadorDeClinica = coordinadores.get(2);
        clinicas.get(3).coordinadorDeClinica = coordinadores.get(3);

        System.out.println(clinicas.get(0));
//        cl.writeJSON(clinicas, "clinicas");





//        Clinica clAux = clinicas.get(0);
//        clAux.coordinadorDeClinica = coordinadores.get(0);
//        System.out.println(clAux.coordinadorDeClinica);
//        System.out.println(clinicas.get(0).coordinadorDeClinica);
//        System.out.println(clinicas.get(1).coordinadorDeClinica);
//        clinicas.get(1).coordinadorDeClinica = coordinadores.get(0);
//        System.out.println(clinicas.get(1).coordinadorDeClinica);




//
//        clinicas.get(0).listaDeMedicamentos.add(medicamentos.get(0));
//        clinicas.get(0).listaDeMedicamentos.add(medicamentos.get(1));
//        clinicas.get(1).listaDeMedicamentos.add(medicamentos.get(3));
//        clinicas.get(2).listaDeMedicamentos.add(medicamentos.get(4));
//        clinicas.get(3).listaDeMedicamentos.add(medicamentos.get(2));
//        clinicas.get(3).listaDeMedicamentos.add(medicamentos.get(1));






//        Clinica cl = new Clinica(); // create an object from the class require
//        clinicas = cl.readJSON(Clinica.class,"clinicas"); // deserialization of JSON file (read file)
//
//        Medicamento med = new Medicamento();
//        medicamentos = med.readJSON(Medicamento.class, "medicamentos");
//
//        CoordinadorDeClinica coord = new CoordinadorDeClinica();
//        coordinadores = coord.readJSON(CoordinadorDeClinica.class, "coordinadores");













        // create objects
        /*Clinica clinica1 = new Clinica(1, "eps", "dir", 123456);
        Clinica clinica2 = new Clinica(2, "eps2", "dir2", 879034);
        Clinica clinica3 = new Clinica(3, "eps3", "dir3", 1011121);
        Clinica clinica4 = new Clinica(4, "eps4", "dir4", 7865744);

        //Add objects to an array
        clinicas.add(clinica1);
        clinicas.add(clinica2);
        clinicas.add(clinica3);
        clinicas.add(clinica4);*/

        //cl.writeJSON(clinicas, "clinicas"); // serialization of objects
        // single Obj Ex: String obj2 = clinica2.writeJSON(clinica1,"user2");


        /** Ordenamiento según atributos primarios de clase Clínica**/
        //Collections.sort(clinicas, ClinicSort.nitOrder);
        //System.out.println(clinicas);

        //Collections.sort(clinicas, ClinicSort.clinicNameOrder);
        //System.out.println(clinicas);

        //Collections.sort(clinicas, ClinicSort.directionOrder);
        //System.out.println(clinicas);

//        Collections.sort(clinicas, ClinicSort.telOrder);
//        System.out.println(clinicas);

        // menú de ingreso al sistema
        //String opcionIngreso;
  /*      while(true){
            System.out.println("1. Ingresar al sistema");
            System.out.println("2. Registrarse como paciente en el sistema");
            System.out.println("0. Salir");
            opcionIngreso = sc.next();
            if(opcionIngreso.equals("1")){
                //ingresarUsuario();
            } else if(opcionIngreso.equals("2")){
                //registrarUsuario();
            } else if(opcionIngreso.equals("0")){
                break;
            } else{
                System.out.println("\nValor ingresado incorrecto. Vuelve a intentarlo o presiona 0 para salir\n");
            }
        }

   */
    }

}
