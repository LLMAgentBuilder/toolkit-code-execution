package io.github.llmagentbuilder.tool.javacodeexecution

import io.github.llmagentbuilder.core.tool.EnvironmentVariableConfigurableAgentToolFactory

class JavaCodeExecutionToolFactory :
    EnvironmentVariableConfigurableAgentToolFactory<JavaCodeExecutionTool, JavaCodeExecutionConfig>(
        JavaCodeExecutionConfig::class.java, "${toolId}_"
    ) {
    override fun create(config: JavaCodeExecutionConfig): JavaCodeExecutionTool {
        return JavaCodeExecutionTool(config)
    }

    override fun configName(): String {
        return toolId
    }
}