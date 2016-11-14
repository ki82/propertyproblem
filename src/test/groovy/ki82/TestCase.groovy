package ki82
import org.gradle.testkit.runner.GradleRunner
import org.junit.Rule
import org.junit.rules.TemporaryFolder

import spock.lang.Specification

class TestCase extends Specification {
    @Rule final TemporaryFolder testProjectDir = new TemporaryFolder()
    File testDir

    def setup() {
        testDir = testProjectDir.newFolder('someDir')
        new AntBuilder().copy(todir: testDir) {
            fileset(dir : new File(System.getProperty("user.dir"))) {
                include(name:"*.gradle")
                include(name:"*.properties")
            }
        }
    }

    def GradleRunner gradleTask(String task, extraArgs = null) {
    	def args = [task, '--info']
		if (extraArgs) {
			args << extraArgs
		}
        return GradleRunner.create().withProjectDir(testDir)
        .withArguments(args)
    }
}