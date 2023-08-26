import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ceasar_encrypt_decrypt {
    Scanner input = new Scanner(System.in);
    String string = "";
    String str = "";
    String filename;
    String fileContents;
    public void ceasar_encrypt(char[] english , char[] encrypt) {
        System.out.print("\nEnter your text : ");
        String text = input.nextLine();
        for (int i = 0 ; i < text.length() ; i++) {
            char c1 = text.charAt(i);
            for (int j = 0 ; j < english.length ; j++) {
                char c2 = english[j];
                if (c1 == c2) {
                    str = str+String.valueOf(encrypt[j]);
                    break;
                }
            }
        }

        try {
            // Create a FileWriter object
            System.out.print("\nWhere save file encrypt text ? ");
            filename = input.nextLine();
            System.out.print("\nEnter a name of file = ");
            filename = filename+"\\" + input.nextLine();
            FileWriter write_decrypt = new FileWriter(filename);

            // Write the string to the file
            write_decrypt.write(str);

            // Close the writer
            write_decrypt.close();

            System.out.println("\nSuccessfully encrypted text saved\n----------------------------------");
        } catch (IOException e) {
            System.out.println("\nError in save your text file encrypted , Try again !\n");
        }
    }

    public void ceasar_decrypt (char[] english , char[] encrypt) {
        System.out.print("Where your file ? ");
        filename = input.nextLine();
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filename));
            fileContents = new String(bytes);
        } catch (IOException e) {
            System.out.println("Error in read your file");
        }

        for (int i = 0 ; i < fileContents.length() ; i++) {
            char c3 = fileContents.charAt(i);
            for (int j = 0 ; j < encrypt.length ; j++) {
                char c4 = encrypt[j];
                if (c3 == c4) {
                    string = string+String.valueOf(english[j]);
                    break;
                }
            }
        }

        try {
            // Create a FileWriter object
            System.out.println("\nWhere save file decrypt text ?");
            filename = input.nextLine();
            System.out.println("\nEnter a name of file = ");
            filename = filename+"\\" + input.nextLine();
            FileWriter write_encrypt = new FileWriter(filename);

            // Write the string to the file
            write_encrypt.write(string);

            // Close the writer
            write_encrypt.close();

            System.out.println("\nSuccessfully decrypted text saved\n----------------------------------");
        } catch (IOException e) {
            System.out.println("\nAn error occurred.\n----------------------------------");
            e.printStackTrace();
        }
    }
}
