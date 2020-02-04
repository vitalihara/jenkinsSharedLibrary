import testSupport.PipelineSpockTestBase
import log


class defaultPipelineTest extends PipelineSpockTestBase {

    def script
    def mavenMock
    def logMock

    def setup() {
        registerMocks()
        registerPluginMethods()
        script = loadScript('pipelines/defaultPipeline.groovy')
    }

    def cleanup() {
        printCallStack()
    }

    void 'Happy flow'() {
        when:
        script.call([:])

        then:
        assertJobStatusSuccess()

    }

    def registerPluginMethods() {

        helper.registerAllowedMethod('junit', [HashMap.class], null)
    }

    def registerMocks() {
        mavenMock = Mock(Closure)
        helper.registerAllowedMethod('module_Maven', [String.class], mavenMock)

        logMock = Mock(Closure)
        helper.registerAllowedMethod('log', [HashMap.class], logMock)


    }
}
