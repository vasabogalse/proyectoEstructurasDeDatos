import java.util.ArrayList;

public class SistemaDeGestionClinica {
    public static ArrayList<Clinica> clinicas = new ArrayList<>();
    public static ArrayList<String> psiquiatras = new ArrayList<>();
    public static ArrayList<String> pacientes = new ArrayList<>();
    public static void main(String[] args) {

        // create objects
        Clinica clinica1 = new Clinica(1, "eps", "dir", 123456);
        Clinica clinica2 = new Clinica(2, "eps2", "dir2", 879034);
        Clinica clinica3 = new Clinica(3, "eps3", "dir3", 1011121);
        Clinica clinica4 = new Clinica(4, "eps4", "dir4", 7865744);

        Clinica cl = new Clinica(); // create an object from the class require

        //Add objects to an array
        clinicas.add(clinica1);
        clinicas.add(clinica2);
        clinicas.add(clinica3);
        clinicas.add(clinica4);

        cl.writeJSON(clinicas, "clinicas"); // serialization of objects
        // single Obj Ex: String obj2 = clinica2.writeJSON(clinica1,"user2");

        ArrayList<Clinica> clinics = cl.readJSON(Clinica.class,"clinicas"); // deserialization of JSON file (read file)
    }
}
