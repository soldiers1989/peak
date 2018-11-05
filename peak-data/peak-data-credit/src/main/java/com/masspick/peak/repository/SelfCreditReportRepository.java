package com.masspick.peak.repository;


import com.masspick.peak.model.credit.self.dto.SelfCreditReportDto;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Administrator on 2018/6/16.
 */
public interface SelfCreditReportRepository extends MongoRepository<SelfCreditReportDto, String> {
}
