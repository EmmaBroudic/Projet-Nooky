CREATE TABLE "nooky_user" (
    User_Id UUID PRIMARY KEY UNIQUE,
    User_Pseudo VARCHAR(50) NOT NULL,
    User_First_Name VARCHAR(50) NOT NULL,
    User_LastName VARCHAR(50) NOT NULL,
    User_Picture_URL VARCHAR(255),
    User_Email VARCHAR(100) UNIQUE NOT NULL,
    User_Password VARCHAR(100) NOT NULL,
    User_Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE "product" (
    Product_Id UUID PRIMARY KEY UNIQUE,
    Product_Name VARCHAR(50) NOT NULL,
    Product_Picture_URL VARCHAR(255),
    Product_Description VARCHAR(400),
    Product_Transaction VARCHAR(50) CHECK (Transaction_Type IN ('sale', 'exchange', 'donate')) NOT NULL
    Product_Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    User_Id UUID,
    Transaction_Id UUID,
    FOREIGN KEY (User_Id) REFERENCES nooky_user (User_Id),
    FOREIGN KEY (Transaction_Id) REFERENCES transaction (Transaction_Id),
);

CREATE TABLE "community" (
    Community_Id UUID PRIMARY KEY UNIQUE,
    Community_Name VARCHAR(50) NOT NULL,
    Community_Picture_URL VARCHAR(255),
    Community_Description VARCHAR(400),
    Community_Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Admin_Id UUID,
    FOREIGN KEY (Admin_Id) REFERENCES community_admin (Admin_Id)
);

CREATE TABLE "community_admin" (
    Admin_Id UUID PRIMARY KEY UNIQUE,
    Admin_Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Community_Id UUID,
    User_Id UUID,
    FOREIGN KEY (Community_Id) REFERENCES community (Community_Id),
    FOREIGN KEY (User_Id) REFERENCES nooky_user (User_Id)
);

CREATE TABLE "community_member" (
    Member_Id UUID PRIMARY KEY UNIQUE,
    Member_Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Community_Id UUID,
    User_Id UUID,
    FOREIGN KEY (Community_Id) REFERENCES community (Community_Id),
    FOREIGN KEY (User_Id) REFERENCES nooky_user (User_Id)
);

CREATE TABLE "category" (
    Category_Id UUID PRIMARY KEY UNIQUE,
    Category_Name VARCHAR(50) NOT NULL,
    Category_Description VARCHAR(200),
    Category_Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE "category_products" (
    Product_Id UUID,
    Category_Id UUID,
    FOREIGN KEY (Product_Id) REFERENCES product (Product_Id),
    FOREIGN KEY (Category_Id) REFERENCES category (Category_Id)
);

CREATE TABLE "community_users" (
    Community_Id UUID,
    User_Id UUID,
    FOREIGN KEY (Community_Id) REFERENCES community (Community_Id),
    FOREIGN KEY (User_Id) REFERENCES nooky_user (User_Id)
);