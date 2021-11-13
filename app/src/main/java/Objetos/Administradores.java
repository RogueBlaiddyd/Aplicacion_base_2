package Objetos;

import java.util.Objects;

public class Administradores {
    private int id;
    private String user;
    private String pass;

    public Administradores(){
        user = "Luciano";
        pass = "123";
    }

    public Administradores(int id, String user, String pass) {
        this.id = id;
        this.user = user;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administradores that = (Administradores) o;
        return id == that.id && Objects.equals(user, that.user) && Objects.equals(pass, that.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, pass);
    }
}
