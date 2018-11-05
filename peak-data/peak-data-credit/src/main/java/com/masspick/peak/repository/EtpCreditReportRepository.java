package com.masspick.peak.repository;


import com.masspick.peak.model.credit.etp.dto.EtpCreditReportDto;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Administrator on 2018/6/16.
 */
public interface EtpCreditReportRepository extends MongoRepository<EtpCreditReportDto, String> {
}
