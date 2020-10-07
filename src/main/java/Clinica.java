import sun.java2d.SurfaceDataProxy;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Comparator;

public class Clinica extends handleDB {
    public int nit;
    public String nombreClinica;
    public String direccion;
    public int telefono;
    public CoordinadorDeClinica coordinadorDeClinica;
    public ArrayList<Medicamento> listaDeMedicamentos;
    public ArrayList<Psiquiatra> listaDePsiquiatras;

    public Clinica(){
    }

    public Clinica(int nit, String nombreClinica, String direccion, int telefono) {
        this.nit = nit;
        this.nombreClinica = nombreClinica;
        this.direccion = direccion;
        this.telefono = telefono;
        this.coordinadorDeClinica = coordinadorDeClinica;
        this.listaDeMedicamentos = new ArrayList<>();
        this.listaDePsiquiatras = new ArrayList<>();
    }

    public Clinica(int nit, String nombreClinica, String direccion, int telefono, ArrayList<Medicamento> listaDeMedicamentos, ArrayList<Psiquiatra> listaDePsiquiatras) {
        this.nit = nit;
        this.nombreClinica = nombreClinica;
        this.direccion = direccion;
        this.telefono = telefono;
        this.coordinadorDeClinica = coordinadorDeClinica;
        this.listaDeMedicamentos = listaDeMedicamentos;
        this.listaDePsiquiatras = listaDePsiquiatras;
    }

    public int getNit() { return nit; }

    @Override
    public String toString() {
        return "{" + "\n" +
                " nit : " + nit + "," + "\n" +
                " nombreClinica : " + nombreClinica + "," + "\n" +
                " direccion : " + direccion + "," + "\n" +
                " telefono : " + telefono + "\n" +
                '}';
    }

    public static void listarClinicas(){
        Scanner sc = new Scanner(System.in);
        handleDB db = new handleDB();
        String optClinica = " ";
        while(true){
            System.out.println("Listado de clínicas");
            System.out.println("-------------------------------");
            System.out.println("Seleccione una categoría de listado:");
            System.out.println("1. Listar por nit");
            System.out.println("2. Listar por nombre");
            System.out.println("3. Listar por dirección");
            System.out.println("4. Listar por teléfono");
            System.out.println("5. Listar por psiquiatras");
            System.out.println("6. Listar por medicamentos");
            optClinica = sc.next();
            if(optClinica.equals("1")){
                // ordenarListaNit
            } else if(optClinica.equals("2")){
                //ordenarLista
            } else if(optClinica.equals("3")){
                //ordenarLista
            }
        }
        //System.out.println("Listado de las Clínicas existentes:");
        //System.out.println("---------------------------------------------");
        //System.out.println(db.clinicas);
        //int i = 0;
        //for(Clinica clinica : db.getClinicas()){
          //  System.out.println((i+1) + ". " + clinica);
            //i++;
       // }
    }
}
