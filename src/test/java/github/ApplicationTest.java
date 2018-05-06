package github;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    String noPublicRepos = "60";
    String name = "vaas";
    String date = "2018-05-04T11:47:51Z";

    @Autowired
    private CommandLineRunner clr;

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testName() throws Exception {
        this.clr.run();
        String output = this.outputCapture.toString();
        assertTrue(output, output.contains("Last pushed repo Name: " + name));
    }

    @Test
    public void testDate() throws Exception {
        this.clr.run();
        String output = this.outputCapture.toString();
        assertTrue(output, output.contains(", Date: " + date));
    }

    @Test
    public void testNoPublicRepos() throws Exception {
        this.clr.run();
        String output = this.outputCapture.toString();
        assertTrue(output, output.contains("No of Public Repos " + noPublicRepos));
    }
}
