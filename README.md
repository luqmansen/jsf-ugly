# jsf-ugly
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
![GitHub last commit](https://img.shields.io/github/last-commit/luqmansen/jsf-ugly)
[![HitCount](http://hits.dwyl.com/luqmansen/jsf-ugly.svg)](http://hits.dwyl.com/luqmansen/jsf-ugly)
[![Twitter](https://img.shields.io/twitter/follow/luqmansen_?label=Follow&style=social)](https://twitter.com/luqmansen_)

JavaServer Faces App

## Demo
#### On Heroku
http://jsfu.herokuapp.com/

#### On EC2 
(Sometimes went off)

http://54.174.72.185/


## Requirements
- [docker](https://docs.docker.com/get-docker/)
 
##### For development
+ docker-compose
+ open jdk version 11
+ maven 3.6.3

## Running
#### Pull image directly from Dockerhub using docker-compose
```
wget https://git.io/JfKDM
docker-compose up
```
#### Development
```bash
git clone https://github.com/luqmansen/jsf-ugly.git && cd jsf-ugly
make build
make run
 ```
App will running on localhost:8080

## Deployment
### AWS EC2

1. make sure docker installed on host
    ```
    apt install docker.io
    ```
2. Download docker-compose script
   ```
   wget https://git.io/JfKDM
   ```
3. Run!
    ```
    docker-compose up
    ```
   \*) Make sure no app running on port 80 (eg. NGINX), otherwise you have to setup your reverse proxy
   
### Heroku Container Registry
1. make sure heroku-cli installed
2. Then refer to this [official documentation](https://devcenter.heroku.com/articles/container-registry-and-runtime)
 

## Notes
- Currently the app depends on database that running on container, further update (not likely) will make the db configuration  decoupled from the file.
- Image used in docker is tomcat slim version which is bare minimum tomcat.
If you want to full tomcat version, use non slim version but make sure 
use version that support jdk 11. 
The configuration for tomcat manager available at `./conf` folder

-  When running docker with `docker run`, env `PORT` is mandatory, because the container should be able to run flexibly on environment that have dynamic port assignment (like Heroku)
 
- There is auto-push-image task on github action for every commit to Dockerhub and Heroku container registry with the credential specified as Github secrets.

## Common Error
- Maven target compiler error:
  <br> Make sure your jdk version is correct, this project use version 11,
  if you you use another version, change it on `pom.xml`
- Docker Image Not Updating:
  <br> sometimes target folder cached by docker, 
  so I remove that folder every maven build on the `make build` command.
