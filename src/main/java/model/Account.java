package model;

public class Account {
    int idUser;
    String username;
    String password;
    String name;
    Role role;

    public Account(int idUser, String username, String password, String name, Role role) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public Account(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public Account(String username, String password, String name, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
