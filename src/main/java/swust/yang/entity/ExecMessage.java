package swust.yang.entity;

public class ExecMessage {

	/**
	 * 错误输出的内容
	 */
	private String error;

	/**
	 * 标准输出的内容
	 */
	private String stdout;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getStdout() {
		return stdout;
	}

	public void setStdout(String stdout) {
		this.stdout = stdout;
	}

}
