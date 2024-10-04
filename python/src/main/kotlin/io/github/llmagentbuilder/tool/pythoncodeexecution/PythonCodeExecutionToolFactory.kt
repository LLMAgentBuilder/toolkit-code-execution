package io.github.llmagentbuilder.tool.pythoncodeexecution

import io.github.llmagentbuilder.core.tool.EnvironmentVariableConfigurableAgentToolFactory

class PythonCodeExecutionToolFactory :
    EnvironmentVariableConfigurableAgentToolFactory<PythonCodeExecutionTool, PythonCodeExecutionConfig>(
        PythonCodeExecutionConfig::class.java, "${toolId}_"
    ) {
    override fun create(config: PythonCodeExecutionConfig): PythonCodeExecutionTool {
        return PythonCodeExecutionTool(config)
    }

    override fun configName(): String {
        return toolId
    }
}