package com.example.auditmodel.serviceImplementation;

import com.example.auditmodel.entity.Visitor;
import com.example.auditmodel.repository.VisitorRepository;
import com.example.auditmodel.service.VisitorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Override
    @Scheduled(cron = "0 * * * * ?")
    @Transactional
    public void autoTimeoutVisitorsAtMidnight() {
        List<Visitor> activeVisitors = visitorRepository.findBySignOutTimeIsNull();
        LocalDateTime now = LocalDateTime.now();

        System.out.println("Active Visitors: " + activeVisitors.size());

        for (Visitor visitor : activeVisitors) {
            visitor.setSignOutTime(now);
            visitorRepository.save(visitor);
            System.out.println("Visitor timed out:  " + visitor.getFirstName() + " " + visitor.getLastName());
        }
    }
}
