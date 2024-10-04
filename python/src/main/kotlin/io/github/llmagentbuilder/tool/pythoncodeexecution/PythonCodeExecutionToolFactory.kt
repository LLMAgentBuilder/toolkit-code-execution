package io.github.llmagentbuilder.tool.pythoncodeexecution

import io.github.llmagentbuilder.core.tool.ConfigurableAgentToolFactory

class PythonCodeExecutionToolFactory :
    ConfigurableAgentToolFactory<PythonCodeExecutionConfig, PythonCodeExecutionTool> {
    override fun create(config: PythonCodeExecutionConfig?): PythonCodeExecutionTool {
        return PythonCodeExecutionTool(config)
    }

    override fun toolId(): String {
        return toolId
    }
}