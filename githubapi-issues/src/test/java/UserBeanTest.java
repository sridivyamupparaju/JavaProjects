package test.java;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import main.java.UserBean;

public class UserBeanTest {

    @Test
    public void testHashCode_PassCaseSameData() {

        UserBean user1 = new UserBean();
        user1.setId(5);
        user1.setLogin("divya");

        UserBean user2 = new UserBean();
        user2.setId(5);
        user2.setLogin("divya");

        // Execute

        int result = user1.hashCode();

        int result2 = user2.hashCode();

        // Assert
        assertTrue(result == result2);

    }

    @Test
    public void testHashCode_FailCaseWithDifferentID() {

        UserBean user1 = new UserBean();
        user1.setId(2);
        user1.setLogin("divya");

        UserBean user2 = new UserBean();
        user2.setId(5);
        user2.setLogin("divya");

        // Execute

        int result = user1.hashCode();

        int result2 = user2.hashCode();

        // Assert
        assertTrue(result != result2);

    }

    @Test
    public void testHashCode_FailCaseWithDifferentLogin() {

        UserBean user1 = new UserBean();
        user1.setId(5);
        user1.setLogin("divya");

        UserBean user2 = new UserBean();
        user2.setId(5);
        user2.setLogin("siddhu");

        // Execute

        int result = user1.hashCode();

        int result2 = user2.hashCode();

        // Assert
        assertTrue(result != result2);

    }

    @Test
    public void testEquals_PassCaseSameData() {

        UserBean user1 = new UserBean();
        user1.setId(5);
        user1.setLogin("divya");

        UserBean user2 = new UserBean();
        user2.setId(5);
        user2.setLogin("divya");

        // Execute
        boolean result = user1.equals(user2);

        // Assert
        assertTrue(result);

    }

    @Test
    public void testEquals_FailCaseWithDifferentID() {

        UserBean user1 = new UserBean();
        user1.setId(2);
        user1.setLogin("divya");

        UserBean user2 = new UserBean();
        user2.setId(5);
        user2.setLogin("divya");

        // Execute
        boolean result = user1.equals(user2);

        // Assert
        assertTrue(!result);

    }

    @Test
    public void testEquals_FailCaseWithDifferentLogin() {

        UserBean user1 = new UserBean();
        user1.setId(5);
        user1.setLogin("divya");

        UserBean user2 = new UserBean();
        user2.setId(5);
        user2.setLogin("siddhu");

        // Execute
        boolean result = user1.equals(user2);

        // Assert
        assertTrue(!result);
    }

    @Test
    public void testToString_PassCase() {

        // Arrange
        UserBean user1 = new UserBean();
        user1.setId(5);
        user1.setLogin("divya");
        String expectedResult = "\n\tID: 5\n\tLogin: divya";

        // Execute
        String result = user1.toString();

        // Assert
        assertTrue(result.equals(expectedResult));
    }

    @Test
    public void testToString_FailCase() {

        // Arrange
        UserBean user1 = new UserBean();
        user1.setId(5);
        user1.setLogin("sid");
        String expectedResult = "\n\tID: 5\n\tLogin: divya";

        // Execute
        String result = user1.toString();

        // Assert
        assertTrue(!result.equals(expectedResult));
    }
}
