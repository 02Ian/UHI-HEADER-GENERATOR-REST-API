package in.gov.abdm.uhi.model.request;

public class SignedHeaderGenerateRequest {
  private String subsID;
  private String publicKeyID;
  private String privateKey;
  private String payLoad;


  public String getSubsID() {
    return subsID;
  }

  public void setSubsID( String subsID ) {
    this.subsID = subsID;
  }

  public String getPublicKeyID() {
    return publicKeyID;
  }

  public void setPublicKeyID( String publicKeyID ) {
    this.publicKeyID = publicKeyID;
  }

  public String getPrivateKey() {
    return privateKey;
  }

  public void setPrivateKey( String privateKey ) {
    this.privateKey = privateKey;
  }

  public String getPayLoad() {
    return payLoad;
  }

  public void setPayLoad( String payLoad ) {
    this.payLoad = payLoad;
  }

}
