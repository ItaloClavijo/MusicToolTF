package pe.edu.upc.musictooltf.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pe.edu.upc.musictooltf.Entities.*;
import pe.edu.upc.musictooltf.Exceptions.ResourceNotFoundException;
import pe.edu.upc.musictooltf.Repositories.IPlanRepository;
import pe.edu.upc.musictooltf.Repositories.ISubscriptionRepository;
import pe.edu.upc.musictooltf.Repositories.IUserRepository;
import pe.edu.upc.musictooltf.Services.ISubscriptionService;
import pe.edu.upc.musictooltf.Services.IUserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionServiceImplement implements ISubscriptionService {

    @Autowired
    private ISubscriptionRepository subscriptionRepository;

    @Autowired
    private IPlanRepository planRepository;

    @Autowired
    private IUserRepository userRepository;

    @Override
        public Subscription insert(Integer plan_id, Long user_id) {


        Subscription subscription = new Subscription();

        Plan plan = planRepository.findById(plan_id)
                .orElseThrow(ResourceNotFoundException::new);
        subscription.setPlanId(plan);
        Users user = userRepository.findById(user_id)
                .orElseThrow(ResourceNotFoundException::new);
        subscription.setUsersId(user);

        subscription.setDateStartSubscription(LocalDate.now());
        subscription.setDateEndSubscription(LocalDate.now().plusDays(30));
        subscription.setPurchasePaymentStatus("PENDING");
        subscription.setStateSubscription("ACTIVE");
        subscription.setTotalSubscription(plan.getPlanPrice());


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

    @Override
    public List<String[]> totalIncomeByPlan() {
        return subscriptionRepository.totalIncomeByPlan();
    }
}
