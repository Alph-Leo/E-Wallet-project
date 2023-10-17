package semicolon.africa.wallet.service;

import semicolon.africa.wallet.dtos.request.WalletRequest;
import semicolon.africa.wallet.dtos.response.WalletResponse;

public interface WalletService {
    WalletResponse createWallet(WalletRequest walletRequest);
}