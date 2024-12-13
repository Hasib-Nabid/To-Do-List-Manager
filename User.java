public class User {
    private static final int MAX_USERS = 100; 
    private static final String[] usernames = new String[MAX_USERS];
    private static final String[] passwords = new String[MAX_USERS];
    private static int userCount = 0;

    public static boolean register(String username, String password) {
        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(username)) {
                return false; 
            }
        }

        if (userCount < MAX_USERS) {
            usernames[userCount] = username;
            passwords[userCount] = password;
            userCount++;
            return true;
        }

        return false; 
    }

    public static boolean login(String username, String password) {
        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(username) && passwords[i].equals(password)) {
                return true;
            }
        }
        return false;
    }
}
