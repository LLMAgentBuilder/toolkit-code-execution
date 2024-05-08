package io.github.llmagentbuilder.codeexecution.nonsandboxed

import io.github.llmagentbuilder.codeexecution.CodeExecutor
import org.buildobjects.process.ProcBuilder
import java.nio.file.Paths

abstract class NonSandboxedCodeExecutor : CodeExecutor {
    override fun execute(input: String): String {
        val result = ProcBuilder(executable())
            .withArgs(*args(input).toTypedArray())
            .withWorkingDirectory(
                (workingDirectory() ?: ".")
                    .run { Paths.get(this).toAbsolutePath() }
                    .toFile())
            .ignoreExitStatus()
            .run()
        return result.outputString.trim()
    }

    abstract fun executable(): String
    abstract fun workingDirectory(): String?
    abstract fun args(input: String): List<String>
}