package Banking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testValidDeposit() {
        BankAccount acc = new BankAccount();
        acc.deposit(200);
        assertEquals(200, acc.getBalance());
        assertTrue(acc.isActive());
    }

    @Test
    void testNegativeDepositThrowsException() {
        BankAccount acc = new BankAccount();
        assertThrows(IllegalArgumentException.class, () -> acc.deposit(-50));
    }

    @Test
    void testValidWithdrawalKeepsActive() {
        BankAccount acc = new BankAccount();
        acc.deposit(500);
        acc.withdraw(100);
        assertEquals(400, acc.getBalance());
        assertTrue(acc.isActive());
    }

    @Test
    void testWithdrawalCausesInactivity() {
        BankAccount acc = new BankAccount();
        acc.deposit(150);
        acc.withdraw(60);
        assertEquals(90, acc.getBalance());
        assertFalse(acc.isActive());
    }

    @Test
    void testOverdraftThrowsException() {
        BankAccount acc = new BankAccount();
        acc.deposit(50);
        assertThrows(IllegalStateException.class, () -> acc.withdraw(100));
    }
}