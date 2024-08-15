```bash
git clone 
```

**2. Create Mysql database**
```bash
create database db_airline
```
- run `src/main/resources/shema_airline.sql`

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Run the app using maven**

```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>

