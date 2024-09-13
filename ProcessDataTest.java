

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ProcessDataTest.
 *
 * @version: 3.1
 * @author: Mohammed Ahmed(K22026228), Shahriar Miah(K22023070), Christopher Herre(K22001776), Talal AlOhali(K21130307)
 */
public class ProcessDataTest
{
    /**
     * Default constructor for test class ProcessDataTest
     */
    public ProcessDataTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testSetAndGetFromDate() {
        String date = "2022-01-01";
        ProcessData.setFromDate(date);
        assertEquals(date, ProcessData.getFromDate());
    }

    @Test
    public void testSetAndGetToDate() {
        String date = "2022-12-31";
        ProcessData.setToDate(date);
        assertEquals(date, ProcessData.getToDate());
    }

    @Test
    public void testConvertDate() {
        String dateStr = "2022-05-25";
        ProcessData pd = new ProcessData();
        assertEquals(pd.convertDate(dateStr), java.sql.Date.valueOf(dateStr));
    }
}
