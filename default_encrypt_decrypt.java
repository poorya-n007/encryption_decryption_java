import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class default_encrypt_decrypt {
    Scanner input = new Scanner(System.in);
    String filename = "";
    String fileContents = "";
    String ALGORITHM = "AES";
    String PADDING_CHAR = "0";
    int KEY_LENGTH_BYTES = 16; // 128 bits\   
    public void encrypt() {     
        System.out.print("\n----------------------------------\n\nEnter your text : ");
        String text = input.nextLine();
        System.out.print("\n----------------------------------\n\nEnter your secret key : ");
        String SECRET_KEY = input.nextLine();
        if (SECRET_KEY.length() != KEY_LENGTH_BYTES) {
            if (SECRET_KEY.length() > KEY_LENGTH_BYTES) {
                SECRET_KEY = SECRET_KEY.substring(0, 15);
            }
            while (SECRET_KEY.length() < KEY_LENGTH_BYTES) {
                SECRET_KEY += PADDING_CHAR;
            }
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedBytes = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
            try {
                // Create a FileWriter object
                System.out.print("\nWhere save file encrypt text ? ");
                filename = input.nextLine();
                System.out.print("\nEnter a name of file = ");
                filename = filename+"\\" + input.nextLine();
                FileWriter write_decrypt = new FileWriter(filename);

                // Write the string to the file
                write_decrypt.write(Base64.getEncoder().encodeToString(encryptedBytes));

                // Close the writer
                write_decrypt.close();

                System.out.println("\nSuccessfully encrypted text saved\n\nyour Secret key for decrypt encrypted text : "+ SECRET_KEY +"\n----------------------------------");
            } catch (IOException e) {
                System.out.println("\nAn error occurred in save encrypted text.\n");
            }
        } catch (Exception e) {
            System.out.println("\nAn error occurred in encrypt text.\n");
        }
    }

    public void decrypt() {
        System.out.print("\nEnter path of your encrypted text file : ");
        filename = input.nextLine();
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filename));
            fileContents = new String(bytes);
            System.out.print("Enter your secret key : ");
            String SECRET_KEY = input.nextLine();
            if (SECRET_KEY.length() != KEY_LENGTH_BYTES) {
                if (SECRET_KEY.length() > KEY_LENGTH_BYTES) {
                    SECRET_KEY = SECRET_KEY.substring(0, 15);
                }
                while (SECRET_KEY.length() < KEY_LENGTH_BYTES) {
                    SECRET_KEY += PADDING_CHAR;
                }
            }
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                byte[] decodedBytes = Base64.getDecoder().decode(fileContents);
                byte[] decryptedBytes = cipher.doFinal(decodedBytes);
                new String(decryptedBytes, StandardCharsets.UTF_8);
                try {
                    // Create a FileWriter object
                    System.out.print("\nWhere save file decrypted text ? ");
                    filename = input.nextLine();
                    System.out.print("\nEnter a name of file = ");
                    filename = filename+"\\" + input.nextLine();
                    FileWriter write_decrypt = new FileWriter(filename);

                    // Write the string to the file
                    write_decrypt.write(new String(decryptedBytes, StandardCharsets.UTF_8));

                    // Close the writer
                    write_decrypt.close();

                    System.out.println("\nSuccessfully save decrypted text\n----------------------------------\n");

                } catch (IOException e) {
                    System.out.println("\nAn error occurred in save decrypted text.\n");
                }
            } catch (Exception e) {
                System.out.println("\nyour key is incrroct , Try again.\n");
            }
        } catch (IOException e) {
        System.out.println("\nError in read your file\n");
        }
    }
}
