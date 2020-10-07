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
}
