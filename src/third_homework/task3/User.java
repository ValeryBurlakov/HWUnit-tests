package third_homework.task3;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static third_homework.task3.PasswordEncryption.encrypt;

public class User {

    String name;
    String password;
    boolean isAdmin;
    boolean isAuthenticate = false;
    public User(String name, String password, boolean isAdmin) throws NoSuchPaddingException, IllegalBlockSizeException,
            NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        this.name = name;
        this.password = encrypt(password);
        this.isAdmin = isAdmin;
    }

// наверное по-хорошему в списке юзеров нужно хранить зашифрованные пароли и просто декриптить их во время вызова
//    public User(String name, String password, boolean isAdmin) {
//        this.name = name;
//        this.password = password;
//        this.isAdmin = isAdmin;
//    }

    public boolean authenticate(String name, String password) {
        isAuthenticate = name == this.name || this.password == password;
        return isAuthenticate;
    }
    public boolean adminOrNotAdmin(User user) {
        return isAdmin;
    }

    public String getUsername() {
        return name;
    }

    // возврат зашифрованного пароля
    public String getPassword() {
        return password;

    }
}