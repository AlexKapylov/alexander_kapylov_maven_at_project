package homework.day21.utils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import homework.day21.objects.SearchUser;
import homework.day21.objects.User;
import homework.day21.objects.UsersList;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Parser {

    Gson gson = new Gson();

    public String UserToJSON(User user) {
        return gson.toJson(user);
    }

    public String UsersListToJSON(UsersList usersLists) {
        return gson.toJson(usersLists);
    }

    public String SearchUserToJSON(SearchUser search) {
        return gson.toJson(search);
    }

    public User fromJSONtoUser(String fileName) throws FileNotFoundException {
        User user = gson.fromJson(new JsonReader(new FileReader("src/test/resources/homework21/" + fileName + ".json")), User.class);
        return user;
    }

    public UsersList fromJSONtoUsersList(String fileName) throws FileNotFoundException {
        UsersList usersList = gson.fromJson(new JsonReader(new FileReader("src/test/resources/homework21/" + fileName + ".json")), UsersList.class);
        return usersList;
    }

}
