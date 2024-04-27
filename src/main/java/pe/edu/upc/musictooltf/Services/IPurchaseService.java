package pe.edu.upc.musictooltf.Services;

import pe.edu.upc.musictooltf.Entities.Purchase;

import java.time.LocalDate;
import java.util.List;

public interface IPurchaseService {
    public void create(List<Integer> idPurchase);
    public void delete (int id);
    public List<Purchase> list ();
    public Purchase updateToPaid(Integer purchaseId);
    public List<String[]> findUserNameWithTotalcompraByWithDate(LocalDate fechaInicio, LocalDate fechaFin);
}
