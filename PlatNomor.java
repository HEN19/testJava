import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PlatNomor {

    private static final String KOTA_JAKARTA = "B ";
    private static final String KOTA_BOGOR = "F ";

    public static void main(String[] args) {
        try {
            // Create threads for Jakarta and Bogor
            Thread threadJakarta = createThread(KOTA_JAKARTA, "jakarta.txt");
            Thread threadBogor = createThread(KOTA_BOGOR, "bogor.txt");

            // Start both threads
            threadJakarta.start();
            threadBogor.start();

            // Wait for both threads to finish
            threadJakarta.join();
            threadBogor.join();

            System.out.println("Plat nomor generated successfully!");
        } catch (IOException e) {
            System.err.println("Error creating files: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }
    }

    private static Thread createThread(String kota, String filename) throws IOException {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Create file for this city's license plates
                    File file = new File(filename);
                    FileWriter writer = new FileWriter(file);

                    // Generate and write license plates
                    for (int i = 1; i <= 9999; i++) {
                        String platNomor = kota + i +" "+generateDuaHuruf();
                        writer.write(platNomor + "\n");
                    }

                    writer.close();
                } catch (IOException e) {
                    System.err.println("Error writing to file " + filename + ": " + e.getMessage());
                }
            }
        });
    }

    private static String generateDuaHuruf() {
        // Generate two random letters
        String[] huruf = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        return huruf[new Random().nextInt(huruf.length)] + huruf[new Random().nextInt(huruf.length)];
    }
}
