package io.github.llmagentbuilder.tool.javacodeexecution;

public class JavaCodeExecutionConfig {

  private String executable = "java";

  private String workingDirectory;

  public String getExecutable() {
    return executable;
  }

  public void setExecutable(String executable) {
    this.executable = executable;
  }

  public String getWorkingDirectory() {
    return workingDirectory;
  }

  public void setWorkingDirectory(String workingDirectory) {
    this.workingDirectory = workingDirectory;
  }

  @Override
  public String toString() {
    return "JavaCodeExecutionConfig{" +
        "executable='" + executable + '\'' +
        ", workingDirectory='" + workingDirectory + '\'' +
        '}';
  }
}
