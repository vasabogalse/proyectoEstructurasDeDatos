import java.util.Comparator;

public class MedicamentoComparatorCantidad implements Comparator<Medicamento> {
    @Override

    public int compare(Medicamento medicamento1, Medicamento medicamento2) {
        if (medicamento1.cantidadDisponible < medicamento2.cantidadDisponible) {
            return -1;
        }
        else if (medicamento1.cantidadDisponible == medicamento2.cantidadDisponible) {
            return 0;
        }
        else {
            return 1;
        }
    }
}