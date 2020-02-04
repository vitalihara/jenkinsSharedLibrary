
import testSupport.PipelineSpockTestBase


class logTest extends PipelineSpockTestBase {

    def script

    def setup() {
        script = loadScript('vars/log.groovy')
    }

    def cleanup() {
        printCallStack()
    }

    void 'Happy flow'() {
        given:
        def params = [:]
        params.put("level", "INFO")
        params.put("msg", "SUCCESS")

        when:
        script.call(params)

        then:
        assertJobStatusSuccess()

    }
}
