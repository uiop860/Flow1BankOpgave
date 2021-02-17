INSERT INTO bank.customer(Name, Age, Address) VALUES ("Brian",65,"Fiskevenget");
INSERT INTO bank.accounts(balance,customer_customerid) VALUES (1000,1);
INSERT INTO bank.transactions(moneychange,accounts_accountid,accounts_customer_customerid) VALUES (-150,1,1);
INSERT INTO bank.transactions(moneychange,accounts_accountid,accounts_customer_customerid) VALUES (75,1,1);
INSERT INTO bank.transactions(moneychange,accounts_accountid,accounts_customer_customerid) VALUES (-50,1,1);

INSERT INTO bank.customer(Name, Age, Address) VALUES ("Lars",42,"Kagerullen");
INSERT INTO bank.accounts(balance,customer_customerid) VALUES (1500,2);
INSERT INTO bank.transactions(moneychange,accounts_accountid,accounts_customer_customerid) VALUES (-50,2,2);
INSERT INTO bank.transactions(moneychange,accounts_accountid,accounts_customer_customerid) VALUES (75,2,2);
INSERT INTO bank.transactions(moneychange,accounts_accountid,accounts_customer_customerid) VALUES (-140,2,2);