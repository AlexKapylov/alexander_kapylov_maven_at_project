package homework.day21.objects;

import java.util.List;
import java.util.Objects;

public class UsersList {

    private String code;
    List<User> data;

    public UsersList(String code, List<User> data) {
        this.code = code;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersList usersList = (UsersList) o;
        return Objects.equals(code, usersList.code) && Objects.equals(data, usersList.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, data);
    }

    @Override
    public String toString() {
        return "UsersList{" +
                "code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
