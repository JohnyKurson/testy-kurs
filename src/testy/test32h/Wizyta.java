package testy.test32h;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Wizyta {
    private LocalDate dataWizyty;
    private Lekarz lekarz;
    private Pacjent pacjent;
    private static List<Wizyta> listaWizyt = new ArrayList<>();

    public Wizyta(Lekarz lekarz, Pacjent pacjent, LocalDate dataWizyty) {
        this.lekarz = lekarz;
        this.pacjent = pacjent;
        this.dataWizyty = dataWizyty;

        lekarz.getListaWizyt().add(this);
        pacjent.getListaWizyt().add(this);
    }

    public Lekarz getLekarz() {
        return lekarz;
    }

    public void setLekarz(Lekarz lekarz) {
        this.lekarz = lekarz;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    public LocalDate getDataWizyty() {
        return dataWizyty;
    }

    public void setDataWizyty(LocalDate dataWizyty) {
        this.dataWizyty = dataWizyty;
    }

    public static List<Wizyta> getListaWizyt() {
        return listaWizyt;
    }

    public static void setListaWizyt(List<Wizyta> listaWizyt) {
        Wizyta.listaWizyt = listaWizyt;
    }


    @Override
    public String toString() {
        return "Wizyta{" +
                "ID Lekarza:" + lekarz.getIdLekarza() +
                ", ID Pacjenta:" + pacjent.getIdPacjenta() +
                ", Data wizyty:" + dataWizyty +
                "}\n";
    }
}

