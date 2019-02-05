package co.manager.dto;

/**
 *
 * @author jguisao
 */
public class ResponseDTO {

    private int code;
    private Object content;

    public ResponseDTO() {
    }

    public ResponseDTO(int code, Object content) {
        this.code = code;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

}