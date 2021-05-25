LANG = en_US.UTF-8
SHELL = /bin/bash
.SHELLFLAGS = -eu -o pipefail -c # run '/bin/bash ... -c /bin/cmd'
.DEFAULT_GOAL = coverage

publish-local:
	./gradlew publishToMavenLocal

publish-and-release:
	./gradlew publishToSonatype closeAndReleaseSonatypeStagingRepository

coverage:
	./gradlew codeCoverageReport
	open build/reports/jacoco/codeCoverageReport/html/index.html
