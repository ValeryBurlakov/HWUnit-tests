package third_homework.task3;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    public List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (user.isAuthenticate) data.add(user);

    }

    // Разлогинивание исключая админов
    public void logOutOrdinaryUser() {
        data.removeIf(user -> !user.isAdmin);

    }

}