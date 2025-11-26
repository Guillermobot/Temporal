package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void constructor_withAccountNumber_createsAccount() {
        // Arrange & Act
        var account = new BankAccount("ACC001");

        // Assert
        assertEquals(0.0, account.getBalance());
        assertTrue(account.isActive());
    }

    @Test
    void constructor_withInitialBalance_createsAccountWithBalance() {
        // Arrange & Act
        var account = new BankAccount("ACC001", 100.0);

        // Assert
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void constructor_withNullAccountNumber_throwsException() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(null);
        });
    }

    @Test
    void constructor_withNegativeBalance_throwsException() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount("ACC001", -100.0);
        });
    }

    @Test
    void deposit_withValidAmount_increasesBalance() {
        // Arrange
        var account = new BankAccount("ACC001", 100.0);

        // Act
        account.deposit(50.0);

        // Assert
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void deposit_withZero_throwsException() {
        // Arrange
        var account = new BankAccount("ACC001", 100.0);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(0.0);
        });
    }

    @Test
    void deposit_withNegative_throwsException() {
        // Arrange
        var account = new BankAccount("ACC001", 100.0);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50.0);
        });
    }

    @Test
    void deposit_toInactiveAccount_throwsException() {
        // Arrange
        var account = new BankAccount("ACC001", 100.0);
        account.closeAccount();

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> {
            account.deposit(50.0);
        });
    }

    @Test
    void withdraw_withValidAmount_decreasesBalance() {
        // Arrange
        var account = new BankAccount("ACC001", 100.0);

        // Act
        account.withdraw(30.0);

        // Assert
        assertEquals(70.0, account.getBalance());
    }

    @Test
    void withdraw_moreThanBalance_throwsException() {
        // Arrange
        var account = new BankAccount("ACC001", 100.0);

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> {
            account.withdraw(150.0);
        });
    }

    @Test
    void withdraw_withZero_throwsException() {
        // Arrange
        var account = new BankAccount("ACC001", 100.0);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(0.0);
        });
    }

    @Test
    void withdraw_fromInactiveAccount_throwsException() {
        // Arrange
        var account = new BankAccount("ACC001", 100.0);
        account.closeAccount();

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> {
            account.withdraw(30.0);
        });
    }

    @Test
    void closeAccount_setsInactive() {
        // Arrange
        var account = new BankAccount("ACC001", 100.0);

        // Act
        account.closeAccount();

        // Assert
        assertFalse(account.isActive());
    }

    @Test
    void transfer_withValidAmount_transfersCorrectly() {
        // Arrange
        var account = new BankAccount("ACC001", 100.0);
        var target = new BankAccount("ACC002", 50.0);

        // Act
        account.transfer(target, 30.0);

        // Assert
        assertEquals(70.0, account.getBalance());
        assertEquals(80.0, target.getBalance());
    }

    @Test
    void transfer_withNullTarget_throwsException() {
        // Arrange
        var account = new BankAccount("ACC001", 100.0);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            account.transfer(null, 30.0);
        });
    }

    @Test
    void transfer_fromInactiveAccount_throwsException() {
        // Arrange
        var account = new BankAccount("ACC001", 100.0);
        var target = new BankAccount("ACC002", 50.0);
        account.closeAccount();

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> {
            account.transfer(target, 30.0);
        });
    }

    @Test
    void transfer_toInactiveAccount_throwsException() {
        // Arrange
        var account = new BankAccount("ACC001", 100.0);
        var target = new BankAccount("ACC002", 50.0);
        target.closeAccount();

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> {
            account.transfer(target, 30.0);
        });
    }
}