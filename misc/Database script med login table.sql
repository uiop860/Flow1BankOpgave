INSERT INTO bank.customer(Name, Age, Address) VALUES ("Brian",65,"Fiskevenget");
INSERT INTO bank.Login(username,password,Customer_customerid) VALUE("fisk","23a8cadbee3c6d52a8bdc33aa962f5be",1);
INSERT INTO bank.accounts(balance,customer_customerid) VALUES (1000,1);
INSERT INTO bank.transactions(moneychange,accounts_accountid,accounts_customer_customerid) VALUES (-150,1,1);
INSERT INTO bank.transactions(moneychange,accounts_accountid,accounts_customer_customerid) VALUES (75,1,1);
INSERT INTO bank.transactions(moneychange,accounts_accountid,accounts_customer_customerid) VALUES (-50,1,1);


INSERT INTO bank.customer(Name, Age, Address) VALUES ("Lars",42,"Kagerullen");
INSERT INTO bank.Login(username,password,Customer_customerid) VALUE("kage","a407a87802cb98535d3ef3ca8d62c634",2);
INSERT INTO bank.accounts(balance,customer_customerid) VALUES (1500,2);
INSERT INTO bank.transactions(moneychange,accounts_accountid,accounts_customer_customerid) VALUES (-50,2,2);
INSERT INTO bank.transactions(moneychange,accounts_accountid,accounts_customer_customerid) VALUES (75,2,2);
INSERT INTO bank.transactions(moneychange,accounts_accountid,accounts_customer_customerid) VALUES (-140,2,2);