import java.util.ArrayList;

public class SistemaDeGestionClinica {
    public static ArrayList<Clinica> clinicas = new ArrayList<Clinica>();
    public static ArrayList<String> psiquiatras = new ArrayList<>();
    public static ArrayList<String> pacientes = new ArrayList<>();

    public static void main(String[] args) {

        //Write Java Objects to JSON files
        Clinica clinica1 = new Clinica(1,"eps","dir",123456);
        Clinica clinica2 = new Clinica(2,"eps2","dir2",879034);
        Clinica clinica3 = new Clinica(3,"eps3","dir3",1011121);
        Clinica clinica4 = new Clinica(4,"eps4","dir4",7865744);

        DataManagement cl = new DataManagement();
        clinicas.add(clinica1);
        clinicas.add(clinica2);
        clinicas.add(clinica3);
        clinicas.add(clinica4);

       cl.setClinicList(clinicas);

       //Method for write array into JSON
       cl.writeJSON(cl,"clinicas");




        /*Primeros intentos*
        String obj = clinica1.writeJSON(clinica1,"user2");
        String obj2 = clinica2.writeJSON(clinica1,"user2");
        System.out.println(obj);
        System.out.println(obj2);
        clinicas.add(obj);

        */

/*
        try {
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON array to list of books
            Path path = Paths.get(".", "src", "main","resources", "user.json");
            List<Clinica> clinicasDeJSON  = Arrays.asList(mapper.readValue(path.toFile(), Clinica[].class));

            clinicasDeJSON.forEach(System.out::println);

        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
    }
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
