package org.openlmis.distribution.service;

import org.openlmis.distribution.domain.FacilityVisit;
import org.openlmis.distribution.repository.FacilityVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FacilityVisitService {

  @Autowired
  FacilityVisitRepository repository;

  public boolean save(FacilityVisit facilityVisit) {
    FacilityVisit savedVisit = repository.get(facilityVisit);
    if (savedVisit == null) {
      repository.insert(facilityVisit);
    } else if (!savedVisit.getSynced()) {
      facilityVisit.setSynced(true);
      repository.update(facilityVisit);
      return true;
    }
    return false;
  }

  public FacilityVisit getById(Long facilityVisitId) {
    return repository.getById(facilityVisitId);
  }

  public FacilityVisit getBy(Long facilityId, Long distributionId) {
    return repository.getBy(facilityId, distributionId);
  }
}
