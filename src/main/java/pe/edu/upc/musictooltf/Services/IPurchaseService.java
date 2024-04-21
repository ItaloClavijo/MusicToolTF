package pe.edu.upc.musictooltf.Services;

import pe.edu.upc.musictooltf.Entities.Purchase;

import java.util.List;

public interface IPurchaseService {
    public void insert (Purchase purchase);
    public void delete (int id);
    public List<Purchase> list ();
}
