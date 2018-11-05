# 镜像名称
IMAGE_NAME := peak-data
EUREKA_SUBNET := 10.0.100

include versioning.mk includes.mk

package:
	mvn package

docker-build: package
	docker build -t ${IMAGE} .
	docker tag ${IMAGE} ${MUTABLE_IMAGE}

deploy:
	VERSION=$(VERSION) \
	SPRING_PREFER_NETWORK=$(SPRING_PREFER_NETWORK) \
	JDBC_URL=$(JDBC_URL) \
	JDBC_PORT=$(JDBC_PORT) \
	JDBC_USERNAME=$(JDBC_USERNAME) \
	JDBC_PASSWORD=$(JDBC_PASSWORD) \
	MONGO_USERNAME=$(MONGO_USERNAME) \
	MONGO_PASSWORD=$(MONGO_PASSWORD) \
	MONGO_URL=$(MONGO_URL) \
	MONGO_PORT=$(MONGO_PORT) \
	MONGO_DATABASE=$(MONGO_DATABASE) \
	docker stack deploy peak-data --with-registry-auth -c docker-compose.yml

destroy:
	docker stack rm peak-dd

.PHONY: deploy destroy docker-build package
