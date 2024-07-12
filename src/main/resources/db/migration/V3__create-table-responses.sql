CREATE TABLE responses (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    message VARCHAR(500) NOT NULL,
    topic_id INT NOT NULL,
    created_at DATETIME DEFAULT (CURRENT_TIMESTAMP),
    solution TINYINT DEFAULT 0

);