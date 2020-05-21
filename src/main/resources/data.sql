DROP TABLE IF EXISTS books;
 
CREATE TABLE books (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  author VARCHAR(250) NOT NULL,
  cover VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO books (title, author, cover) VALUES
  ('Barker House', 'David Moloney', 'https://149349728.v2.pressablecdn.com/wp-content/uploads/2019/07/Untitled-design-3.png'),
  ('Memories of the Future', 'Siri Hustvedt', 'https://149349728.v2.pressablecdn.com/wp-content/uploads/2019/07/Copy-of-Untitled-Design-2-1.png'),
  ('Homesick', 'Jennifer Croft', 'https://149349728.v2.pressablecdn.com/wp-content/uploads/2019/06/Untitled-design-1.png');