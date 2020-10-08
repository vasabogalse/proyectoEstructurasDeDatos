import java.util.Comparator;

public class ClinicSort{
    static final Comparator<Clinica> nitOrder = new Comparator<Clinica>() {
        public int compare(Clinica c1, Clinica c2) {
            if(c1.nit < c2.nit){
                return -1;
            } else if(c1.getNit() == c2.getNit()){
                return 0;
            } else {
                return 1;
            }
        }
    };

    static final Comparator<Clinica> clinicNameOrder = new Comparator<Clinica>() {
        @Override
        public int compare(Clinica c1, Clinica c2) {
            return c1.nombreClinica.compareTo(c2.nombreClinica);
        }
    };

    //static final Comparator<Clinica> directionOrder = new Comparator<Clinica>() {
       /* @Override
        public int compare(Clinica c1, Clinica c2) {
            return c1.direccion.compareTo(c2.direccion);
        }*/
        Comparator<Clinica> dirOrder = (Clinica o1, Clinica o2) -> {return o1.direccion.compareTo(o2.direccion);};
   // };

    static final Comparator<Clinica> telOrder = new Comparator<Clinica>() {
        @Override
        public int compare(Clinica c1, Clinica c2) {
            if(c1.telefono < c2.telefono){
                return -1;
            } else if(c1.telefono == c2.telefono){
                return 0;
            } else {
                return 1;
            }
        }
    };

    static final Comparator<Paciente> idOrderPaciente = new Comparator<Paciente>() {
        @Override
        public int compare(Paciente p1, Paciente p2) {
            if(p1.idPaciente < p2.idPaciente){
                return -1;
            } else if(p1.idPaciente == p2.idPaciente){
                return 0;
            } else {
                return 1;
            }
        }
    };

    static final Comparator<Psiquiatra> idOrderPsiquiatra = new Comparator<Psiquiatra>() {
        @Override
        public int compare(Psiquiatra p1, Psiquiatra p2) {
            if(p1.getIdPsiquiatra() < p2.getIdPsiquiatra()){
                return -1;
            } else if(p1.getIdPsiquiatra() == p2.getIdPsiquiatra()){
                return 0;
            } else {
                return 1;
            }
        }
    };

    static final Comparator<CoordinadorDeClinica> idOrderPCoordinador = new Comparator<CoordinadorDeClinica>() {
        @Override
        public int compare(CoordinadorDeClinica c1, CoordinadorDeClinica c2) {
            if(c1.getCedulaCoordinador()< c2.getCedulaCoordinador()){
                return -1;
            } else if(c1.getCedulaCoordinador() == c2.getCedulaCoordinador()){
                return 0;
            } else {
                return 1;
            }
        }
    };
}
