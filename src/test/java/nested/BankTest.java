package nested;

import com.luxoft.javabdd.bank.BusinessCreditOffer;
import com.luxoft.javabdd.bank.Customer;
import com.luxoft.javabdd.bank.EconomyCreditOffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BankTest {

    private final Customer vipCustomer = new Customer("VIP", true);
    private final Customer usualCustomer = new Customer("USUAL", false);
    private final BusinessCreditOffer businessCreditOffer = new BusinessCreditOffer("1");
    private final EconomyCreditOffer economyCreditOffer = new EconomyCreditOffer("2");

    @Nested
    @DisplayName("Given there is a business credit offer")
    class BusinessCreditOfferTest {

        @Nested
        @DisplayName("When we have a VIP customer")
        class VipCustomer {

            @Test
            @DisplayName("Then you can add him but cannot remove him from a business credit offer")
            void shouldAddCustomerGivenHeIsVIPButCannotBeRemoved() {
                assertAll(() -> {
                    assertTrue(businessCreditOffer.addCustomer(vipCustomer));
                    assertFalse(businessCreditOffer.removeCustomer(vipCustomer));
                });
            }
        }

        @Nested
        @DisplayName("When we have a usual customer")
        class UsualCustomer {

            @Test
            @DisplayName("Then you can add or remove him from a business credit offer")
            void shouldAddCustomerGivenHeIsUsualAndCanBeRemoved() {
                assertAll(() -> {
                    assertFalse(businessCreditOffer.addCustomer(usualCustomer));
                    assertFalse(businessCreditOffer.getCustomersSet().contains(usualCustomer));
                });
            }
        }
    }

    @Nested
    @DisplayName("Given there is an economy credit offer")
    class EconomyCreditOfferTest {

        @Nested
        @DisplayName("When we have a VIP customer")
        class VipCustomer {

            @Test
            @DisplayName("Then you can add him but cannot remove him from an economy credit offer")
            void shouldAddCustomerGivenHeIsVIPButCannotBeRemoved() {
                assertAll(() -> {
                    assertTrue(economyCreditOffer.addCustomer(vipCustomer));
                    assertFalse(economyCreditOffer.removeCustomer(vipCustomer));
                });
            }
        }

        @Nested
        @DisplayName("When we have a usual customer")
        class UsualCustomer {

            @Test
            @DisplayName("Then you can add and remove him from an economy credit offer")
            void shouldAddCustomerGivenHeIsUsualAndCanBeRemoved() {
                assertAll(() -> {
                    assertTrue(economyCreditOffer.addCustomer(usualCustomer));
                    assertTrue(economyCreditOffer.removeCustomer(usualCustomer));
                });
            }
        }
    }
}
