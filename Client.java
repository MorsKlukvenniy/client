/**
 * 
 */
package client;

/**
 * @authors Mors_Klukvenniy, LeoRos10
 *
 */
public class Client {
	
	private Keys myKeys;
	private long [] externalKey;
	private Cryption crypt;
	
	Client() {
		myKeys = new Keys(3000,2000,5000);
		externalKey = new long [2];
		crypt = new Cryption();
	}
	
	long [] SendMessage(String string) {
		long [] message = crypt.Encryption(string, externalKey);
		// network
		return message;
	}
	
	void ReceiveMessage(long [] inMessage) {
		// network
		String string = crypt.Decryption(inMessage, myKeys.GetPrivateKey());
		System.out.println(string);
	}
	
	long [] SendPublicKey() {
		return myKeys.GetPublicKey();
	}
	
	void ReceiveExternalPublicKey(long [] inExternalPublicKey) {
		externalKey = inExternalPublicKey;
	}
	
}
