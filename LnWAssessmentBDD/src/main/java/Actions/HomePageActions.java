package Actions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import Utils.CommonHelper;

public class HomePageActions {
	
	
	
	//HomePageLocators homePageLocators;
	WebDriver driver;
	public String FirstItemprice;
	public String itemPriceInCartPage;
	public String itemSubtotalPriceInCartPage;
	public String itemPriceInProductPage;
	public String searchItemPriceInProductPage;
	public String firstItemPriceInCartPage;
	public String secondItemPriceInCartPage;
	public String item1;
	public String item2;
	 
    public HomePageActions() {
 
        //this.homePageLocators = new HomePageLocators();
        //PageFactory.initElements(driver,homePageLocators);
    }
    //Locators
    By searchItems =By.xpath("//input[@id='twotabsearchtextbox']");
    By searchIcon =By.xpath("//input[@id='nav-search-submit-button' ]");
    By firstItem = By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[1]");
    By btnAddToCart = By.xpath("//input[@id='add-to-cart-button']");
    By btnSecondItemAddToCart = By.xpath("(//input[@id='add-to-cart-button'])[2]");
    By lnkSideSheet=By.xpath("//a[@id='attach-close_sideSheet-link']");
    By cart = By.xpath("//span[@class='nav-cart-icon nav-sprite']");
    By mainpage = By.xpath("//div[@id='attach-added-to-cart-message']");
    By secondItem = By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[2]");
    By cartIcon = By.xpath("//*[@id='nav-cart-count']");
    By price=By.xpath("(//div[@class='a-section a-spacing-none a-spacing-top-micro puis-price-instructions-style'])[1]/div/div/a/span");
    By cartSubTotalPrice=By.xpath("//span[@id='sc-subtotal-amount-activecart']");
    By itemPrice=By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@class='a-price-whole']");
    By itemPriceInCart=By.xpath("(//span[contains(@class,'a-size-medium a-color-base')])[2]");
    By itemPriceInCart1=By.xpath("(//span[contains(@class,'a-size-medium a-color-base')])[3]");
    
    By test=By.xpath("(//span[contains(@class,'a-truncate-cut')])[2]");
    
    //Action Methods
    public void openApplication(String appURL)
    {
	 	System.setProperty("webdriver.chrome.driver", "/Users/kritikachakravarty/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
    }
    
    public HomePageActions enterSearchItem(String itemName) {
    	//driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(itemName);
    	driver.findElement(searchItems).sendKeys(itemName);
        return this;
    }
    
    public HomePageActions clickOnSearchIcon() {
    	driver.findElement(searchIcon).click();
        return this;
    }
    
    public void clearSearchInput() {
    	driver.findElement(searchItems).clear(); 	
    }
    
    public void clickOnFirstItem() throws InterruptedException {
        driver.findElement(firstItem).click();
        Thread.sleep(3000);
        Set<String> windows=driver.getWindowHandles();
    	ArrayList ar = new ArrayList(windows);
    	ar.get(1);
    	driver.switchTo().window((String)ar.get(1));
        itemPriceInProductPage = driver.findElement(itemPrice).getText();
        System.out.println("itemPriceInProductPage"+itemPriceInProductPage);
        }
    
    public void clickOnkeyboardItem() throws InterruptedException {
        driver.findElement(firstItem).click();
        Thread.sleep(3000);
        itemPriceInProductPage = driver.findElement(itemPrice).getText();
        System.out.println("itemPriceInProductPage"+itemPriceInProductPage);
        }
    
    public void AddItemOnCart() throws InterruptedException {
    	Set<String> windows=driver.getWindowHandles();
    	ArrayList ar = new ArrayList(windows);
    	ar.get(1);
    	driver.switchTo().window((String)ar.get(1));
    	driver.findElement(btnAddToCart).click();
    	Thread.sleep(3000);
    	driver.navigate().refresh();
    	Thread.sleep(3000);    	   	    	
    }
    
    public void AddSecondItemOnCart() throws InterruptedException {
    	Set<String> windows=driver.getWindowHandles();
    	ArrayList ar = new ArrayList(windows);
    	ar.get(1);
    	driver.switchTo().window((String)ar.get(1));
    	driver.findElement(btnSecondItemAddToCart).click();
    	Thread.sleep(3000);
    	driver.navigate().refresh();
    	Thread.sleep(3000);    	   	    	
    }
    
    public void openCart() throws InterruptedException {

    	Set<String> windows=driver.getWindowHandles();
    	ArrayList ar = new ArrayList(windows);
    	ar.get(1);
    	driver.switchTo().window((String)ar.get(1));
    	Thread.sleep(3000);
    	driver.findElement(cartIcon).click();
    	
    }
    
    public void verifyItemPriceInCart()
    {
    	itemPriceInCartPage=driver.findElement(itemPriceInCart).getText();
    	String[] itemPriceTotal = itemPriceInCartPage.split("\\.");    	
        System.out.println("itemPriceInCartPage"+itemPriceTotal[0]);
        Assert.assertTrue(itemPriceTotal[0].contains(itemPriceInProductPage),"Item Price is not Identical With Cart Page Price");   
    }
    
    public void verifySubTotalPriceInCart()
    {
    	itemSubtotalPriceInCartPage=driver.findElement(cartSubTotalPrice).getText();   	
    	String[] subTotal = itemSubtotalPriceInCartPage.split("\\.");    	
        System.out.println("itemSubtotalPriceInCartPage"+subTotal[0]);
        Assert.assertTrue(subTotal[0].contains(itemPriceInProductPage),"Item Subtotal Price is not Identical With Product Page Total");   	
    }
    
    
    public void clickOnSecondItem() throws InterruptedException {
        	driver.findElement(secondItem).click();
            Thread.sleep(3000);
            Set<String> windows=driver.getWindowHandles();
        	ArrayList ar = new ArrayList(windows);
        	ar.get(1);
        	driver.switchTo().window((String)ar.get(1));
            itemPriceInProductPage = driver.findElement(itemPrice).getText();
            	System.out.println("itemPriceInProductPage"+itemPriceInProductPage);
        	
        }
    
    public void clickOnSearchedFirstItem(String itemName) throws InterruptedException {
    	driver.findElement(firstItem).click();        
    	Thread.sleep(3000);
    	Set<String> windows=driver.getWindowHandles();
    	ArrayList ar = new ArrayList(windows);
    	ar.get(2);
    	driver.switchTo().window((String)ar.get(2));
    	searchItemPriceInProductPage = driver.findElement(itemPrice).getText();
        System.out.println("searchItemPriceInProductPage"+searchItemPriceInProductPage);
        }
    
    public void addSearchedItemToCart() throws InterruptedException
    {
        	Set<String> windows=driver.getWindowHandles();
        	ArrayList ar = new ArrayList(windows);
        	ar.get(2);
        	driver.switchTo().window((String)ar.get(2));
        	driver.findElement(btnAddToCart).click();
        	Thread.sleep(3000);
        	driver.navigate().refresh();
        	Thread.sleep(3000);    	   	    	
    }
    
    
    public void verifyEachItemPriceInCart()
    {
    	firstItemPriceInCartPage=driver.findElement(itemPriceInCart).getText();
  	   String[] firstitemPriceTotal = firstItemPriceInCartPage.split("\\.");    	
       System.out.println("firstItemPriceInCartPage"+ firstitemPriceTotal[0]);
       
       item1 = firstitemPriceTotal[0].replaceAll("\\s", "");
       Assert.assertEquals(item1, searchItemPriceInProductPage,"First Item Price is not Identical With Cart Page Price");
    
        secondItemPriceInCartPage=driver.findElement(itemPriceInCart1).getText();
    	String[] seconditemPriceTotal = secondItemPriceInCartPage.split("\\.");    	
        System.out.println("secondItemPriceInCartPage"+seconditemPriceTotal[0]);
        
        item2 = seconditemPriceTotal[0].replaceAll("\\s", "");
        Assert.assertEquals(item2, itemPriceInProductPage,"Second Item Price is not Identical With Cart Page Price");
       
    }
    
    public void verifyTotalPriceInCart()
    { 	
    	String formatItem2 = item2.replaceAll(",", "");
    	System.out.println(formatItem2);
    	int TotalofItems1 = (Integer.parseInt(item1));
    	int TotalofItems2 = (Integer.parseInt(formatItem2));    	
    	int sumTotalofItems = (TotalofItems1+TotalofItems2);
    	itemSubtotalPriceInCartPage=driver.findElement(cartSubTotalPrice).getText();   	
    	String[] subTotal = itemSubtotalPriceInCartPage.split("\\.");    	
        System.out.println("itemSubtotalPriceInCartPage"+subTotal[0]);
        String sumFinal = subTotal[0].replaceAll("\\s", "");
        String formatSumTotal = sumFinal.replaceAll(",", "");
        int finalVal =Integer.parseInt(formatSumTotal);
        Assert.assertEquals(sumTotalofItems, finalVal,"SubTotal in cart is not all Product is not matching with the sum ");
    }
    
    @AfterTest
    public void teardown()
    {
    	driver.quit();
    }
   }

