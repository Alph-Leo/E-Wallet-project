package semicolon.africa.wallet.service;

import semicolon.africa.wallet.data.models.User;
import semicolon.africa.wallet.data.models.Wallet;
import semicolon.africa.wallet.dtos.request.WalletRequest;
import semicolon.africa.wallet.dtos.response.WalletResponse;

public interface WalletService {
    WalletResponse createWallet(WalletRequest walletRequest);
    Wallet findByUserId(String userId);
    void updateWallet(Wallet wallet);
}
