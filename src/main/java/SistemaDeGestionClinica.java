import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        // create an object from the class require
        Clinica cl = new Clinica();

        //Add objects to an array
        clinicas.add(clinica1);
        clinicas.add(clinica2);
        clinicas.add(clinica3);
        clinicas.add(clinica4);

        //Method for write array into JSON file
        cl.writeJSON(clinicas, "clinicas");

        // single Obj Ex: String obj2 = clinica2.writeJSON(clinica1,"user2");

        // deserialization of JSON file (read file)
        ArrayList<Clinica> prueba = new ArrayList<>();
        ArrayList<Clinica> clinics = cl.readJSON("clinicas");

        System.out.println(prueba.toString());




        // serialization of JSON file from specific class
        /*try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON array to list of books
            Path path = Paths.get(".", "src", "main","resources", "clinicas.json");
            ArrayList<Clinica> myObjects = mapper.readValue(path.toFile(), new TypeReference<ArrayList<Clinica>>(){});
            System.out.println(myObjects.toString());

        } catch (Exception ex) {
            ex.printStackTrace();
        }





        //Read from JSON files and obtain a Java Object.
        /*try {
           Clinica cl2 = new Clinica();
           Path path = Paths.get(".", "src", "main","resources", "clinicas.json");
           cl2 = new ObjectMapper().readerFor(Clinica.class).readValue(path.toFile());
            System.out.println(cl2.getClass().getName());

           System.out.println(cl2.getClinicList().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/


        //List<MyClass> myObjects = mapper.readValue(jsonInput, new TypeReference<List<MyClass>>(){});



/*    public String readJsonFile(){
        List<Clinica> clinica2 = new ArrayList<>();
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON array to list of books
            Path path = Paths.get(".", "src", "main","resources", "user.json");
            clinica2 = Arrays.asList(mapper.readValue(path.toFile(), Clinica[].class));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return String.valueOf(clinica2);
    }*/
    }
}
