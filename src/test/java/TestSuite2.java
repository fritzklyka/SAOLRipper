import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TestSuite2 {
    String url = "https://svenska.se/saol/?id=2040469&pz=5";
    ArrayList dictonary = new ArrayList();
    boolean run = true;
    private static final String FILENAME = "C:\\dev\\saol.txt";
    FileWriter fw = new FileWriter(FILENAME);
    BufferedWriter bw = new BufferedWriter(fw);

    public TestSuite2() throws IOException {
    }

    @Test
    public void saolRipper() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        while (run == true) {
            driver.get(url);
            for (int i = 1; i <= 11; i++) {
                if (i < 11) {
                    WebElement theWord = driver.findElement(By.xpath("//*[@id=\"navi-div\"]/div/a[" + i + "]/span[2]"));
//                    System.out.println("theWord = " + theWord.getText());
                    try {
                        bw.write(theWord.getText() + "\n");
//                        if (theWord.getText().equals("anus")) {
//                            run = false;
//                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    setNewUrl(driver);
                }
            }
        }
        try {
            if (bw != null)
                bw.close();
            if (fw != null)
                fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(dictonary);
        driver.quit();
    }

    private void setNewUrl(ChromeDriver driver) {
        WebElement newURL = driver.findElement(By.xpath("//*[@id=\"navi-div\"]/div/a[11]"));
        System.out.println("newURL = " + newURL.getAttribute("href"));
        url = newURL.getAttribute("href");
        if (url.equals("https://svenska.se/saol/?id=3709394&pz=5")) {
            run = false;
        }
    }
}