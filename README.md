# case-study-autocompletion
This repository contains a demo autocompletion endpoint for the DB Sprintstarter case study.  
`GET <ip_adress>:<port>/api/v1/auto-complete/{input}`


### Live Demo
https://auto-complete-casestudy-production.up.railway.app/api/v1/auto-complete/Ham


### Prerequisites

- this application is tested to run with JDK Version 17  

### Startup

- package application  
  `mvnw package`

- compile and start application  
  `java -jar <snapshot_name>.jar`

### with Docker
- build image  
  `docker build -t <image_name> .`
- start container  
  `docker start <image_name>`

  





