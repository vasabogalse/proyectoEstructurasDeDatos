import java.util.Comparator;

public class MedicamentoComparatorNombre implements Comparator<Medicamento> {
    @Override

    public int compare(Medicamento medicamento1, Medicamento medicamento2) {
        String nM1 = medicamento1.nombreMedicamento;
        String nM2 = medicamento2.nombreMedicamento;

        if (nM1.compareTo(nM2) < 0) {
            return -1;
        }
        else if (nM1.equals(nM2)) {
            return 0;
        }
        else {
            return 1;
        }
    }
}