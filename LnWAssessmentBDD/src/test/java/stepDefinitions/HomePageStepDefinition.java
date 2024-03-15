package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;

import Actions.HomePageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefinition {
	

HomePageActions homePageActions = new HomePageActions();


@Given("the user is on {string}")
public void the_user_is_on(String appURL) {
	homePageActions.openApplication(appURL);
}

@When("user search for {string} in the search field")
public void user_search_for_in_the_search_field(String itemName) {
	homePageActions.enterSearchItem(itemName).clickOnSearchIcon();
	
	
}

@When("user select the first item in the list")
public void user_select_the_first_item_in_the_list() throws InterruptedException {
	homePageActions.clickOnFirstItem();
}

@When("user select the second item in the list")
public void user_select_the_second_item_in_the_list() throws InterruptedException {
	homePageActions.clickOnSecondItem();
}

@When("user add the {string} to the cart by clicking on {string}")
public void user_add_the_to_the_cart_by_clicking_on(String string, String string2) throws InterruptedException {
	homePageActions.AddItemOnCart();
}

@When("user add the second {string} to the cart by clicking on {string}")
public void user_add_the_second_to_the_cart_by_clicking_on(String string, String string2) throws InterruptedException {
	homePageActions.AddSecondItemOnCart();
}

@When("user searches for next item as {string}")
public void user_searches_for_next_item_as(String itemName) {
	homePageActions.clearSearchInput();
	homePageActions.enterSearchItem(itemName).clickOnSearchIcon();
}

@When("user open the cart from the top left navigation")
public void user_open_the_cart_from_the_top_left_navigation() throws InterruptedException {
	homePageActions.openCart();
}

@Then("user should verify that the price in the cart is identical to the product page")
public void user_should_verify_that_the_price_in_the_cart_is_identical_to_the_product_page() {
	homePageActions.verifyItemPriceInCart();
}

@Then("user should verify that the subtotal in the cart is identical to the product page")
public void user_should_verify_that_the_subtotal_in_the_cart_is_identical_to_the_product_page() {
	homePageActions.verifySubTotalPriceInCart();
}

@When("user add the next item {string} to the cart by clicking on {string}")
public void user_add_the_next_item_to_the_cart_by_clicking_on(String itemName, String string2) throws InterruptedException {
	homePageActions.clickOnSearchedFirstItem(itemName);
	homePageActions.addSearchedItemToCart();	
	
}

@Then("user should verify that the price in the cart for each items is identical to the product page")
public void user_should_verify_that_the_price_in_the_cart_for_each_items_is_identical_to_the_product_page() {
	homePageActions.verifyEachItemPriceInCart();
}
@Then("user should verify that the subtotal in the cart is sum of all the items added in the cart")
public void user_should_verify_that_the_subtotal_in_the_cart_is_sum_of_all_the_items_added_in_the_cart() {
	homePageActions.verifyTotalPriceInCart();
}

}
