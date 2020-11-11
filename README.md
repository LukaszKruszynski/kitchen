# kitchen
REST API Kitchen Manager
FRONTEND https://github.com/LukaszKruszynski/kitchen_frontend
Hello in my first REST API application!
To configure you must create MySQL database named "kitchen_manager" then change username and password in application.properties in root directory.
Application use scheduled to send mail once a day so important think is create system variables "MAIL_USERNAME" and "MAIL_PASSWORD" then set values.
Default supplier is Google mail , if you prefer diferent email host localization change values "spring.mail.host" and "spring.mail.port" in application.properties.
Make up admin fields in application.properties.
Server port = 9090.
The program is still in beta version , you may run into errors.

