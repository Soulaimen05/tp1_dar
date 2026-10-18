package serverPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        String ipServeur = "192.168.1.18";   // ← TON IP
        int port = 1234;

        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(InetAddress.getByName(ipServeur), port));
            System.out.println("Serveur en écoute sur " + ipServeur + ":" + port);

            Socket socket = serverSocket.accept();
            System.out.println("un client est connecté : " + socket.getInetAddress().getHostAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            int choix;
            do {
                choix = in.readInt();
                if (choix == 0) break;

                int x = in.readInt();
                int y = in.readInt();
                System.out.println("Reçu : choix=" + choix + ", x=" + x + ", y=" + y);

                String resultat;
                switch (choix) {
                    case 1: resultat = String.valueOf((long) x + y); break;
                    case 2: resultat = String.valueOf((long) x - y); break;
                    case 3: resultat = String.valueOf((long) x * y); break;
                    case 4:
                        if (y == 0) resultat = "Erreur : division par zéro";
                        else resultat = String.valueOf((double) x / y);
                        break;
                    default: resultat = "Erreur : opération inconnue";
                }
                out.writeUTF(resultat);
                System.out.println("Résultat envoyé : " + resultat);
            } while (true);

            System.out.println("Fin de la communication, fermeture des sockets");
            in.close();
            out.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}