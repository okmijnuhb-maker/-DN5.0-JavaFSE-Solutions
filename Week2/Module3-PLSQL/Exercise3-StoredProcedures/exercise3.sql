-- Exercise 3: Stored Procedures

-- Scenario 1: Process Monthly Interest for all savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all savings accounts!');
END;
/

-- Execute Scenario 1
BEGIN
    ProcessMonthlyInterest;
END;
/

-- Scenario 2: Update Employee Bonus for a department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percent / 100)
    WHERE Department = p_department;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus updated for department: ' || p_department);
END;
/

-- Execute Scenario 2
BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/

-- Scenario 3: Transfer Funds between accounts
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- Check source account balance
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;
    
    -- If sufficient balance transfer funds
    IF v_balance >= p_amount THEN
        -- Deduct from source account
        UPDATE Accounts
        SET Balance = Balance - p_amount,
            LastModified = SYSDATE
        WHERE AccountID = p_from_account;
        
        -- Add to destination account
        UPDATE Accounts
        SET Balance = Balance + p_amount,
            LastModified = SYSDATE
        WHERE AccountID = p_to_account;
        
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer successful! Amount: $' || p_amount);
    ELSE
        DBMS_OUTPUT.PUT_LINE('Transfer failed! Insufficient balance!');
    END IF;
END;
/

-- Execute Scenario 3
BEGIN
    TransferFunds(1, 2, 500);
END;
/