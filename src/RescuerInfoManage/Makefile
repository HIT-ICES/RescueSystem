# App Conf.
APP_NAME = rescuer-info-manage
VERSION = 1.0
PROFILE = withsql

# Project Conf.
PROJECT_ROOT ?=../..
PROJECT ?= rescue-system-redive
REPO_NAME ?= 192.168.1.199:5000/rescue-system-2024


# Build Conf.
IMAGE_NAME = $(REPO_NAME)/$(APP_NAME):v${VERSION}
K8S_CONF_TMPL ?= $(PROJECT_ROOT)/shared/deploy-$(PROFILE).yaml
DOCKERFILE_DIR = .
WORK_DIR = .
DOCKER = docker
MAVEN = mvn
K8S = kubectl -n $(PROJECT)
K8S_REPLICA ?= 1
K8S_PROFILE = IMAGE_NAME=$(IMAGE_NAME) APP_NAME=$(APP_NAME) \
	REPLICAS=$(K8S_REPLICA) envsubst < $(K8S_CONF_TMPL)


.PHONY: default install restart start stop logs uninstall deploy sh status

maven:
	$(MAVEN) package

default: maven
	$(DOCKER) build -f $(DOCKERFILE_DIR)/Dockerfile -t $(IMAGE_NAME) $(WORK_DIR)

publish: default
	$(DOCKER) push $(IMAGE_NAME)

install:
	$(K8S_PROFILE) | $(K8S) apply -f -

uninstall:
	$(K8S_PROFILE) | $(K8S) delete -f -

profile:
	$(K8S_PROFILE)

restart:
	$(K8S) delete pod -l 'app=$(APP_NAME)'

start:
	$(K8S) scale deployment -l 'app=$(APP_NAME)' --replicas=$(K8S_REPLICA)

stop:
	$(K8S) scale deployment -l 'app=$(APP_NAME)' --replicas=0

logs:
	$(K8S) logs -f -l 'app=$(APP_NAME)'

status:
	watch $(K8S) get pods -l 'app=$(APP_NAME)'

detail:
	$(K8S) describe pods -l 'app=$(APP_NAME)'
