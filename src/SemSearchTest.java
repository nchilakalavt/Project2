import student.TestCase;

/**
 * @author Nirish Chliakala
 * @version 9/21/23
 */
public class SemSearchTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing here
    }


    /**
     * Get code coverage of the class declaration.
     */
    public void testMInitx()
    {
        SemSearch sem = new SemSearch();
        assertNotNull(sem);
        SemSearch.main(null);
    }
}

