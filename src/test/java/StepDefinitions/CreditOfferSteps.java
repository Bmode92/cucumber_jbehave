package StepDefinitions;


import com.luxoft.javabdd.bank.BusinessCreditOffer;
import com.luxoft.javabdd.bank.Customer;
import com.luxoft.javabdd.bank.EconomyCreditOffer;
import com.luxoft.javabdd.bank.PremiumCreditOffer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class CreditOfferSteps {

    private BusinessCreditOffer businessCreditOffer;
    private EconomyCreditOffer economyCreditOffer;
    private PremiumCreditOffer premiumCreditOffer;
    private Customer customer;

    @Given("There is a business credit offer")
    public void createBusinessCreditOffer() {
        businessCreditOffer = new BusinessCreditOffer("1");
    }

    @When("We have a {} customer named {}")
    public void weHaveAVipCustomer(String type, String name) {
        boolean isVip = type.equalsIgnoreCase("vip");
        customer = new Customer(name, isVip);
    }

    @Then("Add customer to a business credit offer")
    public void addCustomerToBusinessCreditOffer() {
        businessCreditOffer.addCustomer(customer);
    }

    @Then("Customer is added to a business credit offer")
    public void verifyCustomerIsAddedToBusinessCreditOffer() {
        assertTrue(businessCreditOffer.getCustomersSet().contains(customer));
    }

    @And("Customer cannot be removed from a business credit offer")
    public void customerCannotBeRemovedFromABusinessCreditOffer() {
        assertAll(() -> {
            assertFalse(businessCreditOffer.removeCustomer(customer));
            assertTrue(businessCreditOffer.getCustomersSet().contains(customer));
        });
    }

    @And("Customer can be removed from a business credit offer")
    public void customerCanBeRemovedFromABusinessCreditOffer() {
        assertAll(() -> {
            assertTrue(businessCreditOffer.removeCustomer(customer));
            assertFalse(businessCreditOffer.getCustomersSet().contains(customer));
        });
    }

    @Given("There is an economy credit offer")
    public void thereIsAnEconomyCreditOffer() {
        economyCreditOffer = new EconomyCreditOffer("2");
    }

    @And("Add customer to an economy credit offer")
    public void addCustomerToAnEconomyCreditOffer() {
        economyCreditOffer.addCustomer(customer);
    }

    @Then("Customer is added to an economy credit offer")
    public void customerIsAddedToAnEconomyCreditOffer() {
        assertTrue(economyCreditOffer.getCustomersSet().contains(customer));
    }

    @And("Customer cannot be removed from an economy credit offer")
    public void customerCannotBeRemovedFromAnEconomyCreditOffer() {
        assertAll(() -> {
            assertFalse(economyCreditOffer.removeCustomer(customer));
            assertTrue(economyCreditOffer.getCustomersSet().contains(customer));
        });
    }

    @And("Customer can be removed from an economy credit offer")
    public void customerCanBeRemovedFromAnEconomyCreditOffer() {
        assertAll(() -> {
            assertTrue(economyCreditOffer.removeCustomer(customer));
            assertFalse(economyCreditOffer.getCustomersSet().contains(customer));
        });
    }

    @Then("Customer cannot be added to a business credit offer")
    public void customerCannotBeAddedToABusinessCreditOffer() {
        assertAll(() -> {
            assertFalse(businessCreditOffer.addCustomer(customer));
            assertFalse(businessCreditOffer.getCustomersSet().contains(customer));
        });
    }

    @Given("There is a premium credit offer")
    public void thereIsAPremiumCreditOffer() {
        premiumCreditOffer = new PremiumCreditOffer("3");
    }

    @And("Add customer to a premium credit offer")
    public void addCustomerToAPremiumCreditOffer() {
        premiumCreditOffer.addCustomer(customer);
    }

    @Then("Customer is added to a premium credit offer")
    public void customerIsAddedToAPremiumCreditOffer() {
        assertTrue(premiumCreditOffer.getCustomersSet().contains(customer));
    }

    @And("Customer can be removed from a premium credit offer")
    public void customerCanBeRemovedFromAPremiumCreditOffer() {
        assertAll(() -> {
            assertTrue(premiumCreditOffer.removeCustomer(customer));
            assertFalse(premiumCreditOffer.getCustomersSet().contains(customer));
        });
    }

    @Then("Customer cannot be added to a premium credit offer")
    public void customerCannotBeAddedToAPremiumCreditOffer() {
        assertAll(() -> {
            assertFalse(premiumCreditOffer.addCustomer(customer));
            assertFalse(premiumCreditOffer.getCustomersSet().contains(customer));
        });
    }

    @Then("Customer cannot be added more than once to a business credit offer")
    public void customerCannotBeAddedMoreThanOnceToBusinessCreditOffer() {
        assertFalse(businessCreditOffer.addCustomer(customer));
    }

    @Then("Customer cannot be added more than once to an economy credit offer")
    public void customerCannotBeAddedMoreThanOnceToAnEconomyCreditOffer() {
        assertFalse(economyCreditOffer.addCustomer(customer));
    }

    @Then("Customer cannot be added more than once to a premium credit offer")
    public void customerCannotBeAddedMoreThanOnceToAPremiumCreditOffer() {
        assertFalse(premiumCreditOffer.addCustomer(customer));
    }

    @Then("Customer bonus points should be {}")
    public void customerBonusPointsShouldBe(int points) {
        assertEquals(points, customer.getBonusPoints());
    }
}
