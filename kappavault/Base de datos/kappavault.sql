SET SQL_SAFE_UPDATES = 0;

USE Kappavault;
SELECT * FROM obra;

INSERT INTO obra (titulo, tipo, genero, anio, imagen_url) VALUES
('Frieren', 'Anime', 'Aventura', 2021, 'https://manganim.fr/cdn/shop/files/frieren-integrale-tomes-1-a-12-ki-oon_1080x.jpg?v=1731248993');

INSERT INTO obra (titulo, tipo, genero, anio, imagen_url) VALUES
('Attack on Titan', 'Anime', 'Acción', 2013, 'https://cdn.myanimelist.net/images/anime/10/47347l.jpg'),

('Death Note', 'Anime', 'Thriller', 2006, 'https://cdn.myanimelist.net/images/anime/9/9453l.jpg'),

('One Piece', 'Anime', 'Aventura', 1999, 'https://cdn.myanimelist.net/images/anime/6/73245l.jpg'),

('Naruto', 'Anime', 'Shonen', 2002, 'https://cdn.myanimelist.net/images/anime/13/17405l.jpg'),

('Demon Slayer', 'Anime', 'Acción', 2019, 'https://cdn.myanimelist.net/images/anime/1286/99889l.jpg'),

('Jujutsu Kaisen', 'Anime', 'Sobrenatural', 2020, 'https://cdn.myanimelist.net/images/anime/1171/109222l.jpg'),

('Tokyo Ghoul', 'Anime', 'Oscuro', 2014, 'https://cdn.myanimelist.net/images/anime/1498/134443l.jpg'),

('Fullmetal Alchemist Brotherhood', 'Anime', 'Fantasía', 2009, 'https://cdn.myanimelist.net/images/anime/1223/96541l.jpg'),

('Bleach', 'Anime', 'Acción', 2004, 'https://cdn.myanimelist.net/images/anime/3/40451l.jpg'),

('Chainsaw Man', 'Anime', 'Horror', 2022, 'https://cdn.myanimelist.net/images/anime/1806/126216l.jpg'),

('Berserk', 'Manga', 'Oscuro', 1989, 'https://cdn.myanimelist.net/images/manga/1/157897l.jpg'),

('Vagabond', 'Manga', 'Samurai', 1998, 'https://cdn.myanimelist.net/images/manga/1/259070l.jpg'),

('Monster', 'Manga', 'Psicológico', 1994, 'https://cdn.myanimelist.net/images/manga/3/258224l.jpg'),

('Vinland Saga', 'Manga', 'Histórico', 2005, 'https://cdn.myanimelist.net/images/manga/2/188925l.jpg'),

('Solo Leveling', 'Manga', 'Fantasia', 2018, 'https://cdn.myanimelist.net/images/manga/3/222295l.jpg'),

('Blue Lock', 'Manga', 'Deportes', 2018, 'https://cdn.myanimelist.net/images/manga/2/242134l.jpg'),

('Haikyuu!!', 'Anime', 'Deportes', 2014, 'https://cdn.myanimelist.net/images/anime/7/76014l.jpg'),

('Steins Gate', 'Anime', 'Sci-Fi', 2011, 'https://cdn.myanimelist.net/images/anime/5/73199l.jpg'),

('Code Geass', 'Anime', 'Mecha', 2006, 'https://cdn.myanimelist.net/images/anime/5/50331l.jpg'),

('Hunter x Hunter', 'Anime', 'Aventura', 2011, 'https://cdn.myanimelist.net/images/anime/1337/99013l.jpg');

SET SQL_SAFE_UPDATES = 1;