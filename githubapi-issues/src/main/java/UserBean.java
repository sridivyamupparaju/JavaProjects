package main.java;

import java.io.Serializable;

public class UserBean implements Serializable {

    private String login;
    private int id;

    public UserBean() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {

        int hash = 7 * 3 + this.id;
        hash = hash + (login != null ? login.hashCode() : 0);
        return hash;

    }

    @Override
    public boolean equals(Object compareObj) {

        if (compareObj == null) {
            return false;
        }

        if (!UserBean.class.isAssignableFrom(compareObj.getClass())) {
            return false;
        }

        final UserBean other = (UserBean) compareObj;

        if (this.id != other.getId()) {
            return false;
        }

        if (!this.login.equals(other.getLogin())) {
            return false;
        }

        return true;

    }

    @Override
    public String toString() {

        StringBuilder strIssue = new StringBuilder();
        String newLine = "\n";
        String tab = "\t";

        strIssue.append(newLine + tab + "ID: " + this.id);
        strIssue.append(newLine + tab + "Login: "
                + (this.login == null ? "" : this.login));

        return strIssue.toString();
    }

}
