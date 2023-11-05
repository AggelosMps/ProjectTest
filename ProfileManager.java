import java.util.ArrayList;

public class ProfileManager {
    protected ArrayList<ManagerData> profiles;

    public ProfileManager() {
        profiles = new ArrayList<>();
    }

    // Method to add a new manager profile
    public void addProfile(ManagerData profile) {
        profiles.add(profile);
    }

    // Method to check if a manager with the given username exists
    public boolean managerExists(String username) {
        for (ManagerData profile : profiles) {
            if (profile.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    // Method to authenticate a manager by checking username and password
    public boolean authenticate(String username, String password) {
        for (ManagerData profile : profiles) {
            if (profile.getUsername().equals(username) && profile.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
