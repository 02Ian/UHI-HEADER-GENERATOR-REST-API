package in.gov.abdm.uhi.controller;

import in.gov.abdm.uhi.model.request.GenerateKeyPairRequest;
import in.gov.abdm.uhi.model.request.SignedHeaderGenerateRequest;
import in.gov.abdm.uhi.model.request.SignedHeaderVerificationRequest;
import in.gov.abdm.uhi.service.RequestProcessor;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
public class HeaderGeneratorController {

  @Autowired
  RequestProcessor requestProcessor;

  //    ---------- "1. Key pair generation" ---------------------
  //    ---------- "2. Signed header generation" ---------------------
  //    ---------- "3. Signed header Verification" ---------------------

  @Operation(description = "Key pair generation")
  @PostMapping(value = "/keypairgenerator")
  public Map<String, String> generateKeyPair()
    throws NoSuchAlgorithmException {
    return requestProcessor.generateKeyPair( );
  }

  @Operation(description = "Signed header generation")
  @PostMapping(value = "/headergenerator", consumes = MediaType.APPLICATION_JSON_VALUE)
  public Map<String, String>  headerGenerator( @RequestBody SignedHeaderGenerateRequest signedHeaderGenerateRequest )
    throws Exception {
    return requestProcessor.headerGenerator( signedHeaderGenerateRequest );
  }


  @Operation(description = "Signed header Verification")
  @PostMapping(value = "/Verification", consumes = MediaType.APPLICATION_JSON_VALUE)
  public boolean headerVerification( @RequestBody SignedHeaderVerificationRequest signedHeaderVerificationRequest )
    throws Exception {
    return requestProcessor.headerVerification( signedHeaderVerificationRequest );
  }


}
