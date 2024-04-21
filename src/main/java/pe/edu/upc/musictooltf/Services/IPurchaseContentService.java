package pe.edu.upc.musictooltf.Services;

import pe.edu.upc.musictooltf.Entities.PurchaseContent;

import java.util.List;

public interface IPurchaseContentService {
    public void insert (PurchaseContent purchaseContent);
    public void delete (int id);
    public List<PurchaseContent> list ();
}
