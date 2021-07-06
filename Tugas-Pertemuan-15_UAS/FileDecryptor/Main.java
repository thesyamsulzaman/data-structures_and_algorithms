import services.FileManager;
import services.Encryptor;

public class Main {


  public static void main(String[] args) throws Exception {

    // { Proses Enkripsi }
    String inputedText = FileManager.read("./message.txt");
    String encryptedContent = Encryptor.encrypt(inputedText);
    FileManager.write("./message-encrypted.txt", encryptedContent);

    // { Proses Dekripsi }
    String encryptedContentFromFile = FileManager.read("./message-encrypted.txt");
    String decryptedContent = Encryptor.decrypt(encryptedContentFromFile);
    FileManager.write("./message-decrypted.txt", decryptedContent);

  }

}
