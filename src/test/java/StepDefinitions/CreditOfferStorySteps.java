//package StepDefinitions;
//
//import com.luxoft.javabdd.bank.BusinessCreditOffer;
//import com.luxoft.javabdd.bank.Customer;
//import org.jbehave.core.annotations.Given;
//import org.jbehave.core.annotations.Then;
//import org.jbehave.core.annotations.When;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class CreditOfferStorySteps {
//
//    private BusinessCreditOffer businessCreditOffer;
//    private Customer customer;
//
//    @Given("There is a business credit offer")
//    public void createBusinessCreditOffer() {
//        businessCreditOffer = new BusinessCreditOffer("1");
//    }
//
//    @When("We have a $customer customer named $name")
//    public void createCustomer(String type, String name) {
//        boolean isVip = type.equalsIgnoreCase("vip");
//        customer = new Customer(name, isVip);
//    }
//
//    @When("We add customer to a business credit offer")
//    public void addCustomerToBusinessCreditOffer() {
//        businessCreditOffer.addCustomer(customer);
//    }
//
//    @Then("Customer is added to a business credit offer")
//    public void checkCustomerIsAddedToBusinessCreditOffer() {
//        assertTrue(businessCreditOffer.getCustomersSet().contains(customer));
//    }
//
//    @Then("Customer cannot be removed from a business credit offer")
//    public void customerCannotBeRemovedFromBusinessCreditOffer() {
//        assertAll(() -> {
//            assertFalse(businessCreditOffer.removeCustomer(customer));
//            assertTrue(businessCreditOffer.getCustomersSet().contains(customer));
//        });
//    }
//
//    @Then("Customer cannot be added to a business credit offer")
//    public void customerCannotBeAddedToBusinessCreditOffer() {
//        assertAll(() -> {
//            assertFalse(businessCreditOffer.addCustomer(customer));
//            assertFalse(businessCreditOffer.getCustomersSet().contains(customer));
//        });
//    }
//}
//
//
