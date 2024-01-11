import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TranspositionNameScrambler {

    private static final List<String> listNama = new ArrayList<>();

    static {
        listNama.add("Budi Santoso");
        listNama.add("Anita Wijaya");
        listNama.add("Rudi Setiawan");
        listNama.add("Sinta Putri");
        listNama.add("Agus Kurniawan");
        listNama.add("Dewi Ayu");
        listNama.add("Eko Prasetyo");
        listNama.add("Linda Susanti");
        listNama.add("Hendra Wijaya");
        listNama.add("Rina Maulida");
    }

    public static String acakNama(String nama) {
        List<Character> characters = new ArrayList<>();
        for (char c : nama.toCharArray()) {
            characters.add(c);
        }

        Collections.shuffle(characters);

        StringBuilder result = new StringBuilder();
        for (char c : characters) {
            result.append(c);
        }

        return result.toString();
    }

    public static String menterjemahkanNama(String namaAcak, List<String> daftarNama) {
        for (String nama : daftarNama) {
            if (sama(namaAcak, acakNama(nama))) {
                return nama;
            }
        }
        return "Tidak ditemukan";
    }

    private static boolean sama(String namaAcak, String namaAcakBaru) {
        if (namaAcak.length() != namaAcakBaru.length()) {
            return false;
        }

        int[] frequency = new int[256];  // Assuming ASCII characters

        for (char c : namaAcak.toCharArray()) {
            frequency[c]++;
        }

        for (char c : namaAcakBaru.toCharArray()) {
            if (frequency[c] == 0) {
                return false;
            }
            frequency[c]--;
        }

        return true;
    }

    public static void main(String[] args) {
        // Pilih nama dari list secara acak
        String namaAsli = listNama.get((int) (Math.random() * listNama.size()));
        System.out.println("Nama Asli: " + namaAsli);

        // Mengacak nama
        String namaAcak = acakNama(namaAsli);
        System.out.println("Nama Acak: " + namaAcak);

        // Menterjemahkan nama dengan menggunakan listNama
        String namaKembali = menterjemahkanNama(namaAcak, listNama);
        System.out.println("Nama Kembali: " + namaKembali);
    }
}
