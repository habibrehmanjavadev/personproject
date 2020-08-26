# personproject
step 1 : download project or clone repository via git clone 'https://github.com/habibrehmanjavadev/personproject.git'
step 2: copy person.sql files and run the query in mysql workbench or mysql cmd
step 3: unzip and Import person folder to eclipse as maven project
step 4 : run project as spring boot app or as java applicaitons
return list of persons
curl http://localhost:8080/api/all

return list of persons with pagination
curl --location --request GET 'http://localhost:8080/api/allwithpagination?page0&size=2&sort=name'

Add Persons
curl --location --request POST 'http://localhost:8080/api/addpersons' \
--header 'Content-Type: application/json' \
--data-raw ' {
        
        "name": "habib111",
        "surname": "rehman11",
        "age": 29.0,
        "sex": "male",
        "birthday": "1990-04-21T19:00:00.000+0000",
        "created": "2020-08-24T17:57:13.000+0000",
        "contacts": "03104125385",
        "email": "habiburrehmannsr@gmail.com",
        "modified": "2020-08-23T19:00:00.000+0000"
    }'
    
    Update function
    curl --location --request PUT 'http://localhost:8080/api/persons/1' \
--header 'Content-Type: application/json' \
--data-raw ' { 
        "name": "habib111",
        "surname": "rehman11",
        "age": 29.0,
        "sex": "male",
        "birthday": "1990-04-21T19:00:00.000+0000",
        "created": "2020-08-24T17:57:13.000+0000",
        "contacts": "03104125385",
        "email": "habiburrehmannsr@gmail.com",
        "modified": "2020-08-23T19:00:00.000+0000"
    }'
    
Delete Function
curl --location --request DELETE 'http://localhost:8080/api/persons/1'
Notes: Project is configured with mysql database as well microsoft sql database both files are attached 
just need to uncommit sql link in pom.xml and configuration in apllication.properties.
by default project is configured with mysql database
