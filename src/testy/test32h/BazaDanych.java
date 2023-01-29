package testy.test32h;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BazaDanych {
    public static List<Pacjent> pacjentList = new ArrayList<>();
    public static List<Lekarz> lekarzList = new ArrayList<>();
    public static List<Wizyta> wizytaList = new ArrayList<>();

    public static void odczytZPlikuWizyt(String plik) {
        try (BufferedReader br = new BufferedReader(new FileReader(plik))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String data[] = line.split("\t");
                Lekarz lekarz = lekarzPoId(Integer.parseInt(data[0]));
                Pacjent pacjent = pacjentPoId(Integer.parseInt(data[1]));
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d");
                LocalDate dataWizyty = LocalDate.parse(data[2], dtf);
                wizytaList.add(new Wizyta(lekarz, pacjent, dataWizyty));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Dany plik nie istnieje");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podaczas wczytywania pliku!");
        }
    }

    public static void odczytZPlikuPacjenci(String plik) {
        try (BufferedReader br = new BufferedReader(new FileReader(plik))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String dane[] = line.split("\t");
                int idPacjenta = Integer.parseInt(dane[0]);
                String nazwisko = dane[1];
                String imie = dane[2];
                String pesel = dane[3];
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d");
                LocalDate dataUrodzenia = LocalDate.parse(dane[4], dtf);
                pacjentList.add(new Pacjent(idPacjenta, nazwisko, imie, pesel, dataUrodzenia));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Dany plik nie istnieje");
        } catch (IOException e) {
            System.out.println("Wysąpił błąd podczas wczytywania pliku!");
        }
    }

    public static void odczytZPlikuLekarze(String plik) {
        try (BufferedReader br = new BufferedReader(new FileReader(plik))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] dane = line.split("\t");
                int idLekarza = Integer.parseInt(dane[0]);
                String nazwisko = dane[1];
                String imie = dane[2];
                Specjalizacja specjalizacja = Specjalizacja.valueOf(dane[3].toUpperCase());
                LocalDate dataUrodzenia = LocalDate.parse(dane[4]);
                String NIP = dane[5];
                String PESEL = dane[6];
                Lekarz lekarz = new Lekarz(idLekarza, nazwisko, imie, specjalizacja, dataUrodzenia, NIP, PESEL);
                lekarzList.add(lekarz);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Dany plik nie istnieje");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas wczytywania pliku!");
        }
    }

    public static Lekarz lekarzPoId(int id) {
        Lekarz lekarz = lekarzList.get(0);
        for (Lekarz l : lekarzList) {
            if (l.getIdLekarza() == id) {
                lekarz = l;
            }
        }
        return lekarz;
    }

    public static Pacjent pacjentPoId(int id) {
        Pacjent pacjent = pacjentList.get(0);
        for (Pacjent p : pacjentList) {
            if (p.getIdPacjenta() == id) {
                pacjent = p;
            }
        }
        return pacjent;
    }
}
