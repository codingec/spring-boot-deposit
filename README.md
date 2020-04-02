# CHALLANGE 

1. git clone {PROJECT} 
2. cd spring-boot-deposit
3. Change password and database /src/main/resources/application.properties
4. mvn spring-boot:run
5. Sign in with user  admin password admin


	<build>
	<finalName>demo</finalName>
		<plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.2.2</version>
                <configuration>
                    <failOnMissingWebXml>false</failOnMissingWebXml>
                </configuration>
            </plugin>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
            <plugin>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.10</version>
                <configuration>
                    <useFile>false</useFile>
                </configuration>
            </plugin>

		</plugins>
	</build>
