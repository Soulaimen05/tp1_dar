package clientPackage;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Je suis un client pas encore connecté…");

            // Connexion au serveur (même port que le serveur)
            Socket socket = new Socket("localhost", 1234);
            System.out.println("je suis un client connecté");

            // Dernière étape : fermer le socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}