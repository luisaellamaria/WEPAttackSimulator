import java.util.ArrayList;
import java.util.List;

public class WEPAttackSimulator {

    public static void main(String[] args) {
        // Enter bits from the message space here
        String[] messages = {
                // Example message space
                "11111111",
                "00000000",
                "10101010",
        };

        // Entere the bits from the ciphertext space here
        String[] ciphertexts = {
                // Example ciphertext space
                "10101010",
                "11111111",
                "00000000",
        };

        // XOR all possible pairs of messages and ciphertexts
        List<String> messageXORs = generateAllXORs(messages);
        List<String> ciphertextXORs = generateAllXORs(ciphertexts);

        // Find matching XORs
        for (String msgXOR : messageXORs) {
            for (String ciphXOR : ciphertextXORs) {
                if (msgXOR.equals(ciphXOR)) {
                    System.out.println("Matching XOR found: " + msgXOR);
                }
            }
        }
    }


    // XORs all possible pairs of strings
    private static List<String> generateAllXORs(String[] data) {
        // List to store the results
        List<String> result = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                // XOR the two strings and add the result to the list
                result.add(xorStrings(data[i], data[j]));
            }
        }
        return result;
    }

    // XORs two strings
    private static String xorStrings(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            result.append(a.charAt(i) == b.charAt(i) ? "0" : "1");
        }
        return result.toString();
    }
}
