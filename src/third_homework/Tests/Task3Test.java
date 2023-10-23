package third_homework.Tests;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import third_homework.task3.User;
import third_homework.task3.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// шифрование паролей
import static third_homework.task3.PasswordEncryption.decrypt;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Task3Test {

    private static Stream<User> ordinaryUsers() throws NoSuchPaddingException, IllegalBlockSizeException,
            NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        User user1 = new User("tom", "durkin", false);
        User user2 = new User("Christine", "perdens", false);
        User user3 = new User("Pitt", "berns", false);
        return Stream.of(user1, user2, user3);
    }
    private static Stream<User> rootUsers() throws NoSuchPaddingException, IllegalBlockSizeException,
            NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        User admin1 = new User("Peter", "peter1337", true);
        User admin2 = new User("Donald", "hart897", true);
        User admin3 = new User("Dino", "throws", true);
        return Stream.of(admin1, admin2, admin3);
    }


    @ParameterizedTest
    @MethodSource("rootUsers")
    public void usersIsAdmin(User user) {
        assertTrue(user.adminOrNotAdmin(user)); // извечный вопрос
    }


    @ParameterizedTest
    @MethodSource("ordinaryUsers")
    public void usersIsNotAdmin(User user) {
        assertFalse(user.adminOrNotAdmin(user)); // извечный вопрос
    }


    @ParameterizedTest
    @MethodSource("ordinaryUsers")
    public void logoutSerfUsers(User user) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        UserRepository repoUsers = new UserRepository(); // создание репо юзеров
        String pass = user.getPassword(); // запрос шифрованного пароля

        user.authenticate(user.getUsername(), decrypt(pass)); // логин юзера
        repoUsers.addUser(user); // добавление юзера в репо
        repoUsers.logOutOrdinaryUser(); // логаут юзера
        assertThat(repoUsers.data).doesNotContain(user); // отсутствие юзера в репо
    }


    @ParameterizedTest
    @MethodSource("rootUsers")
    public void adminNotRemoveFromData(User user) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        UserRepository repoUsers = new UserRepository();
        String pass = user.getPassword();

        user.authenticate(user.getUsername(), decrypt(pass)); // логин юзера
        repoUsers.addUser(user); // добавление юзера
        repoUsers.logOutOrdinaryUser(); // логаут юзера
        assertThat(repoUsers.data).contains(user); // наличие юзера в репо
    }

    // ===========================внизу код с семинара===========================================


    @Test
    public void getTrue() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        User user = new User("Tom","Mot", false);
        assertTrue(user.authenticate("Tom", "Mot"));
    }
    @Test
    public void getFalse() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        User user = new User("Tom","Mot", false);
        assertFalse(user.authenticate("Tosm", "Moat"));
    }

    @Test
    public void userIsAuth() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        User user = new User("vasya", "pupkin", false);
        user.authenticate("vasya", "pupkin");
        UserRepository repoUser = new UserRepository();
        repoUser.addUser(user);
        assertThat(repoUser.data).contains(user);
    }
    @Test
    public void userIsNotAuth() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        User user = new User("vasya", "pupkin", false);
        user.authenticate("vasyasda", "pupfsdfkin");
        UserRepository repoUser = new UserRepository();
        repoUser.addUser(user);
        assertThat(repoUser.data).doesNotContain(user);
    }


}