import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class SistemaDeGestionClinica {
    public static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        handleDB db = new handleDB();
        db.readAllJSON();


        System.out.println("---------------------------------------");

        db.getCoordinadores().get(0).clinicaCoordinador = db.getClinicas().get(0);
        db.getCoordinadores().get(1).clinicaCoordinador = db.getClinicas().get(1);
        db.getCoordinadores().get(2).clinicaCoordinador = db.getClinicas().get(2);
        db.getCoordinadores().get(3).clinicaCoordinador = db.getClinicas().get(3);
        db.appendArrayToJSON("coordinadores");
        System.out.println(db.getCoordinadores().get(0));

        db.getClinicas().get(0).coordinadorDeClinica = db.getCoordinadores().get(0);
        db.getClinicas().get(1).coordinadorDeClinica = db.getCoordinadores().get(1);
        db.getClinicas().get(2).coordinadorDeClinica = db.getCoordinadores().get(2);
        db.getClinicas().get(3).coordinadorDeClinica = db.getCoordinadores().get(3);
        db.appendArrayToJSON("clinicas");
        System.out.println(db.getClinicas().get(0));


    }

}
