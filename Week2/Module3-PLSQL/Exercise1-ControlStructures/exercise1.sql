-- Exercise 1: Control Structures

-- Scenario 1: Apply 1% discount on loan interest rate for customers above 60
DECLARE
    CURSOR c_customers IS
        SELECT c.CustomerID, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID;
    v_age NUMBER;
BEGIN
    FOR rec IN c_customers LOOP
        -- Calculate age
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, 
                 (SELECT DOB FROM Customers 
                  WHERE CustomerID = rec.CustomerID)) / 12);
        
        -- If age > 60 apply 1% discount
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;
            
            DBMS_OUTPUT.PUT_LINE('Discount applied for CustomerID: ' 
                                  || rec.CustomerID);
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Scenario 1 completed!');
END;
/

-- Scenario 2: Set IsVIP = TRUE for customers with balance over $10,000
DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Balance FROM Customers;
BEGIN
    FOR rec IN c_customers LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('VIP status set for CustomerID: ' 
                                  || rec.CustomerID);
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Scenario 2 completed!');
END;
/

-- Scenario 3: Print reminders for loans due in next 30 days
DECLARE
    CURSOR c_loans IS
        SELECT l.LoanID, l.CustomerID, l.EndDate, c.Name
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR rec IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || rec.Name || 
                             ', your loan ID ' || rec.LoanID || 
                             ' is due on ' || 
                             TO_CHAR(rec.EndDate, 'YYYY-MM-DD'));
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Scenario 3 completed!');
END;
/