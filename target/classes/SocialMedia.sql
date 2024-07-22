-- Drop existing tables if they exist
DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS account;

-- Create the 'account' table
CREATE TABLE account (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255)
);

-- Create the 'message' table
CREATE TABLE message (
    message_id INT PRIMARY KEY AUTO_INCREMENT,
    posted_by INT,
    message_text VARCHAR(255),
    time_posted_epoch BIGINT,
    FOREIGN KEY (posted_by) REFERENCES account(account_id)
);

-- Insert initial data into the 'account' table
INSERT INTO account (username, password) VALUES ('testuser1', 'password');

-- Insert initial data into the 'message' table
INSERT INTO message (posted_by, message_text, time_posted_epoch) VALUES (1, 'test message 1', 1669947792);
