package in.gov.abdm.uhi.service;

import in.gov.abdm.uhi.model.request.GenerateKeyPairRequest;
import in.gov.abdm.uhi.model.request.SignedHeaderGenerateRequest;
import in.gov.abdm.uhi.model.request.SignedHeaderVerificationRequest;
import in.gov.abdm.uhi.model.response.ResponseStatusDTO;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

public interface RequestProcessor {
  public Map<String, String> generateKeyPair( )
    throws NoSuchAlgorithmException;

  public Map<String, String>  headerGenerator( SignedHeaderGenerateRequest signedHeaderGenerateRequest )
    throws Exception;

  public boolean headerVerification( SignedHeaderVerificationRequest signedHeaderVerificationRequest )
    throws Exception;

}
