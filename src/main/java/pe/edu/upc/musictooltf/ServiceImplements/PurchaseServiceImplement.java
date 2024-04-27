package pe.edu.upc.musictooltf.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.musictooltf.Entities.Purchase;
import pe.edu.upc.musictooltf.Repositories.IPurchaseRepository;
import pe.edu.upc.musictooltf.Services.IPurchaseService;

import java.util.List;

@Service
public class PurchaseServiceImplement implements IPurchaseService {
    @Autowired
    private IPurchaseRepository purchaseRepository;


    @Override
    public void insert(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    @Override
    public void delete(int id) {
        purchaseRepository.deleteById(id);
    }

    @Override
    public List<Purchase> list() {
        return purchaseRepository.findAll();
    }
}
