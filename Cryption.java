/**
 * 
 */
package client;

/**
 * @author yura
 *
 */
public class Cryption {

	private String sMessage;
	private long [] iMessage;
	
	Cryption() {
		sMessage = "";
		iMessage = new long [0];
	}
	
	long [] Encryption (String inMessage, long[] PublicKey) {
		sMessage = inMessage;
		iMessage = new long [sMessage.length()];
		
		for (int i = 0; i < sMessage.length(); i++) {
			iMessage[i] = (int)sMessage.charAt(i);
			iMessage[i] = features.FieldPow(iMessage[i], PublicKey[0], PublicKey[1]);
		}
		
		return iMessage;
	}
	
	String Decryption (long [] inMessage, long[] PrivateKey) {
		iMessage = inMessage;
		sMessage = "";
		
		for (int i = 0; i < iMessage.length; i++) {
			iMessage[i] = features.FieldPow(iMessage[i], PrivateKey[0], PrivateKey[1]);
			sMessage += (char)iMessage[i];
		}
		
		return sMessage;
	}
}
