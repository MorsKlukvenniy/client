package client;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
    
    //Юра отправляет открытый ключ Сане
    Client Ura = new Client();
    Client Sanya = new Client();
    Sanya.ReceiveExternalPublicKey(Ura.SendPublicKey());
    Ura.ReceiveExternalPublicKey(Sanya.SendPublicKey());
    Scanner sc = new Scanner(System.in);
    String message = sc.nextLine();
    Sanya.ReceiveMessage(Ura.SendMessage(message));
	}

}
