package clientPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String ipServeur = "192.168.1.18";   // ← IP de la machine SERVEUR
        int port = 1234;

        try {
            System.out.println("Je suis un client pas encore connecté…");
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(InetAddress.getByName(ipServeur), port), 5000);
            System.out.println("je suis un client connecté au serveur " + ipServeur);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);

            int choix;
            do {
                System.out.println("\n===== CALCULATRICE =====");
                System.out.println("1. Addition");
                System.out.println("2. Soustraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("0. Quitter");
                System.out.print("Votre choix : ");
                choix = sc.nextInt();

                if (choix < 0 || choix > 4) {
                    System.out.println("Choix invalide.");
                    continue;
                }
                out.writeInt(choix);
                if (choix == 0) break;

                System.out.print("Entrez x : ");
                int x = sc.nextInt();
                System.out.print("Entrez y : ");
                int y = sc.nextInt();
                out.writeInt(x);
                out.writeInt(y);

                String resultat = in.readUTF();
                System.out.println("Résultat : " + resultat);
            } while (true);

            System.out.println("Fin de la communication, fermeture du socket");
            in.close();
            out.close();
            sc.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}