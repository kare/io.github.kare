# Changelog

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

