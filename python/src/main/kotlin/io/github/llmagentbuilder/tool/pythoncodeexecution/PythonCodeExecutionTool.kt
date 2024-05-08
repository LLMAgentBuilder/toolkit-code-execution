package io.github.llmagentbuilder.tool.pythoncodeexecution

import io.github.llmagentbuilder.codeexecution.CodeExecutionHelper
import io.github.llmagentbuilder.codeexecution.nonsandboxed.NonSandboxedCodeExecutor
import io.github.llmagentbuilder.core.tool.ConfigurableAgentTool
import org.slf4j.LoggerFactory

const val toolName = "executePythonCode"

class PythonCodeExecutor(private val config: PythonCodeExecutionConfig) :
    NonSandboxedCodeExecutor() {
    override fun executable(): String {
        return config.executable
    }

    override fun workingDirectory(): String? {
        return config.workingDirectory
    }

    override fun args(input: String): List<String> {
        val file = CodeExecutionHelper.inputToFile(input, ".py")
        return listOf(file)
    }
}

/**
 * Tool to execute Python code
 */
class PythonCodeExecutionTool(config: PythonCodeExecutionConfig) :
    ConfigurableAgentTool<PythonCodeExecutionRequest, PythonCodeExecutionResponse, PythonCodeExecutionConfig> {

    private val logger = LoggerFactory.getLogger(javaClass)
    private val codeExecutor = PythonCodeExecutor(config)

    init {
        logger.info("Created with config: $config")
    }

    override fun apply(request: PythonCodeExecutionRequest): PythonCodeExecutionResponse {
        return PythonCodeExecutionResponse(
            codeExecutor.execute(request.code)
        )
    }

    override fun description(): String {
        return "execute python code"
    }

    override fun name(): String {
        return toolName
    }
}