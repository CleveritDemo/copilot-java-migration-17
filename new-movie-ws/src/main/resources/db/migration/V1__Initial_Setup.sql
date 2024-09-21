-- src/main/resources/db/migration/V1__Initial_Setup.sql

CREATE TABLE Movie (
                       id INT PRIMARY KEY,
                       name VARCHAR(255),
                       year INT,
                       description TEXT,
                       score DECIMAL(3, 1),
                       director VARCHAR(255),
                       producer VARCHAR(255),
                       languages VARCHAR(255)
);

INSERT INTO Movie (id, name, year, description, score, director, producer, languages) VALUES
                                                                                          (1, 'The Great Adventure', 2021, 'An epic journey of discovery and adventure.', 8.5, 'John Doe', 'Jane Smith', 'English, Spanish'),
                                                                                          (2, 'Mystery of the Lost City', 2019, 'A thrilling mystery set in an ancient city.', 7.8, 'Alice Johnson', 'Bob Brown', 'English, French'),
                                                                                          (3, 'Space Odyssey', 2022, 'A breathtaking voyage through the cosmos.', 9.1, 'Chris Evans', 'Diana Prince', 'English, German'),
                                                                                          (4, 'The Last Stand', 2020, 'A gripping tale of survival and courage.', 8.0, 'Bruce Wayne', 'Clark Kent', 'English, Japanese'),
                                                                                          (5, 'Romance in Paris', 2018, 'A heartwarming love story set in the city of lights.', 7.5, 'Peter Parker', 'Mary Jane', 'English, Italian');