package semicolon.africa.wallet.service;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semicolon.africa.wallet.data.models.Wallet;
import semicolon.africa.wallet.data.repositories.WalletRepository;
import semicolon.africa.wallet.dtos.request.WalletRequest;
import semicolon.africa.wallet.dtos.response.WalletResponse;
@Service
@RequiredArgsConstructor
public class E_WalletWalletService implements WalletService{
    private final WalletRepository walletRepository;
    @Override
    public WalletResponse createWallet(WalletRequest walletRequest) {
        Wallet wallet = new Wallet();
        wallet.setWalletId(walletRequest.getWalletId());
        wallet.setBalance(walletRequest.getBalance());
        wallet.setTransactions(walletRequest.getTransactions());
        wallet.setUser(walletRequest.getUser());

        WalletResponse response = getWalletResponse(wallet);
        return response;
    }

    @NotNull
    private WalletResponse getWalletResponse(Wallet wallet) {
        Wallet savedWallet = walletRepository.save(wallet);
        WalletResponse response = new WalletResponse();
        response.setWalletId(savedWallet.getWalletId());
        response.setBalance(savedWallet.getBalance());
        response.setTransactions(savedWallet.getTransactions());
        response.setUser(savedWallet.getUser());
        return response;
    }
}
