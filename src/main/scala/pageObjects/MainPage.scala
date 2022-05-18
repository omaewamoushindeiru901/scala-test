package pageObjects

import com.typesafe.scalalogging.LazyLogging
import org.openqa.selenium.{By, Keys, WebDriver}

class MainPage(private var driver: WebDriver) extends LazyLogging{

  private val searchField: By = By.xpath("//input[@class='vector-search-box-input']")
  private val usernameInput: By = By.xpath("//input[@id='wpName1']")
  private val passwordInput: By = By.xpath("//input[@id='wpPassword1']")
  private val username: By = By.xpath("//li[@id='pt-userpage']/a/span")
  private val logInButton: By = By.xpath("//li[@id='pt-login']/a")
  private val sendCredentialsButton: By = By.xpath("//button[@id='wpLoginAttempt']")
  private val ukrainianLanguageButton: By = By.xpath("//li[@class='interlanguage-link interwiki-uk mw-list-item']/a")
  private val heading: By = By.xpath("//div[@id = 'main-head-left']/p/a")

  def searchFor(searchTerm: String): Unit ={
    driver.findElement(searchField).sendKeys(searchTerm + Keys.RETURN)
    logger.info("Typed topic")
  }

  def logIn(): MainPage={
    driver.findElement(logInButton).click()
    logger.info("Clicked login button")
    this
  }

  def insertCredentials(login: String, password: String):MainPage ={
    driver.findElement(usernameInput).sendKeys(login)
    driver.findElement(passwordInput).sendKeys(password)
    logger.info("Entered login and password")
    driver.findElement(sendCredentialsButton).click()
    this
  }

  def verifyIfLoggedIn(login: String): MainPage ={
    assert(driver.findElement(username).getText equals login, "User did not log in correctly")
    this
  }

  def changeLanguage(): MainPage ={
    driver.findElement(ukrainianLanguageButton).click()
    logger.info("Chose language")
    this
  }

  def verifyLanguage(language: String): MainPage ={
    assert(driver.findElements(heading).stream().anyMatch(el => el.getText.contains(language)))
    this
  }

}
