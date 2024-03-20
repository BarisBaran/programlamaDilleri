import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] ozne = {"Ben", "Sen", "Hasan", "Nursah", "Elif", "Abdulrezzak", "Sehribanu", "Zeynelabidin", "Naki"};
        String[] nesne = {"Bahce", "Okul", "Park", "Sinif", "Yarin", "Pazartesi", "Sali", "Carsamba", "Persembe", "Cuma",
                "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Gunes", "Beydagi"};
        String[] yuklem = {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yurumek", "Gormek"};

        System.out.println("Cumleyi giriniz:");
        String cumle = scanner.nextLine();

        String[] kelimeler = cumle.split("\\s+");

        if (kelimeler.length < 3) {
            System.out.println("Cumle eksik bilgi iceriyor. Lutfen gecerli bir cumle giriniz.");
            return;
        }

        boolean ozneVar = false;
        boolean nesneVar = false;
        boolean yuklemVar = false;

        for (String kelime : kelimeler) {
            if (!ozneVar) {
                ozneVar = iceriyormu(ozne, kelime);
            }
            if (!nesneVar) {
                nesneVar = iceriyormu(nesne, kelime);
            }
            if (!yuklemVar) {
                yuklemVar = iceriyormu(yuklem, kelime);
            }
        }

        if (ozneVar && nesneVar && yuklemVar) {
            System.out.println("Girilen cumle gecerli bir cumledir.");
        } else {
            System.out.println("Girilen cumle gecerli bir cumle degildir.");
        }
    }

    public static boolean iceriyormu(String[] dizi, String anahtar) {
        for (String eleman : dizi) {
            if (eleman.equalsIgnoreCase(anahtar)) {
                return true;
            }
        }
        return false;
    }
}
