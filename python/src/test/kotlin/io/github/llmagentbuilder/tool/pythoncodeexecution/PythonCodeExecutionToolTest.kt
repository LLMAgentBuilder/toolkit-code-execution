package io.github.llmagentbuilder.tool.pythoncodeexecution

import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class PythonCodeExecutionToolTest {
    @Test
    fun execute() {
        val tool = PythonCodeExecutionTool(PythonCodeExecutionConfig())
        val result =
            tool.apply(PythonCodeExecutionRequest("print('hello world')")).result
        assertNotNull(result)
    }
}