build:
	rm -rf ./target/
	mvn package
	docker-compose build

run:
	docker-compose up


