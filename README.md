# mail-send-spring-boot-app

We need to add mail dependency in pom.xml

<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>


add property inside properties file

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=
spring.mail.password=
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true



![Screenshot (103)](https://github.com/TiwariKrishna/mail-send-spring-boot-app/assets/125963691/02c6742a-2672-49e8-aa19-7f19f7726b64)

![Screenshot (105)](https://github.com/TiwariKrishna/mail-send-spring-boot-app/assets/125963691/d19c5515-9f78-4589-a516-ddd4f52d1bfc)


