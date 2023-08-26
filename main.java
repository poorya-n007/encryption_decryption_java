import java.util.Scanner;

public class main
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n█▀▀ █▀▀▄ █▀▀ █▀▀█ █░░█ █▀▀█ ▀▀█▀▀  █▀▀█ █▀▀▄ █▀▀▄ ▒█▀▀▄ █▀▀ █▀▀ █▀▀█ █░░█ █▀▀█ ▀▀█▀▀ ");
        System.out.println("█▀▀ █░░█ █░░ █▄▄▀ █▄▄█ █░░█ ░░█░░  █▄▄█ █░░█ █░░█ ▒█░▒█ █▀▀ █░░ █▄▄▀ █▄▄█ █░░█ ░░█░░ ");
        System.out.println("▀▀▀ ▀░░▀ ▀▀▀ ▀░▀▀ ▄▄▄█ █▀▀▀ ░░▀░░  ▀░░▀ ▀░░▀ ▀▀▀░ ▒█▄▄▀ ▀▀▀ ▀▀▀ ▀░▀▀ ▄▄▄█ █▀▀▀ ░░▀░░\n");

        char[] english = new char[]{'_','-',')','(','*','&','^','%','$','#','@','!','?',' ', 'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',};
        char[] encrypt = new char[]{'9', '8', '7', '6', '5', '4', '3', '2', '1', '0', 'Z', 'z', 'Y', 'y', 'X', 'x', 'W', 'w', 'V', 'v', 'U', 'u', 'T', 't', 'S', 's', 'R', 'r', 'Q', 'q', 'P', 'p', 'O', 'o', 'N', 'n', 'M', 'm', 'L', 'l', 'K', 'k', 'J', 'j', 'I', 'i', 'H', 'h', 'G', 'g', 'F', 'f', 'E', 'e', 'D', 'd', 'C', 'c', 'B', 'b', 'A', 'a', ' ','?','!','@','#','$','%','^','&','*','(',')','-','_'};
        while (true) {
            menu();
            System.out.print("\nEnter type for encrypt and decrypt : ");
            String choose = input.next();
            System.out.println("\n1)Encrypt");
            System.out.println("2)Decrypt");
            System.out.print("\nDo you want to encrypt or decrypt (Enter number 1 or 2) : ");
            String choose_en_de = input.next();

            switch (choose) {
                case "1":
                    default_encrypt_decrypt default_encrypt_decrypt = new default_encrypt_decrypt();
                    if (choose_en_de.equals("1")) {
                        default_encrypt_decrypt.encrypt();
                    } else if (choose_en_de.equals("2")) {
                        default_encrypt_decrypt.decrypt();
                    } else {
                        System.out.println("Please enter a valid number from list !");
                        break;
                    }
                    break;
                case "2":
                    ceasar_encrypt_decrypt ceasar_encrypt_decrypt = new ceasar_encrypt_decrypt();
                    if (choose_en_de.equals("1")) {
                        ceasar_encrypt_decrypt.ceasar_encrypt(english, encrypt);
                    } else if (choose_en_de.equals("2")) {
                        ceasar_encrypt_decrypt.ceasar_decrypt(english, encrypt);
                    } else {
                        System.out.println("Please enter a valid number from list !");
                        break;
                    }
                    break;
                default:
                    System.out.println("Please enter a valid number from list !");
                    break;
            }
        }
    }

    public static void menu () {
        System.out.println("1)Default");
        System.out.println("2)Ceasar");
    }
}
