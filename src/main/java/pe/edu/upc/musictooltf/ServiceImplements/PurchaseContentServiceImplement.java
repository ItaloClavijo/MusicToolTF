package pe.edu.upc.musictooltf.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.musictooltf.Entities.PurchaseContent;
import pe.edu.upc.musictooltf.Repositories.IPurchaseContentRepository;
import pe.edu.upc.musictooltf.Services.IPurchaseContentService;

import java.util.List;

@Service
public class PurchaseContentServiceImplement implements IPurchaseContentService{
    @Autowired
    private IPurchaseContentRepository purchaseContentRepository;
    @Override
    public void insert(PurchaseContent purchaseContent) {
        purchaseContentRepository.save(purchaseContent);
    }

    @Override
    public void delete(int id) {
        purchaseContentRepository.deleteById(id);
    }

    @Override
    public List<PurchaseContent> list() {
        return purchaseContentRepository.findAll();
    }
}
