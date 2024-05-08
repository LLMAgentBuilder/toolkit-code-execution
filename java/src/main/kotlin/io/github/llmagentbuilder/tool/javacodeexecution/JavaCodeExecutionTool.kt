package io.github.llmagentbuilder.tool.javacodeexecution

import io.github.llmagentbuilder.codeexecution.CodeExecutionHelper
import io.github.llmagentbuilder.codeexecution.nonsandboxed.NonSandboxedCodeExecutor
import io.github.llmagentbuilder.core.tool.ConfigurableAgentTool
import org.slf4j.LoggerFactory

const val toolName = "executeJavaCode"

object JavaCodeExecutor : NonSandboxedCodeExecutor() {
    override fun executable(): String {
        return "java"
    }

    override fun workingDirectory(): String? {
        return null
    }

    override fun args(input: String): List<String> {
        val file = CodeExecutionHelper.inputToFile(input, ".java")
        return listOf(file)
    }
}

/**
 * Tool to execute Java code
 */
class JavaCodeExecutionTool(private val config: JavaCodeExecutionConfig) :
    ConfigurableAgentTool<JavaCodeExecutionRequest, JavaCodeExecutionResponse, JavaCodeExecutionConfig> {

    private val logger = LoggerFactory.getLogger(javaClass)

    init {
        logger.info("Created with config: $config")
    }

    override fun apply(request: JavaCodeExecutionRequest): JavaCodeExecutionResponse {
        return JavaCodeExecutionResponse(
            JavaCodeExecutor.execute(request.code)
        )
    }

    override fun description(): String {
        return "execute Java code"
    }

    override fun name(): String {
        return toolName
    }
}