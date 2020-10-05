import java.util.Comparator;

public class PsiquiatraSort{

    static final Comparator<Psiquiatra> Apellidos = new Comparator<Psiquiatra>() {
        @Override
        public int compare(Psiquiatra p1, Psiquiatra p2) {
            return p1.apellidos.compareTo(p2.apellidos);
        }
    };

    static final Comparator<Psiquiatra> NumPacientes = new Comparator<Psiquiatra>() {
        @Override
        public int compare(Psiquiatra p1, Psiquiatra p2) {

            if(p1.ListaPacientes.size() < p2.ListaPacientes.size()){
                return -1;
            } else if(p2.ListaPacientes.size() == p2.ListaPacientes.size()){
                return 0;
            } else {
                return 1;
            }
        }

    };
}
