.DEFAULT_GOAL := help

help:  ## Show this help.
	@grep -E '^\S+:.*?## .*$$' $(firstword $(MAKEFILE_LIST)) | \
		awk 'BEGIN {FS = ":.*?## "}; {printf "%-30s %s\n", $$1, $$2}'

.PHONY: local-setup
local-setup: ## Set up the local environment (e.g. install git hooks)
	scripts/local-setup.sh

.PHONY: build
build: ## Builds the Docker image
	COMPOSE_DOCKER_CLI_BUILD=1 DOCKER_BUILDKIT=1 docker compose build

.PHONY: update
update: ## Updates the Python packages
	docker compose run --rm --no-deps python-kata-name poetry update

.PHONY: test
test: ## Run all the tests
	docker compose run --rm --no-deps python-kata-name poetry run pytest -n auto tests -ra

.PHONY: coverage
coverage:
	coverage run --source=user_registration -m unittest
	coverage report
	coverage html
	@printf "To visualize the lines open the report at htmlcov/index.html\n"

docker-coverage: # Run the test coverage with Docker
	@docker run --rm -v ${PWD}:/kata islomar/kata-name make coverage