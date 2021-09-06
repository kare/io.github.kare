# Changelog

## v0.0.3-beta.13 (2021-09-06)

### Build

- Remove debug print (6df2ffc)
- Set project's basic attributes (bba5af5)

### Continuous Integration

- Create CHANGELOG (7dcce0e)
- Debug create release workflow (263ce0f)
- Print info on build (c6848ed)
- Do pre release on tag only (9013ffb)
- Install git-sv from GitHub Releases (86a38ba)
- Print env (99fc6d3)
- Fix typo in workflow (1e6a260)
- Fix typos (78b2bbf)
- Fix next version (6d2b7a5)
- Create Release from GitHub Actions UI (b7aff55)
- Fix missing bracket (66f7bca)
- Cache Gradle build (73887d4)
- Specify cache action version (cab6840)
- Fix typo in quotes (cca76d2)
- Remove spaces around the variabe definition (0997753)
- Add Gradle build cache (3b59c38)
- Set user account properties for publishing (fd10281)
- Change defaults for version inputs (b86dcdc)
- Fix quotes on gradle.properties (15efb5e)
- Remove redundant quotes (1550499)

### Documentation

- Update RELEASE-NOTES.md for release 0.0.3-beta.13 (14c565e)
- Update CHANGELOG.md for release 0.0.3-beta.13 (a0d2ece)

---

## v0.0.3-beta.12 (2021-09-05)

### Continuous Integration

- Remove redundant config (bab3aa3)
- Move Git config to env step (0f08f76)
- Add configure step to set Git account details (883ba06)
- Print release stacktrace on error (14f2738)
- Fix release notes in GitHub Release (4b0cd04)
- Update Create Release workflow (777b93d)

### Documentation

- Update CHANGELOG.md for release 0.0.3-beta.12 (d9ba366)

---

## v0.0.3-beta.11 (2021-09-05)

### Continuous Integration

- Debug print version (0dbdd06)

### Documentation

- Update CHANGELOG.md for release 0.0.3-beta.11 (afd54e8)

---

## v0.0.3-beta.10 (2021-09-05)

### Continuous Integration

- Validate release (c2af72e)
- Validate given version (7046503)
- Mark pre (alpha/beta) releases as such on GitHub Releases (ec1347c)
- Add Create Release workflow (eb0f9ea)
- Include release notes to GitHub Release body text (46c4237)

### Documentation

- Update CHANGELOG.md for release 0.0.3-beta.10 (70a96d2)

---

## v0.0.3-beta.9 (2021-09-05)

### Continuous Integration

- Remove Bash arguments (e118202)

### Documentation

- Update CHANGELOG.md for release 0.0.3-beta.9 (e34ce7d)

---

## v0.0.3-beta.8 (2021-09-05)

### Build

- Add sv4git configuration (9c46bd5)
- Don't use profile or rc for Bash init (944283b)

### Continuous Integration

- Set CI Bash arguments (19676da)
- Publish pre releases to Maven Central (4d0a777)
- Set Bash flags (1305419)
- Define Java version by major release (bb86ef2)
- Try github.com/bvieira/sv4git for automatic release notes (714f50d)

### Documentation

- Update CHANGELOG.md for release 0.0.3-beta.8 (556731e)

---

## v0.0.3-beta.7 (2021-09-03)

### Continuous Integration

- Debug output (d9310ca)

---

## v0.0.3-beta.6 (2021-09-02)

### Continuous Integration

- Fix empty release notes file (edc62c2)
- Enable sv4git (bdeee06)

---

## v0.0.3-beta.5 (2021-09-02)

### Continuous Integration

- Fix build error by removing empty line (f505bf7)

---

## v0.0.3-beta.4 (2021-09-02)

---

## v0.0.3-beta.3 (2021-09-02)

### Continuous Integration

- Disable sv4git (817b543)
- Debug release notes generation (c2c1bec)
- Set Gradle build '--console auto' (e26f594)

---

## v0.0.3-beta.2 (2021-09-02)

### Build

- Move version to gradle.properties (61d701e)
- Move group to gradle.properties (a9471b3)

### Continuous Integration

- **deps:** bump actions/setup-go from 2.1.3 to 2.1.4 (#3) (49c21d1)
- Add Git checkout to Pre Release (f164064)
- Define Go version for Pre Release (15fa86e)
- Fix pre release workflow (e9376c8)

---

## v0.0.3-beta.1 (2021-08-24)

### Features

- **common:** Add IO.copy(java.io.InputStream, java.io.OutputStream) (ab295d4)
- **common:** Add IO.close(java.io.Closeable...) (8ed4578)
- **common:** Add ByteArrays.cat(byte[], byte[]) (b1d2c3d)
- **common:** Add ByteArrays.contains(byte[], byte) (1d17fad)

### Testing

- Update JUnit Jupiter 5.7.2 (b9ad544)
- Use full byte range -128..127 while testing ByteArrays.reverse() (f8ebb05)

### Build

- Update to Gradle 7.2 (44e87c5)
- **deps:** bump com.diffplug.spotless from 5.12.5 to 5.14.3 (#1) (ba13eb3)
- **deps:** Update google-java-format 1.11.0 (9841bb7)
- Use Java 8 when generating Javadoc (996c780)
- Compile with Java 8 (c6e1465)
- Run unit tests in parallel (ecf800f)
- Add issue, CI, license and organization links to Maven publication (9ec293e)
- Define Gradle runtime and optimize build with parallel, cache and watch (cf43904)
- Make build logging more verbose (d1c6404)
- Set common Javadoc build options (48d7192)
- Build project wide Javadoc (6e02365)
- Use private key to sign build artifacts (6159638)
- Skip signing SNAPSHOTs and with skipSigning Gradle property (d1595b3)
- Use console=verbose as build output level (5a03edb)

### Continuous Integration

- Pre Release on Tag (c27db49)
- **deps:** bump actions/setup-java from 2.2.0 to 2.3.0 (#2) (da8d165)
- Use Java 11 to run build (16674d4)
- Add basic continuous integration build (4cf3f90)
- Add Dependabot for Gradle and GitHub Action dependencies (f270ee9)

### Documentation

- Update ByteArrays.toLong() Javadoc (e5a6a4d)
- Format README code examples (7109b7c)

---

## v0.0.2 (2021-06-02)

### Features

- ByteArrays.reverse(byte[]) (3f2f244)
- **build:** add more recipes (f519cb9)

### Build

- **java-lib:** fail on dependency version conflict (fc5def7)

---

## v0.0.1 (2021-05-25)

---

## v0.0.1-beta.1 (2021-05-25)

---

