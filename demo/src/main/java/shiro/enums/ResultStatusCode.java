package shiro.enums;

public enum ResultStatusCode {
	
	OK((byte)1,"登陆成功"),
	
	SHIRO_ERROR((byte)2,"登录失败"),

	NOT_EXIST_USER_OR_ERROR_PWD((byte)3,"账号或密码错误"),
	
	USER_FROZEN((byte)4,"账号被锁定"),
	
	SYSTEM_ERR((byte)5,"系统异常"),
	
	UNAUTHO_ERROR((byte)6,"当前用户无权访问"),

	INVALID_TOKEN((byte)7,"当前账户在宁一个地点登陆"),
	
	BAD_REQUEST((byte)8,"请求失败"),
	
	METHOD_NOT_ALLOWED((byte)9,"无访问权限");
	private byte code;

	private String name;
	
	ResultStatusCode(byte code, String name) {
		this.code = code;
		this.name = name;
	}
	
	/**
	 * 获取状态名
	 *
	 * @param code
	 * @return
	 */
	public static String fetchName(byte code) {
		ResultStatusCode status = fetch(code);
		return status == null ? null : status.name;
	}
	
	/**
	 * 获取状态
	 * 
	 * @param code
	 * @return
	 */
	public static ResultStatusCode fetch(Object code) {
		Byte b = Byte.valueOf(String.valueOf(code));
		if (b != null) {
			fetch(b);
		}
		return null;
	}
	
	/**
	 * 获取状态
	 * 
	 * @param code
	 * @return
	 */
	public static ResultStatusCode fetch(byte code) {
		for (ResultStatusCode status : ResultStatusCode.values()) {
			if (status.code == code) {
				return status;
			}
		}
		return null;
	}

	public byte getCode() {
		return code;
	}

	public void setCode(byte code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
