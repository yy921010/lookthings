package com.lookthings.core.json;

/**
 * 最终封装数据
 *
 * @param <T> the type parameter
 * @author Fantasy
 */
public class JsonResult<T> {
    /**
     * 是否成功标志
     */
    private boolean success;
    /**
     * 成功时返回的数据
     */
    private T result;

    private String error;

    private String reason;

    /**
     * Instantiates a new Json result.
     */
    public JsonResult() {
    }

    /**
     * 成功时的构造器
     *
     * @param success the success
     * @param result  the result
     */
    public JsonResult(boolean success, T result) {
        this.success = success;
        this.result = result;
    }

    /**
     * 错误时的构造器
     *
     * @param success the success
     * @param error   the error
     */
    public JsonResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    /**
     * Is success boolean.
     *
     * @return the boolean
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets success.
     *
     * @param success the success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Gets result.
     *
     * @return the result
     */
    public T getResult() {
        return result;
    }

    /**
     * Sets result.
     *
     * @param result the data
     */
    public void setResult(T result) {
        this.result = result;
    }

    /**
     * Gets error.
     *
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * Sets error.
     *
     * @param error the error
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Gets reason.
     *
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets reason.
     *
     * @param reason the reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "{success=" + success + ", data=" + result + ", error=" + error + "}";
    }
}
