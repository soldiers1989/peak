# 镜像名称
IMAGE_NAME := peak-resource
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
	docker stack deploy peak --with-registry-auth -c docker-compose.yml

destroy:
	docker stack rm peak-resource

.PHONY: deploy destroy docker-build package
