.DEFAULT_GOAL := help
.PHONY: help build test coverage docker-test docker-coverage

help:  ## Show this help.
	@grep -E '^\S+:.*?## .*$$' $(firstword $(MAKEFILE_LIST)) | \
		awk 'BEGIN {FS = ":.*?## "}; {printf "%-30s %s\n", $$1, $$2}'

build:
	docker build -t islomar/kata-name .

test:
	pytest

coverage:
	coverage run --source=user_registration -m unittest
	coverage report
	coverage html
	@printf "To visualize the lines open the report at htmlcov/index.html\n"

docker-test: # Run the tests with Docker
	docker run --rm -v ${PWD}:/kata islomar/kata-name make test

docker-coverage: # Run the test coverage with Docker
	@docker run --rm -v ${PWD}:/kata islomar/kata-name make coverage