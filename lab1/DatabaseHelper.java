
package project.lab1;


import java.util.HashMap;

public class DatabaseHelper {
    
    private static HashMap<String, String> credentials = new HashMap<>();

   
    public static void addUserCredentials(String nsuId, String password) {
        credentials.put(nsuId, password);
    }

    
    public static boolean verifyUser(String nsuId, String password) {
        return credentials.containsKey(nsuId) && credentials.get(nsuId).equals(password);
    }
}

