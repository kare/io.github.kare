LANG = en_US.UTF-8
SHELL = /bin/bash
.SHELLFLAGS = --noprofile --norc -eu -o pipefail -c # run '/bin/bash ... -c /bin/cmd'
.DEFAULT_GOAL = coverage

gradlew = ./gradlew --console verbose

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
