package pageObjects
import org.openqa.selenium.{By, WebDriver}


class SearchResultPage(private var driver: WebDriver) {
  val heading: By = By.id("firstHeading")
  val searchResult: By = By.xpath("//span[@class='searchmatch']")

  def verifyHeading(searchTerm: String): Unit = {
    assert(driver.findElement(heading).getText equals searchTerm)
  }

  def verifySearchResults(searchTerm: String): Unit = {
    assert(driver.findElements(searchResult).stream().allMatch(elem => elem.getText.toLowerCase().contains(searchTerm)),
      "Some topics does not contain searched value")
  }
}
