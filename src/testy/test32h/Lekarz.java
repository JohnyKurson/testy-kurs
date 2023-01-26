package testy.test32h;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lekarz extends Osoba {

    private int idLekarza;
    private String nip;
    private Specjalizacja specjalizacja;
    private List<Wizyta> listaWizyt = new ArrayList<>();

    public Lekarz(int idLekarza, String nazwisko, String imie, Specjalizacja specjalizacja, LocalDate dataUrodzenia, String nip, String pesel) {
        super(nazwisko, imie, pesel, dataUrodzenia);
        this.idLekarza = idLekarza;
        this.nip = nip;
        this.specjalizacja = specjalizacja;
    }


    public List<Wizyta> getListaWizyt() {
        return listaWizyt;
    }

    public void setListaWizyt(List<Wizyta> listaWizyt) {
        this.listaWizyt = listaWizyt;
    }

    public int getIdLekarza() {
        return idLekarza;
    }

    public void setIdLekarza(int idLekarza) {
        this.idLekarza = idLekarza;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Specjalizacja getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(Specjalizacja specjalizacja) {
        this.specjalizacja = specjalizacja;
    }


    @Override
    public String toString() {
        return "Lekarz{" +
                "idLekarza:" + getIdLekarza() +
                ", Nazwisko:" + getNazwisko() +
                ", Imie:" + getImie() +
                ", Pesel:" + getPesel() +
                ", Data Urodzenia:" + getDataUrodzenia() +
                ", NIP:" + getNip() +
                ", Specjalizacja:" + getSpecjalizacja() + "}\n";

    }
}

