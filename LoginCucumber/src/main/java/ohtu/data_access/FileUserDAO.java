package ohtu.data_access;

import java.io.*;
import java.util.*;
import ohtu.domain.User;

public class FileUserDAO implements UserDao {

    private File f;
    private List<User> users = new ArrayList<>();

    public FileUserDAO(String path) {
        f = new File(path);
        try {
            f.createNewFile();
        } catch (IOException ex) {

        }
        if (f.exists()) {
            try (Scanner scan = new Scanner(f)){
                AddToUsers(scan);
            } catch (IOException ex) {

            }

        }
    }

    @Override
    public List<User> listAll() {
        return users;
    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        users.add(user);
        updateFile();
    }

    private void AddToUsers(Scanner scan) {
        while (scan.hasNext()) {
            String un = scan.nextLine();
            if (!scan.hasNext()) {
                return;
            }
            String pw = scan.nextLine();
            users.add(new User(un, pw));
        }
    }

    private void updateFile() {
        if (!f.exists()) {
            return;
        }
        try (FileWriter fw = new FileWriter(f, false)) {
            for (User user : users) {
                fw.write(user.getUsername() + "\n" + user.getPassword() + "\n");
            }
        } catch (IOException ex) {
            return;
        }
    }

}
