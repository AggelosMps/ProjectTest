import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

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
       // for (ManagerData profile : profiles) {
       //     if (profile.getUsername().equals(username)) {
       //         return true;
       //     }
	List<String> filenames = getFileNames();
	Set<String> usernameSet = loadUsernames();

	if (!usernamesSet.contains(username)) {
	   return false;
	} else {
	   return true;
	}
	
        }
       // return false;
    }

    private static List<String> getFileNames() {
	List<String> filenames = new ArrayList<>();
	filenames.add(); //Με κάποιο τρόπο θα πρέπει να παίρνω πρόσβαση στα ονόματα των αρχείων. Πιθανόν μέσω του arraylist profile 
	
	return filenames;
    }


    private static Set<String> loadUsernames(List<String> filenames) {
	Set<String> usernameSet = new HashSet<>();
	
	for (String filename : filenames) {
	   try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
	     String line;
	     while ((line - reader.readLine()) != null) {
		usernamesSet.add(line.trim());
	     }
  	   } catch (IOExceptioin e) {
		e.printStackTrace();
	   }
	}
       return usernamesSet;

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
