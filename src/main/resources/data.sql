-- Sample data for EXPENSES table
INSERT INTO EXPENSES (description, amount, category, created_at, updated_at, user_id) 
VALUES ('Grocery Shopping', 45.50, 'Food', NOW(), NOW(), 'user1');

INSERT INTO EXPENSES (description, amount, category, created_at, updated_at, user_id) 
VALUES ('Gas Station', 60.00, 'Transportation', NOW(), NOW(), 'user1');

INSERT INTO EXPENSES (description, amount, category, created_at, updated_at, user_id) 
VALUES ('Restaurant Dinner', 85.00, 'Food', NOW(), NOW(), 'user2');

INSERT INTO EXPENSES (description, amount, category, created_at, updated_at, user_id) 
VALUES ('Movie Tickets', 30.00, 'Entertainment', NOW(), NOW(), 'user1');

INSERT INTO EXPENSES (description, amount, category, created_at, updated_at, user_id) 
VALUES ('Gym Membership', 50.00, 'Health', NOW(), NOW(), 'user2');
