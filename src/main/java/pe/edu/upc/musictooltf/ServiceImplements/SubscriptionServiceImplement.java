package pe.edu.upc.musictooltf.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.musictooltf.Entities.Subscription;
import pe.edu.upc.musictooltf.Repositories.ISubscriptionRepository;
import pe.edu.upc.musictooltf.Services.ISubscriptionService;

import java.util.List;

@Service
public class SubscriptionServiceImplement implements ISubscriptionService {

    @Autowired
    private ISubscriptionRepository subscriptionRepository;

    @Override
    public Subscription insert(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public List<Subscription> list() {
        return subscriptionRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        subscriptionRepository.deleteById(id);
    }

    @Override
    public Subscription findById(Integer id) {
        return subscriptionRepository.findById(id).orElseThrow();
    }
}
