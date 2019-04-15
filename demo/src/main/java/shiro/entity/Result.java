package shiro.entity;

import com.alibaba.fastjson.JSON;
import shiro.enums.ResultStatusCode;

public class Result {
	
	private String str;
	
	private ResultStatusCode resultStatusCode;
	
	private JSON json;

	public Result(ResultStatusCode resultStatusCode) {
		this.resultStatusCode = resultStatusCode;
	}

	public Result(ResultStatusCode ok, JSON json) {
		
	}

	public Result(byte code, String message) {
		// TODO Auto-generated constructor stub
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public ResultStatusCode getResultStatusCode() {
		return resultStatusCode;
	}

	public void setResultStatusCode(ResultStatusCode resultStatusCode) {
		this.resultStatusCode = resultStatusCode;
	}

	public JSON getJson() {
		return json;
	}

	public void setJson(JSON json) {
		this.json = json;
	}

	
	 
}
