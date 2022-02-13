LANG := en_US.UTF-8
SHELL := /bin/bash
.SHELLFLAGS := --noprofile --norc -e -u -o pipefail -c
.DEFAULT_GOAL := coverage

YAMLLINT := /usr/local/bin/yamllint
YAMLLINTFLAGS := --config-file .yamllint

gradlew := ./gradlew --console verbose

$(YAMLLINT):
	pip3 install --user yamllint

.PHONY: lint-yaml
lint-yaml: $(YAMLLINT)
	$(YAMLLINT) $(YAMLLINTFLAGS) .

.PHONY: publish-local
publish-local: ## Publish to local Maven repository
	$(gradlew) publishToMavenLocal

.PHONY: publish-and-release
publish-and-release: ## Automatically publish a release of all subprojects to Sonatype https://repo1.maven.org/maven2/io/github/kare/
	$(gradlew) publishToSonatype closeAndReleaseSonatypeStagingRepository

.PHONY: test
test: ## Run all tests
	$(gradlew) test

test_coverage_report_index_html = $$(pwd)/build/reports/jacoco/codeCoverageReport/html/index.html
.PHONY: coverage
coverage:  ## Generate test code coverage for all Gradle subprojects
	$(gradlew) codeCoverageReport && open $(test_coverage_report_index_html)

.PHONY: clean
clean: ## Clean intermediate files generated during build
	$(gradlew) clean

.PHONY: clean-all
clean-all: ## WARNING: Command is destructive!
	git clean -d -x -f
