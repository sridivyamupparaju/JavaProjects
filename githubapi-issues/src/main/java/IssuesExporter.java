package main.java;

import main.java.IssueBean;

import main.java.UserBean;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IssuesExporter {

    // Local Variables
    private String _userName;
    private String _userPassword;

    // String Constants
    public final static String ENTER_GITHUB_USERNAME = "Please Enter Github UserName: ";
    public final static String ENTER_GITHUB_PASSWORD = "Please Enter Github Password: ";

    public static void main(String[] args) {

        IssuesExporter objExporter = new IssuesExporter();

        try {
            objExporter.IssueDetails();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void IssueDetails() throws IOException {
        String fileName = "issues.txt";
        BufferedWriter bufferedWriter = null;
        String GIT_URL = "https://api.github.com/repos/VUSpring2016TopStudio/syedlapa/issues";
        GitHubRestClient gitHub = new GitHubRestClient(GIT_URL);
        IssueParser parser = new IssueParser();

        try {

            FileWriter fileWriter = new FileWriter(fileName);
            bufferedWriter = new BufferedWriter(fileWriter);

            this._userName = GetUserName();
            this._userPassword = GetPassword();
            
            String jsonData = gitHub.requestIssues(this._userName, this._userPassword);
            List<IssueBean> allIssues = parser.ParseIssues(jsonData);
            
            gitHub.setQueryString("?state=closed");
            String jsonClosedIssues = gitHub.requestIssues(this._userName, this._userPassword);
            List<IssueBean> allClosedIssues = parser.ParseIssues(jsonClosedIssues);
            
            allIssues.addAll(allClosedIssues);
            
            for (IssueBean issue : allIssues) {
                bufferedWriter.write(issue.toString());
            }
            
            System.out.println("Number of Issues: " + allIssues.size());

        }
        catch (Exception e1) {
            e1.printStackTrace();
        }
        finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }
    }

    private String GetUserName() {
        String userName = ReadInput(ENTER_GITHUB_USERNAME);
        return userName;
    }

    private String GetPassword() {
        String password = ReadInput(ENTER_GITHUB_PASSWORD);
        return password;
    }

    private String ReadInput(String message) {
        String input = null;
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        try {
            input = sc.next();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return input;

    }

    private List<IssueBean> CreateIssues() {

        List<IssueBean> allIssues = new ArrayList<IssueBean>();
        try {

            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

            IssueBean firstIssue = new IssueBean();
            IssueBean secondIssue = new IssueBean();
            IssueBean thirdIssue = new IssueBean();

            UserBean user1 = new UserBean();
            UserBean user2 = new UserBean();
            UserBean user3 = new UserBean();

            UserBean assignee1 = new UserBean();
            UserBean assignee2 = new UserBean();
            UserBean assignee3 = new UserBean();

            user1.setId(5);
            user1.setLogin("siddharth");

            user2.setId(6);
            user2.setLogin("bobby");

            user3.setId(7);
            user3.setLogin("dinesh");

            assignee1.setId(12);
            assignee1.setLogin("kavya");

            assignee2.setId(14);
            assignee2.setLogin("sindhu");

            assignee3.setId(15);
            assignee3.setLogin("teja");

            firstIssue.setNumber(1);
            firstIssue.setLoginid(9890001);
            firstIssue.setState("open");
            firstIssue.setTitle("First Issue");
            firstIssue.setBody(
                    "Baar is getting printed for multiples of 5 instead of Bar");
            firstIssue.setCreatedAt(df.parse("01-03-2016"));
            firstIssue.setClosedAt(null);
            firstIssue.setUser(user1);
            firstIssue.setAssignee(assignee1);

            secondIssue.setNumber(2);
            secondIssue.setLoginid(9890002);
            secondIssue.setState("open");
            secondIssue.setTitle("Second Issue");
            secondIssue.setBody("Block alignment is not proper");
            secondIssue.setCreatedAt(df.parse("04-02-2016"));
            secondIssue.setClosedAt(null);
            secondIssue.setUser(user2);
            secondIssue.setAssignee(assignee2);

            thirdIssue.setNumber(3);
            thirdIssue.setLoginid(9890003);
            thirdIssue.setState("closed");
            thirdIssue.setTitle("Third Issue");
            thirdIssue.setBody(
                    "While validating input message is getting printed incorrectly");
            thirdIssue.setCreatedAt(df.parse("05-02-2016"));
            thirdIssue.setClosedAt(df.parse("09-02-2016"));
            thirdIssue.setUser(user3);
            thirdIssue.setAssignee(assignee3);

            allIssues.add(firstIssue);
            allIssues.add(secondIssue);
            allIssues.add(thirdIssue);

        }
        catch (Exception e1) {
        }
        return allIssues;
    }

}
