package test.java;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import main.java.IssueBean;
import main.java.UserBean;

public class IssueBeanTest {

    @Test
    public void testHashCode_PassCaseSameData() {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;

        try {
            date = df.parse("01-03-2016");
        }
        catch (Exception e) {
        }

        IssueBean issueBean = new IssueBean();
        UserBean user1 = new UserBean();

        user1.setId(5);
        issueBean.setLoginid(9890001);
        issueBean.setTitle("First Issue");
        issueBean.setUser(user1);

        IssueBean issueBean2 = new IssueBean();
        UserBean user2 = new UserBean();
        user2.setId(5);
        issueBean2.setLoginid(9890001);
        issueBean2.setTitle("First Issue");
        issueBean2.setUser(user1);

        // Execute

        int result = issueBean.hashCode();

        int result2 = issueBean2.hashCode();

        // Assert
        assertTrue(result == result2);

    }

    @Test
    public void testHashCode_PassCaseEvenWithDifferentNumbers() {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;

        try {
            date = df.parse("01-03-2016");
        }
        catch (Exception e) {
        }

        IssueBean issueBean = new IssueBean();
        UserBean user1 = new UserBean();

        user1.setId(5);
        issueBean.setLoginid(9890001);
        issueBean.setTitle("First Issue");
        issueBean.setUser(user1);
        issueBean.setNumber(65);

        IssueBean issueBean2 = new IssueBean();
        UserBean user2 = new UserBean();
        user2.setId(5);
        issueBean2.setLoginid(9890001);
        issueBean2.setTitle("First Issue");
        issueBean2.setUser(user1);
        issueBean2.setNumber(5);

        // Execute

        int result = issueBean.hashCode();

        int result2 = issueBean2.hashCode();

        // Assert
        assertTrue(result == result2);

    }

    @Test
    public void testHashCode_FailCaseWithDifferentID() {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;

        try {
            date = df.parse("01-03-2016");
        }
        catch (Exception e) {
        }

        IssueBean issueBean = new IssueBean();
        UserBean user1 = new UserBean();

        user1.setId(5);
        issueBean.setLoginid(9890001);
        issueBean.setTitle("First Issue");
        issueBean.setUser(user1);

        IssueBean issueBean2 = new IssueBean();
        UserBean user2 = new UserBean();
        user2.setId(5);
        issueBean2.setLoginid(98392829);
        issueBean2.setTitle("First Issue");
        issueBean2.setUser(user1);

        // Execute

        int result = issueBean.hashCode();

        int result2 = issueBean2.hashCode();

        // Assert
        assertTrue(result != result2);

    }

    @Test
    public void testHashCode_FailCaseWithDifferentTitle() {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;

        try {
            date = df.parse("01-03-2016");
        }
        catch (Exception e) {
        }

        IssueBean issueBean = new IssueBean();
        UserBean user1 = new UserBean();

        user1.setId(5);
        issueBean.setLoginid(9890001);
        issueBean.setTitle("First Issue");
        issueBean.setUser(user1);

        IssueBean issueBean2 = new IssueBean();
        UserBean user2 = new UserBean();
        user2.setId(5);
        issueBean2.setLoginid(9890001);
        issueBean2.setTitle("Second Issue ");
        issueBean2.setUser(user1);

        // Execute

        int result = issueBean.hashCode();

        int result2 = issueBean2.hashCode();

        // Assert
        assertTrue(result != result2);

    }

    @Test
    public void testEquals_PassCase() {

        // Arrange
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;

        try {
            date = df.parse("01-03-2016");
        }
        catch (Exception e) {
        }

        IssueBean issueBean = new IssueBean();
        UserBean user1 = new UserBean();

        user1.setId(5);
        issueBean.setLoginid(9890001);
        issueBean.setTitle("First Issue");
        issueBean.setUser(user1);

        IssueBean issueBean2 = new IssueBean();
        UserBean user2 = new UserBean();
        user2.setId(5);
        issueBean2.setLoginid(9890001);
        issueBean2.setTitle("First Issue");
        issueBean2.setUser(user1);

        // Execute
        boolean result = issueBean.equals(issueBean2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testEquals_PassCaseEvenWithDifferentNumbers() {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;

        try {
            date = df.parse("01-03-2016");
        }
        catch (Exception e) {
        }

        IssueBean issueBean = new IssueBean();
        UserBean user1 = new UserBean();

        user1.setId(5);
        issueBean.setLoginid(9890001);
        issueBean.setTitle("First Issue");
        issueBean.setUser(user1);
        issueBean.setNumber(65);

        IssueBean issueBean2 = new IssueBean();
        UserBean user2 = new UserBean();
        user2.setId(5);
        issueBean2.setLoginid(9890001);
        issueBean2.setTitle("First Issue");
        issueBean2.setUser(user1);
        issueBean2.setNumber(5);

        // Execute
        boolean result = issueBean.equals(issueBean2);

        // Assert
        assertTrue(result);

    }

    @Test
    public void testEquals_FailCaseWithDifferentID() {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;

        try {
            date = df.parse("01-03-2016");
        }
        catch (Exception e) {
        }

        IssueBean issueBean = new IssueBean();
        UserBean user1 = new UserBean();

        user1.setId(5);
        issueBean.setLoginid(9890001);
        issueBean.setTitle("First Issue");
        issueBean.setUser(user1);

        IssueBean issueBean2 = new IssueBean();
        UserBean user2 = new UserBean();
        user2.setId(5);
        issueBean2.setLoginid(98392829);
        issueBean2.setTitle("First Issue");
        issueBean2.setUser(user1);

        // Execute
        boolean result = issueBean.equals(issueBean2);

        // Assert
        assertTrue(!result);

    }

    @Test
    public void testEquals_FailCaseWithDifferentTitle() {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;

        try {
            date = df.parse("01-03-2016");
        }
        catch (Exception e) {
        }

        IssueBean issueBean = new IssueBean();
        UserBean user1 = new UserBean();

        user1.setId(5);
        issueBean.setLoginid(9890001);
        issueBean.setTitle("First Issue");
        issueBean.setUser(user1);

        IssueBean issueBean2 = new IssueBean();
        UserBean user2 = new UserBean();
        user2.setId(5);
        issueBean2.setLoginid(9890001);
        issueBean2.setTitle("Second Issue ");
        issueBean2.setUser(user1);

        // Execute
        boolean result = issueBean.equals(issueBean2);

        // Assert
        assertTrue(!result);

    }

    @Test
    public void testToString_PassCase() {

        // Arrange
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;

        try {
            date = df.parse("01-03-2016");
        }
        catch (Exception e) {
        }

        IssueBean issueBean = new IssueBean();
        UserBean user1 = new UserBean();

        user1.setId(5);
        issueBean.setLoginid(9890001);
        issueBean.setTitle("First Issue");
        issueBean.setUser(user1);

        String expectedText = "Issue Number: 0\nIssue ID: 9890001\nIssue State : null\nIssue Title: First Issue\nIssue Body: \nIssue Created Date: null\nUser: \n\tID: 5\n\tLogin: \nAssignee:";

        // Execute
        String result = issueBean.toString().trim();

        // Assert
        assertTrue(
                result.contains(expectedText) && expectedText.contains(result));
    }

    @Test
    public void testToString_FailCase() {

        // Arrange
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;

        try {
            date = df.parse("01-03-2016");
        }
        catch (Exception e) {
        }

        IssueBean issueBean = new IssueBean();
        UserBean user1 = new UserBean();

        user1.setId(5);
        issueBean.setLoginid(9890001);
        issueBean.setTitle("First Issue");
        issueBean.setUser(user1);

        String expectedText = "Assignee";

        // Execute
        String result = issueBean.toString().trim();

        // Assert
        assertTrue(!result.contains(expectedText)
                || !expectedText.contains(result));
    }
}
