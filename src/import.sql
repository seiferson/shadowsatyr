INSERT INTO account_status ( id, status, description ) VALUES ( 1,  'Active', 'Active account' );

INSERT INTO account ( id, nick_name, passwd, mail, register_date, status ) VALUES ( nextval( 'account_id' ), 'admin', '4fb9a58ff5842b98a6561c77cf50efb1d7d6ac5c57dd48b4737c18ad17b59e7e', 'mail@example.com', NOW( ), 1 );

INSERT INTO permission ( id, permission, description ) VALUES ( 1, 'shadowsatyr:admin:dashboard', 'Permission to see system dashboard' );
INSERT INTO permission ( id, permission, description ) VALUES ( 2, 'shadowsatyr:test:execute', 'Permission to access test area' );

INSERT INTO permission_account ( account, permission ) VALUES ( 1, 1 );