package com.mz.youchat.utils;



/**
 * ??????????????????
 * User: Lusar
 * Date: 13-11-10
 * Time: ??????3:40
 */
public class Result<T>{
    private boolean success;      // ????????????????????????
    private String   msg;         // success == false???msg???????????????????????????.
    private T        returnObj;   // success == true??? ????????????????????????.

    private int total = 0;
    private int searchType=1;
    
    private Object attr;

    
    public Object getAttr() {
		return attr;
	}

	public void setAttr(Object attr) {
		this.attr = attr;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getReturnObj() {
        return returnObj;
    }

    public void setReturnObj(T returnObj) {
        this.returnObj = returnObj;
    }

	public int getSearchType() {
		return searchType;
	}

	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}
}
