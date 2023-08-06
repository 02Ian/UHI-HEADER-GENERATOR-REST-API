package in.gov.abdm.uhi.model.response;

public class ResponseStatusDTO {
  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus( String status ) {
    this.status = status;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode( String errorCode ) {
    this.errorCode = errorCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage( String message ) {
    this.message = message;
  }

  private String errorCode;
  private String message;
}
