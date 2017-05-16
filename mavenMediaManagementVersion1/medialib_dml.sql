INSERT INTO Actor (actor_name, actor_description, actor_id) VALUES 
("Matt Damon", "Plays action roles for the most part.", 1),
("Ben Affleck", "Plays Batman now. Also a director.", 2),
("Chris Pratt", "Plays immature man-children characters.", 3),
("Tom Hardy", "English actor who typically plays loner roles.", 4),
("Amy Adams", "American actress. Well-rounded in her roles.", 5);

INSERT INTO Artist (artist_id, name, background) VALUES
(1, "David Bowie", "Pop rock artist." ),
(2, "Ozzy Osbourne", "Metal and hard rock siner" ),
(3, "Queen", "Pop rock artist"),
(4, "Guns N' Roses", "Hard rock artist"),
(5, "Van Halen", "Hard rock artist");

INSERT INTO Author (author_id, name, background) VALUES
(1, "Niel Gaiman", "Fantasy fiction and comic book author."),
(2, "Ernest Hemingway", "Realistic fiction author."),
(3, "J.K. Rowling", "Fantasy fiction author."),
(4, "Aldous Huxley", "Science fiction author."),
(5, "George Orwell", "Political fiction author");

INSERT INTO Director (director_id, director_description, name) VALUES
(1, "Makes films intended to confuse but entertain the audience", "Christopher Nolan"),
(2, "Makes science fiction and action films", "Steven Speilberg"),
(3, "Makes science fiction movies and a horrid, unoriginal Star Wars", "JJ Abrams"),
(4, "Makes films with explosions", "Micheal Bay"),
(5, "Makes thriller and mystery films", "Davic FIncher");

---------American Gods, A Farewell to Arms, Harry Potter and Sorcerer's Stone, Animsl Farm------
INSERT INTO Book (upc, isbn) VALUES 
(0062472100, "978-0062472106"),
(1476764522, "978-1476764528"),
(0439708184, "978-0439708180"),
(0060850523, "978-0060850524"),
(8187138750, "978-8187138754");

------Heroes; Ozzmosis; Jazz; Appetite for Destruction; Best of Both Worlds
INSERT INTO CD (upc) VALUES
("B00001OH7V"),
("B0054YH730"),
("000000OAH"),
("B000000OQF"),
("B000286S8S");

---------For CD Heroes; UPC:B00001OH7V---------
INSERT INTO TrackTitle (track_id, track_title, track_run_time, track_background) VALUES
(1, "Beauty and the Beast", 3, "First song on Heroes album"),
(2, "Joe the Lion", 3, "Second song on Heroes album"),
(3, "Heroes", 6, "Third song on Heroes album");

--------For CD Ozzmosis; UPC: B0054YH730------------------- 
INSERT INTO TrackTitle (track_id, track_title, track_run_time, track_background) VALUES
(4, "Perry Mason", 6, "First track on Ozzmosis "),
(5, "I Just Want You", 5, "Second track on Ozzmosis"),
(6, "Ghost Behind My Eyes", 5, "Third track on Ozzmosis");

-------For CD: Jazz; UPC: 000000OAH---------
INSERT INTO TrackTitle (track_id, track_title, track_run_time, track_background) VALUES
(7, "If You Can't Beat Them", 4, "Song on album Jazz"),
(8, "Let Me Entertain You", 3, "Song on album Jazz"),
(9, "Dead On Time", 3, "Song on album Jazz");

------For CD: Appetite for Destruction; UPC: B000000OQF---------
INSERT INTO TrackTitle (track_id, track_title, track_run_time, track_background) VALUES
(10, "Welcome to the Jungle", 4, "Song on album Appetite for Destruction"),
(11, "It's So Easy", 3, "Song on album Appetite for Destruction"),
(12, "Nightrain", 4, "Song on album Appetite for Destruction");

-------For CD: Best of Both Worlds; UPC: B000286S8S------
INSERT INTO TrackTitle (track_id, track_title, track_run_time, track_background) VALUES
(13, "Eruption", 2, "Song on album Best of Both Worlds"),
(14, "It's About Time", 4, "Song on album Best of Both Worlds"),
(15, "Learning to See", 5, "Song on album Best of Both Worlds");

