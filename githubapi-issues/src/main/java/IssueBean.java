package main.java;

import java.io.Serializable;
import java.util.Date;

public class IssueBean implements Serializable {

    private int number;
    private int id;
    private String state;
    private String title;
    private String body;
    private Date createdAt;
    private Date closedAt;
    private UserBean user;
    private UserBean assignee;

    public IssueBean() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLoginid() {
        return id;
    }

    public void setLoginid(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public UserBean getAssignee() {
        return assignee;
    }

    public void setAssignee(UserBean assignee) {
        this.assignee = assignee;
    }

    @Override
    public int hashCode() {

        int hash = 7 * 3 + this.id;
        hash = hash * (this.title != null ? this.title.hashCode() : 0);
        return hash;

    }

    @Override
    public boolean equals(Object compareObj) {

        if (compareObj == null) {
            return false;
        }

        if (!IssueBean.class.isAssignableFrom(compareObj.getClass())) {
            return false;
        }

        final IssueBean other = (IssueBean) compareObj;

        if (this.id != other.getLoginid()) {
            return false;
        }

        final IssueBean issue = (IssueBean) compareObj;

        if ((this.title != null ? this.title : 0) != (issue.getTitle() != null
                ? issue.getTitle() : 0)) {
            return false;
        }

        return true;

    }

    @Override
    public String toString() {

        StringBuilder strIssue = new StringBuilder();
        String newLine = "\n";

        strIssue.append(newLine + "Issue Number: " + this.number);
        strIssue.append(newLine + "Issue ID: " + this.id);
        strIssue.append(newLine + "Issue State : " + this.state);
        strIssue.append(newLine
                + ("Issue Title: " + (this.title != null ? this.title : "")));
        strIssue.append(newLine + "Issue Body: "
                + (this.body != null ? this.body : ""));
        strIssue.append(newLine + "Issue Created Date: " + this.createdAt);
        strIssue.append(newLine + "User: "
                + (this.user == null ? "" : this.user.toString()));
        strIssue.append(newLine + "Assignee: "
                + (this.assignee == null ? "" : this.assignee.toString()));
        strIssue.append(newLine);
        strIssue.append(newLine);
        strIssue.append(newLine);

        return strIssue.toString();
    }

}
