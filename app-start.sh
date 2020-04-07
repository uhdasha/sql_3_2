#!/bin/bash
#DROP TABLE auth_codes;
mysql -u'netology' -p'pass_0000' netology <<EOF
DROP TABLE auth_codes;
DROP TABLE cards;
DROP TABLE users;
DROP TABLE card_transactions;
EOF
mysql -u'netology' -p'pass_0000' netology < schema.sql
java -jar app-deadline.jar -P:jdbc.url=jdbc:mysql://127.0.0.1:3306/netology?serverTimezone=UTC -P:jdbc.user=netology -P:jdbc.password=pass_0000

