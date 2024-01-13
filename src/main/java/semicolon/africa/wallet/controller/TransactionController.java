package semicolon.africa.wallet.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import semicolon.africa.wallet.dtos.request.TransactionRequest;
import semicolon.africa.wallet.dtos.response.TransactionResponse;
import semicolon.africa.wallet.service.TransactionService;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/transaction")
public class TransactionController {
    private TransactionService transactionService;

    @RequestMapping("/transfer")
    public ResponseEntity<TransactionResponse> transfer(@RequestBody TransactionRequest transactionRequest){
        TransactionResponse response = transactionService.transferFund(transactionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
