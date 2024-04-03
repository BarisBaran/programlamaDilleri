import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class BagliListeElemani {
    int veri;
    BagliListeElemani next;

    BagliListeElemani(int v) {
        veri = v;
        next = null;
    }
}

public class BagliListe {
    private BagliListeElemani bas;

    public BagliListe() {
        bas = null;
    }

    public void ekle(int veri) {
        BagliListeElemani yeniEleman = new BagliListeElemani(veri);
        if (bas == null) {
            bas = yeniEleman;
        } else {
            BagliListeElemani temp = bas;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = yeniEleman;
        }
    }

    public void sirala() {
        BagliListeElemani mevcut = bas;
        BagliListeElemani index = null;
        int gecici;

        if (bas == null) {
            return;
        } else {
            while (mevcut != null) {
                index = mevcut.next;

                while (index != null) {
                    if (mevcut.veri > index.veri) {
                        gecici = mevcut.veri;
                        mevcut.veri = index.veri;
                        index.veri = gecici;
                    }
                    index = index.next;
                }
                mevcut = mevcut.next;
            }
        }
    }

    public void yazdir() {
        BagliListeElemani gecici = bas;
        while (gecici != null) {
            System.out.print(gecici.veri + " ");
            gecici = gecici.next;
        }
    }

    public static void main(String[] args) {
        BagliListe liste = new BagliListe();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Dosya adını girin: ");
        String dosyaAdi = scanner.nextLine();

        try {
            BufferedReader okuyucu = new BufferedReader(new FileReader(dosyaAdi));
            String satir;

            while ((satir = okuyucu.readLine()) != null) {
                int sayi = Integer.parseInt(satir);
                liste.ekle(sayi);
            }
            okuyucu.close();
        } catch (IOException e) {
            System.out.println("Dosya okuma hatasi: " + e.getMessage());
        }

        liste.sirala();
        liste.yazdir();
        scanner.close();
    }
}
