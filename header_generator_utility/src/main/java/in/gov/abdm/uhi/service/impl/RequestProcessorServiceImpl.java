package in.gov.abdm.uhi.service.impl;

import in.gov.abdm.uhi.model.request.SignedHeaderGenerateRequest;
import in.gov.abdm.uhi.model.request.SignedHeaderVerificationRequest;
import in.gov.abdm.uhi.service.RequestProcessor;
import in.gov.abdm.uhi.utility.Crypt;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;

@Service
public class RequestProcessorServiceImpl
  implements RequestProcessor {
  @Autowired
  Crypt crypt;

  @Override
  public Map<String, String> generateKeyPair()
    throws NoSuchAlgorithmException {
    Map<String, String> keypairResponse = crypt.generateDerKeyPairs();
    return keypairResponse;
  }

  @Override
  public Map<String, String> headerGenerator( SignedHeaderGenerateRequest signedHeaderGenerateRequest )
    throws Exception {
    Map<String, String> headerGeneratedResponse = crypt.generateAuthorizationParams(
      signedHeaderGenerateRequest.getSubsID(), signedHeaderGenerateRequest.getPublicKeyID(),
      signedHeaderGenerateRequest.getPayLoad(), in.gov.abdm.uhi.header_generator.Crypt.getPrivateKey( "Ed25519",
        Base64.getDecoder().decode( signedHeaderGenerateRequest.getPrivateKey() ) ) );
    return headerGeneratedResponse;
  }

  @Override
  public boolean headerVerification( SignedHeaderVerificationRequest signedHeaderVerificationRequest ) {
    boolean verificationResponse = false;
    try {
      String hashedSigningString = crypt.generateBlakeHash(
        crypt.getSigningString( Long.parseLong( signedHeaderVerificationRequest.getCreated() ),
          Long.parseLong( signedHeaderVerificationRequest.getExpires() ), signedHeaderVerificationRequest.getData() ) );
      verificationResponse = crypt.verifySignature( hashedSigningString, signedHeaderVerificationRequest.getSignature(),
        "Ed25519", in.gov.abdm.uhi.header_generator.Crypt.getPublicKey( "Ed25519",
          Base64.getDecoder().decode( signedHeaderVerificationRequest.getPublicKey() ) ) );
    } catch( Exception e ) {
      System.out.println( "Verfication result is ::" + verificationResponse );
    }
    return verificationResponse;
  }
}