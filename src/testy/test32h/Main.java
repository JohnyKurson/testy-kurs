package testy.test32h;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        BazaDanych.odczytZPlikuLekarze("src/testy/test32h/lekarze.txt");
        BazaDanych.odczytZPlikuPacjenci("src/testy/test32h/pacjenci.txt");
        BazaDanych.odczytZPlikuWizyt("src/testy/test32h/wizyty.txt");

        System.out.println("Lekarz z największą ilością wizyt:\n" + lekarzZNajwiekszaIlosciaWizyt());

        System.out.println("Pacjent z największą ilością wizyt:\n" + pacjentZNajwiekszaIlosciaWizyt() + "\n");

        System.out.println("Specjaizacja z największym powodzeniem:\n" + specjalizacjaZNajwiekszymPowodzeniem() + "\n");
        System.out.println("test" + specjalizacjaZNajwiekszymPowodzeniem());

        System.out.println("Rok w którym było najwięcej wizyt:\n" + najwiecejWizytWRoku() + "\n");

        System.out.println("Top 5 najstarszych lekarzy: \n" + top5NajstarszychLekarzy() + "\n");

        System.out.println("Pacjenci którzy byli u 5 różnych lekarzy:");
        System.out.println(pacjenciU5Lekarzy());

        System.out.println("Lekarze którzy przyjmowali tylko jednego pacjenta:");
        System.out.println(lekarzeExclusive());


    }

    public static Lekarz lekarzZNajwiekszaIlosciaWizyt() {
        List<Lekarz> lekarzList = BazaDanych.lekarzList;
        Lekarz lekarz = lekarzList.get(0);
        for (Lekarz l : lekarzList) {
            if (l.getListaWizyt().size() > lekarz.getListaWizyt().size()) {
                lekarz = l;
            }
        }
        return lekarz;
    }

    public static List<Pacjent> pacjentZNajwiekszaIlosciaWizyt() {
        List<Pacjent> listaPacjentow = BazaDanych.pacjentList;
        List<Pacjent> result = new ArrayList<>();
        Pacjent pacjent = listaPacjentow.get(0);
        for (Pacjent p : listaPacjentow) {
            if (p.getListaWizyt().size() > pacjent.getListaWizyt().size()) {
                pacjent = p;
                result.clear();
                result.add(pacjent);
            } else if (p.getListaWizyt().size() == pacjent.getListaWizyt().size()) {
                result.add(p);
            }
        }
        return result;
    }

    public static List<Lekarz> top5NajstarszychLekarzy() {
        List<Lekarz> lekarze = BazaDanych.lekarzList;
        List<Lekarz> result = new ArrayList<>();
        for (Lekarz lekarz : lekarze) {
            if (result.size() < 5) {
                result.add(lekarz);
            } else {
                Lekarz lekarz2 = result.get(0);
                for (Lekarz l : result) {
                    if (l.getDataUrodzenia().isAfter(lekarz2.getDataUrodzenia()))
                        lekarz2 = l;
                }
                if (lekarz.getDataUrodzenia().isBefore(lekarz2.getDataUrodzenia())) {
                    result.remove(lekarz2);
                    result.add(lekarz);
                }
            }
        }
        return result;
    }

    public static List<Lekarz> lekarzeExclusive() {
        List<Lekarz> lekarze = BazaDanych.lekarzList;
        List<Lekarz> result = new ArrayList<>();
        for (Lekarz lekarz : lekarze) {
            int iloscLekarzyNaPacjenta = 0;
            for (Wizyta wizyta : lekarz.getListaWizyt()) {
                iloscLekarzyNaPacjenta += wizyta.getPacjent().getIloscLekarzy();
            }
            if (iloscLekarzyNaPacjenta == 1) {
                result.add(lekarz);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Nie ma takiego lekarza");
        }
        return result;
    }


    public static Specjalizacja specjalizacjaZNajwiekszymPowodzeniem() {
        Map<Specjalizacja, Integer> liczbaWizytWSpecjalizacji = new HashMap<>();
        for (Lekarz lekarz : BazaDanych.lekarzList) {
            Specjalizacja specjalizacja = lekarz.getSpecjalizacja();
            int liczbaWizyt = lekarz.getListaWizyt().size();
            if (liczbaWizytWSpecjalizacji.containsKey(specjalizacja)) {
                liczbaWizytWSpecjalizacji.put(specjalizacja, liczbaWizytWSpecjalizacji.get(specjalizacja) + liczbaWizyt);
            } else {
                liczbaWizytWSpecjalizacji.put(specjalizacja, liczbaWizyt);
            }
        }
        Specjalizacja specjalizacjaZNajwiekszymPowodzeniem = null;
        int maxLiczbaWizyt = 0;
        for (Map.Entry<Specjalizacja, Integer> entry : liczbaWizytWSpecjalizacji.entrySet()) {
            if (entry.getValue() > maxLiczbaWizyt) {
                maxLiczbaWizyt = entry.getValue();
                specjalizacjaZNajwiekszymPowodzeniem = entry.getKey();
            }
        }
        return specjalizacjaZNajwiekszymPowodzeniem;
    }




    public static int najwiecejWizytWRoku() {
        List<Wizyta> list = BazaDanych.wizytaList;
        Map<Integer, Integer> liczbaWizytWRoku = new HashMap<>();
        for (Wizyta wizyta : list) {
            LocalDate dataWizyty = wizyta.getDataWizyty();
            int rokWizyty = dataWizyty.getYear();
            if (liczbaWizytWRoku.containsKey(rokWizyty)) {
                liczbaWizytWRoku.put(rokWizyty, liczbaWizytWRoku.get(rokWizyty) + 1);
            } else {
                liczbaWizytWRoku.put(rokWizyty, 1);
            }
        }
        int rokZNajwiekszaLiczbaWizyt = 0;
        int maxLiczbaWizyt = 0;
        for (Map.Entry<Integer, Integer> entry : liczbaWizytWRoku.entrySet()) {
            if (entry.getValue() > maxLiczbaWizyt) {
                maxLiczbaWizyt = entry.getValue();
                rokZNajwiekszaLiczbaWizyt = entry.getKey();
            }
        }
        return rokZNajwiekszaLiczbaWizyt;
    }

    public static List<Pacjent> pacjenciU5Lekarzy() {
        List<Lekarz> lekarze = BazaDanych.lekarzList;
        List<Pacjent> pacjenci5Lekarzy = new ArrayList<>();
        for (Lekarz lekarz : lekarze) {
            for (Wizyta wizyta : lekarz.getListaWizyt()) {
                Pacjent pacjent = wizyta.getPacjent();
                if (!pacjenci5Lekarzy.contains(pacjent) && pacjent.liczbaWizytULekarza() >= 5) {
                    pacjenci5Lekarzy.add(pacjent);
                }
            }
        }
        if (pacjenci5Lekarzy.isEmpty()) {
            System.out.println("Nie ma pacjenów którzy byli u 5 lekarzy");
        }
        return pacjenci5Lekarzy;
    }
}
