/*
 * PasswordCracker.java                                              25/03/2020
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/**
 * This class contains utilities for cracking a password using brute force
 * attack. Brute force attack consists of testing all possible combinations
 * with different characters until you find a convincing result.
 * @author Julien Benac
 * @version 0.1.1
 * @see HashFunction
 */
public class PasswordCracker {

    /** Character table for cracking passwords */
    private static final char[] CHARS = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '@', '.', '-', '_', '?', '!', '*', '%'
    };

    /** Maximum length of passwords */
    private static final int MAX_LENGTH = 8;

    /** Start time in milliseconds to calculate the total search time */
    private static long startTime = System.currentTimeMillis();

    /**
     * Hash the specified password with the specified hash function
     * @param function the hash function to use
     * @param password the password to hash
     * @return the hashed password
     */
    private static String hash(HashFunction function, String password) {
        StringBuilder sb = new StringBuilder();

        try {
            MessageDigest message = MessageDigest.getInstance(function.getName());

            message.update(password.getBytes());
            byte[] bytes = message.digest();

            for (byte b : bytes) {
                sb.append(String.format("%02x", b & 0xff));
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }

        return sb.toString().toLowerCase();
    }

    /**
     * Check if the hash of the specified password matches a given hash
     * @param function the hash function to use
     * @param hash the hash to compare
     * @param password the password to hash and then compare
     */
    private static void checkHash(HashFunction function, String hash, String password) {
        if (hash(function, password).equals(hash)) {
            double elapsedTime = (System.currentTimeMillis() - startTime) / 1000.0;
            String time = String.format(Locale.ENGLISH, "%.3f", elapsedTime);

            System.out.printf("Time to crack password : %s seconds\n", time);
            System.out.printf("Password cracked : %s\n", password);

            System.exit(0);
        }
    }

    /**
     * Recursively calculates a password against hash
     * @param function the hash function to use
     * @param hash the password hash to crack
     * @param password the generated password to find the initial password
     * @param targetLength the size of the target password
     */
    private static void bruteForce(HashFunction function, String hash, String password, int targetLength) {
        if (password.length() == targetLength) {
            checkHash(function, hash, password);

            System.out.println(password);
        } else {
            for (char c : CHARS) {
                bruteForce(function, hash, password + c, targetLength);
            }
        }
    }

    /**
     * Calculates the password corresponding to the hash with a brute force attack
     * @param function the hash function to use
     * @param hash the password hash to crack
     */
    private static void bruteForceWrap(HashFunction function, String hash) {
        for (int i = 0 ; i <= MAX_LENGTH ; i++) {
            bruteForce(function, hash, "", i);
        }
    }

    /**
     * Tool entry point for cracking a password without error handling
     * @param args the password hash to crack
     */
    public static void main(String... args) {
        if (args.length == 2 && HashFunction.getFromName(args[0]) != null) {
            bruteForceWrap(HashFunction.getFromName(args[0]), args[1].toLowerCase());
        }
    }

}