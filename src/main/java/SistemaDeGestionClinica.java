import java.util.ArrayList;

public class SistemaDeGestionClinica {
    public static ArrayList<String> clinicas = new ArrayList<>();

    public static void main(String[] args) {
        Clinica clinica1 = new Clinica(1,"eps","dir",123456);
        Clinica clinica2 = new Clinica(1,"eps","dir2",123456);
        String obj = clinica1.writeJSON(clinica1,"user2");
        String obj2 = clinica2.writeJSON(clinica1,"user2");
        System.out.println(obj);
        System.out.println(obj2);
        clinicas.add(obj);
    }
    public void readJsonFile(){

    }
}
