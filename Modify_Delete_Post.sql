-- Dodanie nowego posta do tabeli POSTS
INSERT INTO POSTS (USER_ID, BODY) VALUES (1, 'This is a new post');

-- Modyfikacja wartości pola BODY w dodanym rekordzie
UPDATE POSTS SET BODY = 'To delete' WHERE BODY = 'This is a new post';

-- Usunięcie dodanego przed chwilą rekordu
DELETE FROM POSTS WHERE BODY = 'To delete';
