import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Clinica implements handleJSON{
    public int nit;
    public String nombreClinica;
    public String direccion;
    public int telefono;
    public String coordinadorDeClinica;
    public ArrayList<Medicamento> listaDeMedicamentos;
    public ArrayList<Psiquiatra> listaDePsiquiatras;

    handleDB db = new handleDB();
    Scanner input = new Scanner(System.in);

    public Clinica(){
    }

    public Clinica(int nit, String nombreClinica, String direccion, int telefono, ArrayList<Medicamento> listaDeMedicamentos, ArrayList<Psiquiatra> listaDePsiquiatras) {
        this.nit = nit;
        this.nombreClinica = nombreClinica;
        this.direccion = direccion;
        this.telefono = telefono;
        this.coordinadorDeClinica = coordinadorDeClinica;
        this.listaDeMedicamentos = new ArrayList<>();
        this.listaDePsiquiatras = new ArrayList<>();
    }

    public void setNit(int nit) { this.nit = nit; }
    public String getNombreClinica() { return nombreClinica; }
    public void setNombreClinica(String nombreClinica) { this.nombreClinica = nombreClinica; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }
    public String getCoordinadorDeClinica() { return coordinadorDeClinica; }
    public void setCoordinadorDeClinica(String coordinadorDeClinica) { this.coordinadorDeClinica = coordinadorDeClinica; }
    public ArrayList<Medicamento> getListaDeMedicamentos() { return listaDeMedicamentos; }
    public void setListaDeMedicamentos(ArrayList<Medicamento> listaDeMedicamentos) { this.listaDeMedicamentos = listaDeMedicamentos; }
    public ArrayList<Psiquiatra> getListaDePsiquiatras() { return listaDePsiquiatras; }
    public void setListaDePsiquiatras(ArrayList<Psiquiatra> listaDePsiquiatras) { this.listaDePsiquiatras = listaDePsiquiatras; }
    public int getNit() { return nit; }

    public void editarClinica(CoordinadorDeClinica coordinador) {
        int indexClinicaCoordinador = 0;
        for (int i = 0; i < db.getClinicas().size(); i++) {
            if (db.getClinicas().get(i).getNit() == coordinador.getClinicaCoordinador()) {
                indexClinicaCoordinador = i;
                break;
            }
        }
        String guardarCambio = "", nombre = "", direccion = "";
        int telefono = 0;
        while (true) {
            System.out.println("¿Qué campo de su clínica desea cambiar?");
            System.out.println("1. Nombre de clínica");
            System.out.println("2. Dirección");
            System.out.println("3. Teléfono");
            System.out.println("0. Regresar al menú principal");
            String cambio = input.next();
            if (cambio.equals("1")) {
                System.out.println("Ingrese el nuevo nombre de la clínica:");
                input.nextLine();
                nombre = input.nextLine();
                break;
            } else if (cambio.equals("2")) {
                System.out.println("Ingrese la nueva dirección de la clínica:");
                input.nextLine();
                direccion = input.nextLine();
                break;
            } else if (cambio.equals("3")) {
                System.out.println("Ingrese el nuevo teléfono de la clínica:");
                telefono = input.nextInt();
                break;
            } else if (cambio.equals("0")) {
                return;
            } else {
                System.out.println("Ha ingresado una opción inválida");
            }
            System.out.println("¿Desea cambiar guardar el cambio? Y/N: ");
            guardarCambio = input.next().toLowerCase();
            if(guardarCambio.equals("y")){
                switch (cambio) {
                    case "1":
                        for(int i = 0; i <= db.getClinicas().size(); i++){
                            if(db.getClinicas().get(i).getNit() == coordinador.getClinicaCoordinador()) {
                                db.getClinicas().get(i).setNombreClinica(nombre);
                                break;
                            }
                        }
                        System.out.println("Se ha cambiado el nombre de la clinica exitosamente");
                        break;
                    case "2":
                        for(int i = 0; i <= db.getClinicas().size(); i++){
                            if(db.getClinicas().get(i).getNit() == coordinador.getClinicaCoordinador()) {
                                db.getClinicas().get(i).setDireccion(direccion);
                                break;
                            }
                        }
                        System.out.println("Se ha cambiado la dirección de la clinica exitosamente");
                        break;
                    case "3":
                        for(int i = 0; i <= db.getClinicas().size(); i++){
                            if(db.getClinicas().get(i).getNit() == coordinador.getClinicaCoordinador()) {
                                db.getClinicas().get(i).setTelefono(telefono);
                                break;
                            }
                        }
                        System.out.println("Se ha cambiado el teléfono de la clinica exitosamente");
                        break;
                }
                db.appendArrayToJSON("clinicas");
            } else if(guardarCambio.equals("n")){
                System.out.println("Si no cierra el sistema puede guardar sus cambios en la opción 6 del menú principal");
                break;
            }
        }
    }
    ss
    @Override
    public String toString() {
        return "{" + "\n" +
                " nit : " + nit + "," + "\n" +
                " nombreClinica : " + nombreClinica + "," + "\n" +
                " direccion : " + direccion + "," + "\n" +
                " telefono : " + telefono + "\n" +
                '}';
    }
}
