import org.openqa.selenium.chrome.ChromeDriver
import org.scalatest.concurrent.Eventually
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach}
import org.scalatestplus.selenium.WebBrowser
import pageObjects.{MainPage, SearchResultPage}

trait BaseTest extends AnyFlatSpec with BeforeAndAfterAll with BeforeAndAfterEach
  with Matchers with Eventually with WebBrowser {

  implicit val driver: ChromeDriver = {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\38066\\Desktop\\FP\\chromedriver.exe")
    new ChromeDriver()
  }

  val baseUrl = "https://en.wikipedia.org/wiki/Main_Page"

  lazy val mainPage = new MainPage(driver)
  lazy val searchResultsPage = new SearchResultPage(driver)

  override def beforeEach(): Unit = {
    go to baseUrl
  }

  override def afterAll(): Unit = {
    quit()
  }
}
