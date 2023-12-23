package junit

import de.ser.doxis4.agentserver.AgentExecutionResult
import org.junit.*
import ser.UpdateLastVersion

class ExampleTests {

    Binding binding

    @BeforeClass
    static void initSessionPool() {
        AgentTester.initSessionPool()
    }

    @Before
    void retrieveBinding() {
        binding = AgentTester.retrieveBinding()
    }

    @Test
    void testForAgentResult() {
        def agent = new UpdateLastVersion();

        String ids ="SD07PRJ_DOC2437188b24-7c63-49c8-b136-8b6e26cd6e35182023-12-20T06:14:32.399Z011"


        binding["AGENT_EVENT_OBJECT_CLIENT_ID"] = ids

        def result = (AgentExecutionResult)agent.execute(binding.variables)
        assert result.resultCode == 0
    }

    /*
        def agent = new GroovyAgent()
        binding["AGENT_EVENT_OBJECT_CLIENT_ID"] = "SD0bGENERIC_DOC24d79641cb-c437-4e39-81af-3051824baa25182021-01-14T10:09:04.857Z011"
        def result = (AgentExecutionResult)agent.execute(binding.variables)
        assert result.resultCode == 0
        assert result.executionMessage.contains("Linux")
        assert agent.eventInfObj instanceof IDocument
     */


    @Test
    void testForJavaAgentMethod() {
        //def agent = new JavaAgent()
        //agent.initializeGroovyBlueline(binding.variables)
        //assert agent.getServerVersion().contains("Linux")
    }

    @After
    void releaseBinding() {
        AgentTester.releaseBinding(binding)
    }

    @AfterClass
    static void closeSessionPool() {
        AgentTester.closeSessionPool()
    }
}
