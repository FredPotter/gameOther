INSERT INTO category (id, name) VALUES
    (nextval('category_seq'), 'Серебро'),
    (nextval('category_seq'), 'Золото'),
    (nextval('category_seq'), 'Аккаунты'),
    (nextval('category_seq'), 'Предметы'),
    (nextval('category_seq'), 'Услуги'),
    (nextval('category_seq'), 'Разное'),
    (nextval('category_seq'), 'Ключи'),
    (nextval('category_seq'), 'Прокачка'),
    (nextval('category_seq'), 'Обучение');

INSERT INTO country(id, name) VALUES
    (nextval('country_seq'), 'Russia'),
    (nextval('country_seq'), 'Ukraine'),
    (nextval('country_seq'), 'Belarus'),
    (nextval('country_seq'), 'Kazakhstan'),
    (nextval('country_seq'), 'Uzbekistan'),
    (nextval('country_seq'), 'Azerbaijan'),
    (nextval('country_seq'), 'Moldova'),
    (nextval('country_seq'), 'Kyrgyzstan'),
    (nextval('country_seq'), 'Tajikistan'),
    (nextval('country_seq'), 'Turkmenistan'),
    (nextval('country_seq'), 'Georgia'),
    (nextval('country_seq'), 'Armenia');

INSERT INTO game(id, name, path_to_poster) VALUES
    (nextval('game_seq'), 'Counter-Strike: Global Offensive', 'https://steamcdn-a.akamaihd.net/steam/apps/730/header.jpg?t=1615820073'),
    (nextval('game_seq'), 'Dota 2', 'https://steamcdn-a.akamaihd.net/steam/apps/570/header.jpg?t=1615820073'),
    (nextval('game_seq'), 'PUBG: BATTLEGROUNDS', 'https://steamcdn-a.akamaihd.net/steam/apps/578080/header.jpg?t=1615820073'),
    (nextval('game_seq'), 'Rust', 'https://steamcdn-a.akamaihd.net/steam/apps/252490/header.jpg?t=1615820073'),
    (nextval('game_seq'), 'Garry''s Mod', 'https://steamcdn-a.akamaihd.net/steam/apps/4000/header.jpg?t=1615820073'),
    (nextval('game_seq'), 'Team Fortress 2', 'https://steamcdn-a.akamaihd.net/steam/apps/440/header.jpg?t=1615820073'),
    (nextval('game_seq'), 'ARK: Survival Evolved', 'https://steamcdn-a.akamaihd.net/steam/apps/346110/header.jpg?t=1615820073'),
    (nextval('game_seq'), 'Grand Theft Auto V', 'https://steamcdn-a.akamaihd.net/steam/apps/271590/header.jpg?t=1615820073'),
    (nextval('game_seq'), 'Rust', 'https://steamcdn-a.akamaihd.net/steam/apps/252490/header.jpg?t=1615820073'),
    (nextval('game_seq'), 'Dead by Daylight', 'https://steamcdn-a.akamaihd.net/steam/apps/381210/header.jpg?t=1615820073'),
    (nextval('game_seq'), 'PAYDAY 2', 'https://steamcdn-a.akamaihd.net/steam/apps/218620/header.jpg?t=1615820073'),
    (nextval('game_seq'), 'Warframe', 'https://steamcdn-a.akamaihd.net/steam/apps/230410/header.jpg?t=1615820073');
