USE reviewanime;

-- Bảng role
CREATE TABLE role(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    
    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL
);

-- Bảng user
CREATE TABLE user(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(150) NOT NULL,
    password VARCHAR(150) NOT NULL,
    fullname VARCHAR(150) NOT NULL,
    status INT NOT NULL,
    roleid BIGINT NOT NULL,
    
    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL,

    FOREIGN KEY (roleid) REFERENCES role(id)
);

-- Bảng category
CREATE TABLE category (
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    
    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL
);

-- Bảng anime
CREATE TABLE anime (
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NULL,
    thumbnail TEXT NULL,
    shortdescription TEXT NULL,
    content TEXT NULL,
    rating FLOAT NULL,
    releaseyear VARCHAR(50) NULL,
    episodes VARCHAR(50) NULL,
    status VARCHAR(50) NULL,
    country VARCHAR(100) NULL,

    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL
);

-- Bảng anime_category
CREATE TABLE animecategory (
    animeid BIGINT NOT NULL,
    categoryid BIGINT NOT NULL,

    PRIMARY KEY (animeid, categoryid),
    FOREIGN KEY (animeid) REFERENCES anime(id),
    FOREIGN KEY (categoryid) REFERENCES category(id)
);


-- Bảng comment
CREATE TABLE comment (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    content TEXT NOT NULL,
    userid BIGINT NOT NULL,
    animeid BIGINT NOT NULL,
    
    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL,

    FOREIGN KEY (userid) REFERENCES user(id),
    FOREIGN KEY (animeid) REFERENCES anime(id)
);
