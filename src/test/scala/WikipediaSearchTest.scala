import io.qameta.allure.scalatest.AllureScalatestContext

class WikipediaSearchTest extends BaseTest {

  "User" should "be able to find topic" in new AllureScalatestContext {
    val topic = "cucumber"
    mainPage searchFor topic
    searchResultsPage verifySearchResults topic
  }

  "User" should "login successfully" in new AllureScalatestContext {
    mainPage
      .logIn()
      .insertCredentials("HelloWorld964", "R7Hj#-7fvQDJw6=")
      .verifyIfLoggedIn("HelloWorld964")
  }

  "User" should "be able to change language" in new AllureScalatestContext {
    mainPage
      .changeLanguage()
      .verifyLanguage("Українська")
  }
}