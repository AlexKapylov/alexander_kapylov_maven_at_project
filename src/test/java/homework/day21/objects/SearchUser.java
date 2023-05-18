package homework.day21.objects;

import java.util.Objects;

public class SearchUser {

    private String user;
    private boolean strict;

    public SearchUser(String user, boolean strict) {
        this.user = user;
        this.strict = strict;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isStrict() {
        return strict;
    }

    public void setStrict(boolean strict) {
        this.strict = strict;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchUser that = (SearchUser) o;
        return strict == that.strict && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, strict);
    }

    @Override
    public String toString() {
        return "SearchUser{" +
                "user='" + user + '\'' +
                ", strict=" + strict +
                '}';
    }
}
