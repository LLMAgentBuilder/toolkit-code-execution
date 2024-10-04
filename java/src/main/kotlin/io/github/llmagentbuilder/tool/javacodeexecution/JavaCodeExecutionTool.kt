package io.github.llmagentbuilder.tool.javacodeexecution

import io.github.llmagentbuilder.codeexecution.CodeExecutionHelper
import io.github.llmagentbuilder.codeexecution.nonsandboxed.NonSandboxedCodeExecutor
import io.github.llmagentbuilder.core.tool.ConfigurableAgentTool
import org.slf4j.LoggerFactory

const val toolId = "executeJavaCode"

class JavaCodeExecutor(private val config: JavaCodeExecutionConfig) :
    NonSandboxedCodeExecutor() {
    override fun executable(): String {
        return config.executable
    }

    override fun workingDirectory(): String? {
        return config.workingDirectory
    }

    override fun args(input: String): List<String> {
        val file = CodeExecutionHelper.inputToFile(input, ".java")
        return listOf(file)
    }
}

/**
 * Tool to execute Java code
 */
class JavaCodeExecutionTool(config: JavaCodeExecutionConfig) :
    ConfigurableAgentTool<JavaCodeExecutionRequest, JavaCodeExecutionResponse, JavaCodeExecutionConfig> {

    private val logger = LoggerFactory.getLogger(javaClass)
    private val codeExecutor = JavaCodeExecutor(config)

    init {
        logger.info("Created with config: $config")
    }

    override fun apply(request: JavaCodeExecutionRequest): JavaCodeExecutionResponse {
        return JavaCodeExecutionResponse(
            codeExecutor.execute(request.code)
        )
    }

    override fun description(): String {
        return "execute Java code"
    }

    override fun name(): String {
        return toolId
    }

    override fun id(): String {
        return toolId
    }
}