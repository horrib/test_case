/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws Exception {
        // TestCases tests = new TestCases(); // Initialize your test class

        // Amazon ama = new Amazon();
        // ama.testCase01();
        // ama.endTest();

        // Counthyperlinks links = new Counthyperlinks();
        // links.testCase02();
        // links.endTest();

        // Linkedlnpost post = new Linkedlnpost();
        // post.testCase03();
        // post.endTest();

        Bookshow sh = new Bookshow();
        sh.testCase04();
        sh.endTest();
        //TODO: call your test case functions one after other here

        // tests.testCase01();
        // tests.testCase02();
        // tests.testCase03();
        // tests.testCase04();
        // tests.testCase05();
        //  tests.testCase06();
        //  tests.testCase07();
        //  tests.testCase08();
        //   tests.testCase09();
        // tests.testCase10();
        //END Tests


        // tests.endTest(); // End your test by clearning connections and closing browser
    }

    public static void main(String[] args) throws Exception {
        new App().getGreeting();
    }
}
