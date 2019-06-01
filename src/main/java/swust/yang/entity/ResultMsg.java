package swust.yang.entity;

public class ResultMsg {

	/**
	 * 学生信息
	 */
	private String studentInfo;

	/**
	 * 作业执行结果
	 */
	private String value;

	/**
	 * 作业执行结果描述,若执行成功返回"OK",反之返回错误描述
	 */
	private String message;

	/**
	 * 作业执行结果代码,执行成功返回0,反之返回-1
	 */
	private int code;

	/**
	 *
	 * @return 学生信息
	 */
	public String getStudentInfo() {
		return studentInfo;
	}

	/**
	 *
	 * @param studentInfo 学生信息
	 */
	public void setStudentInfo(String studentInfo) {
		this.studentInfo = studentInfo;
	}

	/**
	 *
	 * @return 作业执行结果
	 */
	public String getValue() {
		return value;
	}

	/**
	 *
	 * @param value 执行结果
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 *
	 * @return 作业执行结果描述。若执行成功返回"OK",反之返回错误描述
	 */
	public String getMessage() {
		return message;
	}

	/**
	 *
	 * @param message 执行成功设为"OK",反之设为错误描述
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 *
	 * @return 作业执行结果代码。执行成功返回0,反之返回-1
	 */
	public int getCode() {
		return code;
	}

	/**
	 *
	 * @param code 执行成功设为0,反之设为-1
	 */
	public void setCode(int code) {
		this.code = code;
	}
}
