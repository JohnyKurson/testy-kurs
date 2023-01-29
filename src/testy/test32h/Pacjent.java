package testy.test32h;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pacjent extends Osoba {
    private int idPacjenta;
    private List<Wizyta> listaWizyt = new ArrayList<>();

    public Pacjent(int idPacjenta, String nazwisko, String imie, String pesel, LocalDate dataUrodzenia) {
        super(nazwisko, imie, pesel, dataUrodzenia);
        this.idPacjenta = idPacjenta;
    }

    public int getIloscLekarzy() {
        List<Lekarz> lekarze = new ArrayList<>();
        for (Wizyta wizyta : getListaWizyt()) {
            Lekarz lekarz = wizyta.getLekarz();
            if (!lekarze.contains(lekarz)) {
                lekarze.add(lekarz);
            }
        }
        return lekarze.size();
    }


    public List<Wizyta> getListaWizyt() {
        return listaWizyt;
    }

    public void setListaWizyt(List<Wizyta> listaWizyt) {
        this.listaWizyt = listaWizyt;
    }

    public int getIdPacjenta() {
        return idPacjenta;
    }

    public void setIdPacjenta(int idPacjenta) {
        this.idPacjenta = idPacjenta;
    }


    @Override
    public String toString() {
        return "Pacjent{" +
                "idPacjenta=" + getIdPacjenta() +
                ", Nazwisko:" + getNazwisko() +
                ", Imie:" + getImie() +
                ", Pesel:" + getPesel() +
                ", Data Urodzenia:" + getDataUrodzenia() + "}\n";
    }
}

