package ru.gorshkov.gameother.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gorshkov.gameother.model.entity.VipStatus;
import ru.gorshkov.gameother.model.repository.VipStatusRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VipStatusService {
    private final VipStatusRepository vipStatusRepository;

    public List<VipStatus> getVipStatuses() {
        return vipStatusRepository.findAll();
    }

    public Long size() {
        return vipStatusRepository.count();
    }

    public VipStatus getVipStatusById(Long id) {
        return vipStatusRepository.findById(id).orElseThrow(() ->
                new RuntimeException("VipStatus not found for id :: " + id));
    }

    @Transactional
    public VipStatus saveVipStatus(VipStatus vipStatus) {
        return vipStatusRepository.save(vipStatus);
    }

    @Transactional
    public void deleteVipStatusById(Long id) {
        vipStatusRepository.deleteById(id);
    }
}
