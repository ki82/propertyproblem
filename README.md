This project is a minimal project that shows an error when creating files while using gradle testkit.

Execute: ./gradlew test

Expected: The test to pass

Actual: The test fails, and the output.json file is created in the projectDir/build instead of in the temp directory used for the test
