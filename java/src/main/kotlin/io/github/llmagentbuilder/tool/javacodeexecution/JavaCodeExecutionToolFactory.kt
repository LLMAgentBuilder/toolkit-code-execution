package io.github.llmagentbuilder.tool.javacodeexecution

import io.github.llmagentbuilder.core.tool.ConfigurableAgentToolFactory

class JavaCodeExecutionToolFactory :
    ConfigurableAgentToolFactory<JavaCodeExecutionConfig, JavaCodeExecutionTool> {
    override fun create(config: JavaCodeExecutionConfig?): JavaCodeExecutionTool {
        return JavaCodeExecutionTool(config)
    }

    override fun toolId(): String {
        return toolId
    }
}