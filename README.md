# jsf-ugly
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
![GitHub last commit](https://img.shields.io/github/last-commit/luqmansen/jsf-ugly)
[![HitCount](http://hits.dwyl.com/luqmansen/jsf-ugly.svg)](http://hits.dwyl.com/luqmansen/jsf-ugly)
[![Twitter](https://img.shields.io/twitter/follow/luqmansen_?label=Follow&style=social)](https://twitter.com/luqmansen_)

JavaServer Faces App

## Demo
http://jsfu.herokuapp.com/


## Requirements (for development)
- open jdk version 11
- maven 3.6.3
- docker
- docker-compose

## Running
#### Run Container from Dockerhub
```
docker run luqmansen/jsf-ugly
```
#### Development
```bash
make build
make run
 ```
App will running on localhost:8080

## Notes
Image used in docker is slim version which is bare minimum tomcat.
If you want to full tomcat version, use non slim version but make sure 
use version that support jdk 11. 

The configuration for tomcat manager available at `./conf` folder
 

## Common Error
- Maven target compiler error:
  <br> Make sure your jdk version is correct, this project use version 11,
  if you you use another version, change it on `pom.xml`
