```                                                                      
#             .___      __     _____          __                         __  .__               
#    ______ __| _/_____/  |_  /  _  \  __ ___/  |_  ____   _____ _____ _/  |_|__| ____   ____  
#   /  ___// __ |/ __ \   __\/  /_\  \|  |  \   __\/  _ \ /     \\__  \\   __\  |/  _ \ /    \ 
#   \___ \/ /_/ \  ___/|  | /    |    \  |  /|  | (  <_> )  Y Y  \/ __ \|  | |  (  <_> )   |  \
#  /____  >____ |\___  >__| \____|__  /____/ |__|  \____/|__|_|  (____  /__| |__|\____/|___|  /
#       \/     \/    \/             \/                         \/     \/                    \/ 
```

# springboot-java
Example project using Spring Boot framework to create a web api service.  


Introduction
------------
This project is made for anyone who is looking for an example of how to create a rest endpoint using Java Spring.

This service calls a mongodb repository, and also makes a rest call to an outside api and aggregates the information into a country object. 

This projet was written using IntelliJ IDEA Community Edition.   


Project Database
-----
This project uses MongoDB for a repository.  In order to run this project locally, you will need to first install and execute a local instance of MongoDB.

Information on how to install and setup MongoDB: https://docs.mongodb.com/manual/tutorial/      

### brew commands I used: 

brew services start mongodb

brew services stop mongodb



Rest Api 
-----

GET - getAll : localhost:8080/countries/v1/

GET - getByIso2: localhost:8080/countries/v1/hk

PUT - updatePopulation: localhost:8080/countries/v1/hk + include a json body with new population.

json body needed for the PUT:

`{
    "name": "Hong Kong",
    "iso_2": "HK",
    "iso_3": "HKG",
    "population": 1000000,
    "capital": "Hong Kong"
}`


External Api
-----
This project calls an external api to get iso_3 and name information.  

    http://services.groupkt.com/
    
    
Maven Java Project
-----
This project is a Maven project. 

    ./mvnw clean
    ./mvnw install -DskipTests
    
   
Continuous Integration(CI)
------------
A web hook has been setup with Travis CI for all Push and Pull Requests.
 

Questions / Contact / Contribute
------------
Feel free to fork this repo, add to it, and create a pull request if you like to contribute.  

If you have any questions, you can contact me via email: `sdet.testautomation@gmail.com`