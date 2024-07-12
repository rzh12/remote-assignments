CREATE TABLE assignment.article (
    id INT PRIMARY KEY,
    title VARCHAR(255),
    content TEXT,
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES assignment.user(id)
);

SELECT * FROM assignment.article;

-- Generate fake users
INSERT INTO assignment.user (id, email, password) VALUES
(1, 'user1@example.com', 'password1'),
(2, 'user2@example.com', 'password2'),
(3, 'user3@example.com', 'password3'),
(4, 'user4@example.com', 'password4'),
(5, 'user5@example.com', 'password5');
-- Generate fake data
INSERT INTO assignment.article (id, title, content, author_id) VALUES
(1, 'Title 1', 'Content 1', 5),
(2, 'Title 2', 'Content 2', 4),
(3, 'Title 3', 'Content 3', 3),
(4, 'Title 4', 'Content 4', 4),
(5, 'Title 5', 'Content 5', 5),
(6, 'Title 6', 'Content 6', 5),
(7, 'Title 7', 'Content 7', 1),
(8, 'Title 8', 'Content 8', 2),
(9, 'Title 9', 'Content 9', 2),
(10, 'Title 10', 'Content 10', 1),
(11, 'Title 11', 'Content 11', 3),
(12, 'Title 12', 'Content 12', 2),
(13, 'Title 13', 'Content 13', 4),
(14, 'Title 14', 'Content 14', 1),
(15, 'Title 15', 'Content 15', 5),
(16, 'Title 16', 'Content 16', 3),
(17, 'Title 17', 'Content 17', 2),
(18, 'Title 18', 'Content 18', 4),
(19, 'Title 19', 'Content 19', 4),
(20, 'Title 20', 'Content 20', 1),
(21, 'Title 21', 'Content 21', 2),
(22, 'Title 22', 'Content 22', 2),
(23, 'Title 23', 'Content 23', 2),
(24, 'Title 24', 'Content 24', 4),
(25, 'Title 25', 'Content 25', 4),
(26, 'Title 26', 'Content 26', 3),
(27, 'Title 27', 'Content 27', 1),
(28, 'Title 28', 'Content 28', 5),
(29, 'Title 29', 'Content 29', 2),
(30, 'Title 30', 'Content 30', 3);


-- 1.
SELECT article.*, user.email
FROM assignment.article
JOIN assignment.user ON article.author_id = user.id;

-- 2.
SELECT a.*
FROM assignment.article a
ORDER BY a.id
LIMIT 6 OFFSET 6;
