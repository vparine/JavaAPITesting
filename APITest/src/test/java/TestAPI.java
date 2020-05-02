import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestAPI {

    private Utility utility = null;

    //Instantiate Utility class
    @BeforeClass
    public void setup() {
        utility = new Utility();
    }

    //This test case searches for Repositories written in Java and having Java in their names. Results are sorted by No Of Stars and in Descending Order.
    @Test
    public void searchForRepositoriesWithName_Java_WrittenIn_Java_SortByNoOf_Stars_OrderIn_Desc() {
        utility.searchForRepositories("Java+language:java", "stars", "desc");
        Assert.assertEquals(utility.getResponseCode(), 200, "Request for Repositories didn't succeed. Please check.");
        Assert.assertNotEquals(utility.getTotalCount(), 0, "No Repositories found for given search parameters. Refine the search and try again.");
    }

    //This test case searches for Repositories written in Java and created after given date. Results are sorted by No Of Stars and in Descending Order.
    @Test
    public void searchForRepositoriesWithGiven_CreatedDate_SortByNoOf_Stars_OrderIn_Desc() {
        utility.searchForRepositories("Java+language:java+created:>2019-01-01", "stars", "desc");
        Assert.assertEquals(utility.getResponseCode(), 200, "Request for Repositories didn't succeed. Please check.");
        Assert.assertNotEquals(utility.getTotalCount(), 0, "No Repositories found for given search parameters. Refine the search and try again.");
    }
}
