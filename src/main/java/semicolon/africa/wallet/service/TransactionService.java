package semicolon.africa.wallet.service;

import semicolon.africa.wallet.dtos.request.TransactionRequest;
import semicolon.africa.wallet.dtos.response.TransactionResponse;

public interface TransactionService {
    TransactionResponse transferFund(TransactionRequest transactionRequest);
}
