package io.github.llmagentbuilder.tool.pythoncodeexecution;

public class PythonCodeExecutionConfig {

  private String executable;

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
    return "PythonCodeExecutionConfig{" +
        "executable='" + executable + '\'' +
        ", workingDirectory='" + workingDirectory + '\'' +
        '}';
  }
}
