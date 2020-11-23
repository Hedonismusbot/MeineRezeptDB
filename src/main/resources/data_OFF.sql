DROP TABLE IF EXISTS todo;

CREATE TABLE IF NOT EXISTS todo (
                                    id INT IDENTITY NOT NULL PRIMARY KEY,
                                    entry VARCHAR (150) NOT NULL,
                                    deadline DATE NULL,
                                    done BOOLEAN NULL
);

INSERT INTO todo(id, entry,deadline) VALUES (1,'einkauf','2020-11-15');
INSERT INTO todo(id ,entry,deadline  ) VALUES (2,'essen','2020-11-15' );