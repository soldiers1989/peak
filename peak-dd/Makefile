# 镜像名称
IMAGE_NAME := peak-dd
EUREKA_SUBNET := 10.0.100

include versioning.mk

TOPTARGETS := docker-build docker-push
SUBDIRS := nginx

$(TOPTARGETS): $(SUBDIRS)
$(SUBDIRS):
	$(MAKE) -C $@ $(MAKECMDGOALS)

include includes.mk

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
	REDIS_HOST=$(REDIS_HOST) \
	REDIS_PASSWORD=$(REDIS_PASSWORD) \
	SHIRO_CAS=$(SHIRO_CAS) \
	SHIRO_SERVICE=$(SHIRO_SERVICE) \
	ZUUL_URL=$(ZUUL_URL) \
	docker stack deploy peak-dd --with-registry-auth -c docker-compose.yml

destroy:
	docker stack rm peak-dd

.PHONY: $(TOPTARGETS) $(SUBDIRS) deploy network destroy
