package semicolon.africa.wallet.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import semicolon.africa.wallet.data.models.User;
import semicolon.africa.wallet.data.models.Wallet;
import semicolon.africa.wallet.data.repositories.WalletRepository;
import semicolon.africa.wallet.dtos.request.WalletRequest;
import semicolon.africa.wallet.dtos.response.WalletResponse;
import semicolon.africa.wallet.exception.WalletBaseException;

@Service
@AllArgsConstructor
@Slf4j
public class E_WalletWalletService implements WalletService{
    private final WalletRepository walletRepository;
    @Override
    public WalletResponse createWallet(WalletRequest walletRequest) {
        Wallet wallet = new Wallet();
        wallet.setBalance(walletRequest.getBalance());
        wallet.setTransactions(walletRequest.getTransactions());
        Wallet savedWallet = walletRepository.save(wallet);

        WalletResponse response = getWalletResponse(savedWallet);
        return response;
    }

    @Override
    public Wallet findByUserId(String userPhoneNumber) {
        if (userPhoneNumber != null) {
            Wallet foundId = walletRepository.findWalletByUserPhoneNumber(userPhoneNumber);
            return foundId;
        }
                throw new WalletBaseException("User Id Is Null");
    }

    @Override
    public void updateWallet(Wallet wallet) {
        walletRepository.save(wallet);
    }

    @NonNull
    private WalletResponse getWalletResponse(Wallet wallet) {
        WalletResponse response = new WalletResponse();
        response.setWalletId(wallet.getWalletId());
        response.setBalance(wallet.getBalance());
        response.setTransactions(wallet.getTransactions());

        return response;
    }

}
