package com.example.Ordermanagment.dto;

public class ResponseDto {
	private boolean success;
	private Object data;
	
	public ResponseDto() {
		
	}
public ResponseDto(boolean success, Object data) {
		super();
		this.success = success;
		this.data = data;
	}
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}

}

