package tests;

import Utils.EmailValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class EmailValidatorTest {
   // Valid inputs
   @Test
   public void testValidEmails() {
       assertTrue(EmailValidator.isValidEmail("test@example.com"));
       assertTrue(EmailValidator.isValidEmail("user.name+tag@domain.co.in"));
       assertTrue(EmailValidator.isValidEmail("simple123@domain.org"));
       System.out.println("Tested Valid emails");
   }
   // Invalid inputs
   @Test
   public void testInvalidEmails() {
       assertFalse(EmailValidator.isValidEmail("plainaddress"));
       assertFalse(EmailValidator.isValidEmail("@no-local-part.com"));
       assertFalse(EmailValidator.isValidEmail("user@.invalid.com"));
       assertFalse(EmailValidator.isValidEmail("user@domain..com"));
       System.out.println("Tested invalid email");
   }
   // Edge cases
   @Test
   public void testEdgeCases() {
       assertFalse(EmailValidator.isValidEmail(null));
       assertFalse(EmailValidator.isValidEmail(""));
       assertFalse(EmailValidator.isValidEmail("   ")); // spaces only
   }
}