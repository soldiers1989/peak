# 最新版本号
MUTABLE_VERSION ?= latest
# git版本号
VERSION ?= git-$(shell git rev-parse --short HEAD)
# Docker镜像库
IMAGE_REGISTRY ?= ccr.ccs.tencentyun.com/bjd_bigdata
# 镜像名称
IMAGE := ${IMAGE_REGISTRY}/${IMAGE_NAME}:${VERSION}
MUTABLE_IMAGE := ${IMAGE_REGISTRY}/${IMAGE_NAME}:${MUTABLE_VERSION}

# 版本信息
info:
	@echo "Build tag:       ${VERSION}"
	@echo "Registry:        ${IMAGE_REGISTRY}"
	@echo "Immutable tag:   ${IMAGE}"
	@echo "Mutable tag:     ${MUTABLE_IMAGE}"