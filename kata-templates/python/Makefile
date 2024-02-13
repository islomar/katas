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

.PHONY: add-package
add-package: ## Add package to the project: 'make add-package package=<package-name>'
	docker compose run --rm --no-deps python-kata-name poetry add $(package)
	make build

.PHONY: add-dev-package
add-dev-package: ## Add dev package to the project: 'make add-dev-package package=<package-name>'
	docker compose run --rm --no-deps python-kata-name poetry add $(package) -G dev
	make build

.PHONY: build-with-updated-packages
build-with-updated-packages: ## Rebuild the docker image with updated python packages
	rm -f poetry.lock
	docker compose run --rm --no-deps chatcommands poetry update
	make build

.PHONY: update
update: ## Updates the Python packages
	docker compose run --rm --no-deps python-kata-name poetry update

.PHONY: check-dockerfile
check-dockerfile: ## Validate the Dockerfile
	docker run --rm -i hadolint/hadolint:latest-alpine < Dockerfile

.PHONY: check-typing
check-typing:  ## Check types (using mypy)
	docker compose run --rm --no-deps python-kata-name poetry run mypy .

.PHONY: check-format
check-format: ## Check the format (using black)
	docker compose run --rm --no-deps python-kata-name poetry run black --check .

.PHONY: reformat
reformat:  ## Format Python code
	docker compose run --rm --no-deps python-kata-name poetry run black .

.PHONY: test
test: ## Run all the tests
	docker compose run --rm --no-deps python-kata-name poetry run pytest -n auto tests -ra

.PHONY: test-coverage
test-coverage: ## Generate an HTML test coverage report after running all the tests
	docker compose run --rm python-kata-name poetry run coverage run --branch -m pytest tests
	docker compose run --rm python-kata-name poetry run coverage html
	@echo "You can find the generated coverage report here: ${PWD}/htmlcov/index.html"

.PHONY: pre-commit
pre-commit: check-format check-typing test

.PHONY: rename-project
rename-project: ## Rename project: 'make rename name=<new-name>'
	sed -i 's/python-kata-name/$(name)/' docker-compose.yaml
	sed -i 's/python-kata-name/$(name)/' Makefile
	sed -i 's/python-kata-name/$(name)/' pyproject.toml