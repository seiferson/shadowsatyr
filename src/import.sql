INSERT INTO system_property ( id, "key", "value", description ) VALUES( nextval( 'system_property_id' ), 'shadowsatyr:index:about', 'Simple Java web CMS', 'Text displayed on about section of index view' )

INSERT INTO account_status ( id, status, description ) VALUES ( 1,  'Active', 'Active account' );

INSERT INTO account ( id, nick_name, passwd, mail, register_date, status ) VALUES ( nextval( 'account_id' ), 'admin', '4fb9a58ff5842b98a6561c77cf50efb1d7d6ac5c57dd48b4737c18ad17b59e7e', 'mail@example.com', NOW( ), 1 );
INSERT INTO account ( id, nick_name, passwd, mail, register_date, status ) VALUES ( nextval( 'account_id' ), 'satyr', '4fb9a58ff5842b98a6561c77cf50efb1d7d6ac5c57dd48b4737c18ad17b59e7e', 'seifernetx@gmail.com', NOW( ), 1 )

INSERT INTO permission ( id, permission, description ) VALUES ( 1, 'shadowsatyr:admin:dashboard', 'Permission to see system dashboard' );

INSERT INTO permission_account ( account, permission ) VALUES ( 1, 1 );

INSERT INTO hashtag ( id, hashtag ) VALUES ( nextval( 'hashtag_id' ), '#code' )
INSERT INTO hashtag ( id, hashtag ) VALUES ( nextval( 'hashtag_id' ), '#hibernate' )
INSERT INTO hashtag ( id, hashtag ) VALUES ( nextval( 'hashtag_id' ), '#shadowsatyr' )
INSERT INTO hashtag ( id, hashtag ) VALUES ( nextval( 'hashtag_id' ), '#firegoblin' )
INSERT INTO hashtag ( id, hashtag ) VALUES ( nextval( 'hashtag_id' ), '#magictg' )
INSERT INTO hashtag ( id, hashtag ) VALUES ( nextval( 'hashtag_id' ), '#github' )

INSERT INTO blog_entry ( id, content, author, "date" ) VALUES ( nextval( 'blog_entry_id' ), 'Help improving shadowsatyr at github!!! #shadowsatyr', 2, NOW( ) );
INSERT INTO blog_entry ( id, content, author, "date" ) VALUES ( nextval( 'blog_entry_id' ), 'This CMS was named shadowsatyr inspired on the TCG game Magic the Gathering #magictg #shadowsatyr', 2, NOW( ) );
INSERT INTO blog_entry ( id, content, author, "date" ) VALUES ( nextval( 'blog_entry_id' ), 'Shadowsatyr uses firegoblin, hibernate, tiles, and many more web frameworks #firegoblin #shadowsatyr #hibernate', 2, NOW( ) );
INSERT INTO blog_entry ( id, content, author, "date" ) VALUES ( nextval( 'blog_entry_id' ), 'Firegoblin implements the MVC pattern, documentation is available at github #firegoblin #github', 2, NOW( ) );
INSERT INTO blog_entry ( id, content, author, "date" ) VALUES ( nextval( 'blog_entry_id' ), 'Goblins are ugly creatures on Magic the Gathering #magictg #firegoblin', 2, NOW( ) );

INSERT INTO hashtag_blog_entry ( blog_entry, hashtag ) VALUES ( 1, 3 );
INSERT INTO hashtag_blog_entry ( blog_entry, hashtag ) VALUES ( 2, 3 );
INSERT INTO hashtag_blog_entry ( blog_entry, hashtag ) VALUES ( 2, 5 );
INSERT INTO hashtag_blog_entry ( blog_entry, hashtag ) VALUES ( 3, 3 );
INSERT INTO hashtag_blog_entry ( blog_entry, hashtag ) VALUES ( 3, 2 );
INSERT INTO hashtag_blog_entry ( blog_entry, hashtag ) VALUES ( 3, 4 );
INSERT INTO hashtag_blog_entry ( blog_entry, hashtag ) VALUES ( 4, 4 );
INSERT INTO hashtag_blog_entry ( blog_entry, hashtag ) VALUES ( 4, 6 );
INSERT INTO hashtag_blog_entry ( blog_entry, hashtag ) VALUES ( 5, 4 );
INSERT INTO hashtag_blog_entry ( blog_entry, hashtag ) VALUES ( 5, 5 );


INSERT INTO article ( id, creation_date, content, author, title, hash ) VALUES ( nextval( 'article_id' ), NOW( ), E'#Front Controller Implementation  \n  \n###Servlets \nAn important topic speaking of java MVC framework implementations is how to handle your servlets, because of they are the first layer of interaction you can control in your application. \n \nIn the stone age there was a common way to control access to different areas in your application: creating a servlet for every action you perform, but that was not a very good idea for many reasons. Starting with the problem that you have to repeat the code for handling the servlet call. Most of the time for example you don''t care about if you want to use doPost or doGet method, you commonly send both to a single method. \n \nAnother con was that big applications imply a lot of actions, that means a lot of servlets, so __A LOT OF paths!!!!!!__. And it''s obviously important to have short and self-explanatory names on our application urls, so multiple servlets make difficult to group and maintain the actions by url like _"/actiongroup/action"_. \n \nThen someone come up with the idea that you can handle different requests using the same servlet ( I actually took the idea from _Struts_ ). But imagine using the same idea of controller code being implemented in the servlet class, makes a con on this unique servlet because of a lot of code written in the same class is difficult to maintain, but don''t worry Front Controller design pattern to the rescue!!!. \n \n###Front Controller \nNow we know that using a single servlet is a good idea we must solve the next problem, and since this is a common problem in every web java system we will take advantage of a common solution: the front controller pattern. I will not explain the pattern ( but I can give you some interesting references at the end ) but  the main idea is to take all the requests using a simple controller, send them to a dispatcher which can classify the request and tell the correct helper to solve this request. \n \nFirst thing we need is this simple controller, in this case we will use the servlet as our controller. \nWhen someone makes a request, the servlet will redirect both doGet and doPost methods to a method called __listen__ which only task is to obtain the last part of URL and send it to the __dispatcher__, the dispatcher must identify if there''s a helper that can solve that request and will delegate the task or if that request name is unknown then an exception or error is raised. \n \nMy idea of how to implement all of this is on the classes __com.seifernet.firegoblin.servlet.DispatcherServlet__, __com.seifernet.firegoblin.servlet.ContextServlet__ and __com.seifernet.firegoblin.dispatcher.ContextDispatcher__. \n \n__The wiki page and the code in general is open to comments an recommendations, you can change the information, make orthographic or syntax corrections, or fork the repo and make pull requests.__  \n \nReferences: \n \n[http://www.oracle.com/technetwork/java/frontcontroller-135648.html](http://www.oracle.com/technetwork/java/frontcontroller-135648.html) \n \n[https://en.wikipedia.org/wiki/Front_Controller_pattern](https://en.wikipedia.org/wiki/Front_Controller_pattern) \n \nContact: \nseifer.ch@gmail.com', 1, 'Front controller implementation', '1f7a6515179b2abd8b0388e5e96991d1428beba2a61097b4258e484c4b774c51' );