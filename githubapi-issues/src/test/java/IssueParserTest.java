package test.java;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import main.java.IssueParser;
import main.java.IssueBean;
import main.java.UserBean;

public class IssueParserTest {

    private String expectedJsonData = "";

    @Before
    public void setUp() throws Exception {
        expectedJsonData = GetJsonDataFromTextFile();
    }

    @Test
    public void testParseIssues() {
        try {

            // Arrange
            IssueParser parsing = new IssueParser();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'",
                    Locale.ENGLISH);

            String createDate = "2016-02-17T16:32:21Z";
            Date creDate = format.parse(createDate);

            UserBean user = new UserBean();
            user.setId(16694879);
            user.setLogin("sridivyatejayedlapalli");

            UserBean assignee = new UserBean();
            assignee.setId(10540251);
            assignee.setLogin("juancvega");

            // Execute
            List<IssueBean> issues = parsing.ParseIssues(expectedJsonData);

            // Assert
            assertTrue(issues != null);
            assertTrue(issues.size() == 5);

            assertTrue(issues.get(0).getNumber() == 7);
            assertTrue(issues.get(0).getLoginid() == 134330343);
            assertTrue(issues.get(0).getState().equals("open"));
            assertTrue(issues.get(0).getTitle().equals("Issue 1"));
            assertTrue(issues.get(0).getBody()
                    .equals("Alignment of code is improper."));
            assertTrue(issues.get(0).getCreatedAt().equals(creDate));
            assertTrue(issues.get(0).getClosedAt() == null);
            assertTrue(issues.get(0).getUser().equals(user));
            assertTrue(issues.get(0).getAssignee().equals(assignee));

        }
        catch (Exception ex) {
            assertTrue(false);
        }

    }

    private String GetJsonDataFromTextFile() {
        StringBuilder sb = new StringBuilder();
        try {
            // Open the file that is the first
            // command line parameter
            Path currentRelativePath = Paths.get("");
            String rootPath = currentRelativePath.toAbsolutePath().toString();

            FileInputStream fstream = new FileInputStream(
                    rootPath + "/src/test/java/sample-output.txt");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(fstream));
            String strLine;
            // Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                sb.append(strLine.trim());
            }

        }
        catch (Exception e) {// Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        return sb.toString();
    }

}
