package io.github.llmagentbuilder.codeexecution

import java.nio.file.Files
import kotlin.io.path.writeText

/**
 * Code executor
 */
interface CodeExecutor {
    fun execute(input: String): String
}

object CodeExecutionHelper {
    fun inputToFile(input: String, suffix: String): String {
        val file = Files.createTempFile("code-execution-", suffix)
        file.writeText(input)
        return file.toAbsolutePath().toString()
    }
}