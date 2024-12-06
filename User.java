import java.util.HashMap;
import java.util.Map;

public class User {
    private static final Map<String, String> registeredUsers = new HashMap<>(); 
  
    public static boolean register(String username, String password) {
        if (registeredUsers.containsKey(username)) {
            return false; 
        }
        registeredUsers.put(username, password);
        return true;
    }

   
    public static boolean login(String username, String password) {
        return registeredUsers.containsKey(username) && registeredUsers.get(username).equals(password);
    }
}
