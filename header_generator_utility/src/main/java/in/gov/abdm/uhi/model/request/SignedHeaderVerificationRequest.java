package in.gov.abdm.uhi.model.request;

import lombok.Data;

@Data
public class SignedHeaderVerificationRequest
{
  private String signature;
  private String created;
  private String expires;
  private String keyID;
  private String publicKey;
  private String data;
}
