package pe.edu.upc.musictooltf.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import pe.edu.upc.musictooltf.Entities.Content;
import pe.edu.upc.musictooltf.Entities.Purchase;
import pe.edu.upc.musictooltf.Entities.PurchaseContent;
import pe.edu.upc.musictooltf.Repositories.IContentRepository;
import pe.edu.upc.musictooltf.Repositories.IPurchaseContentRepository;
import pe.edu.upc.musictooltf.Repositories.IPurchaseRepository;
import pe.edu.upc.musictooltf.Services.IPurchaseService;
import pe.edu.upc.musictooltf.Exceptions.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseServiceImplement implements IPurchaseService {
    @Autowired
    private IPurchaseRepository purchaseRepository;

    @Autowired
    private IContentRepository iContentRepository;

    @Override
    public void create(List<Integer> contentIds) {

        Purchase purchase = new Purchase();
        purchase.setPurchaseDate(LocalDateTime.now());
        purchase.setPurchasePaymentStatus("PENDING");
        //purchase.setCustomer(null);

        float total = 0;
        List<PurchaseContent> items = new ArrayList<>();

        for (int contentId : contentIds) {
            Content content = iContentRepository
                    .findById(contentId)
                    .orElseThrow(ResourceNotFoundException::new);

            PurchaseContent purchaseContent = new PurchaseContent();
            purchaseContent.setPurchaseId(purchase);
            purchaseContent.setPurchaseContentPrice(purchase.getPurchaseTotal());
            purchaseContent.setIdContent(content);
            purchaseContent.setPurchaseContentAvailableDownloads(3);

            items.add(purchaseContent);
            total += content.getPriceContent();
        }
        purchase.setPurchaseTotal(total);
        purchase.setItems(items);

        purchaseRepository.save(purchase);
    }

//    public Resource getItemResource(Integer purchaseId, Integer itemId) {
//        PurchaseContent purchaseItem = IPurchaseContentRepository
//                .findByIdAndPurchaseId(itemId, purchaseId)
//                .orElseThrow(ResourceNotFoundException::new);
//
//        Purchase purchase = purchaseItem.getPurchase();
//
//        if (purchase.getPaymentStatus().equals(Purchase.PaymentStatus.PENDING)) {
//            throw new BadRequestException("La compra no ha sido pagada aún.");
//        }
//
//        if (purchaseItem.getDownloadsAvailable() > 0) {
//            purchaseItem.setDownloadsAvailable(
//                    purchaseItem.getDownloadsAvailable() - 1
//            );
//            purchaseItemRepository.save(purchaseItem);
//            return storageService.loadAsResource(purchaseItem.getBook().getFilePath());
//        } else {
//            throw new BadRequestException("No se puede descargar más este libro.");
//        }
//    }

    public Purchase updateToPaid(Integer purchaseId) {
        Purchase purchase = purchaseRepository
                .findById(purchaseId)
                .orElseThrow(ResourceNotFoundException::new);

        purchase.setPurchasePaymentStatus("PAID");
        return purchaseRepository.save(purchase);
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
