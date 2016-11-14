package ki82
import org.gradle.testkit.runner.GradleRunner
import org.gradle.api.GradleException
import groovy.xml.*

class DummyTest extends TestCase {

	def "creates json file when input data"() {
		given:
		
		when:
		gradleTask('createJson').build()
		
		then:
		File extractedJson = new File(testProjectDir.folder, 'build/output.json')
		extractedJson.exists()
	}

}