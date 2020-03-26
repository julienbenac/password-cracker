/*
 * HashFunction.java                                              25/03/2020
 */

/**
 * This enumeration contains all the hash functions available in the tool.
 * @author Julien Benac
 * @version 0.1.1
 */
public enum HashFunction {

    MD2("MD2"),
    MD5("MD5"),
    SHA_1("SHA-1"),
    SHA_224("SHA-224"),
    SHA_256("SHA-256"),
    SHA_384("SHA-384"),
    SHA_512("SHA-512"),
    SHA_512_224("SHA-512/224"),
    SHA_512_256("SHA-512/256"),
    SHA3_224("SHA3-224"),
    SHA3_256("SHA3-256"),
    SHA3_384("SHA3-384"),
    SHA3_512("SHA3-512");

    /** The given name of the hash function */
    private String name;

    /**
     * Builds a new hash function
     * @param name the given name of the hash function
     */
    HashFunction(String name) {
        this.name = name;
    }

    /**
     * Check if the given name of the hash function is available in the tool
     * @param name the hash function given name
     * @return the hash function if exists otherwise null
     */
    public static HashFunction getFromName(String name) {
        for (HashFunction f : values()) {
            if (f.getName().equalsIgnoreCase(name)) {
                return f;
            }
        }

        return null;
    }

    /**
     * Get the given name of the hash function
     * @return the name of the hash function
     */
    public String getName() {
        return this.name;
    }

}