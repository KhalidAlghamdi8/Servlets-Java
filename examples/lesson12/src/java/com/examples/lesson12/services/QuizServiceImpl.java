package com.examples.lesson12.services;

import com.examples.lesson12.model.QuizResult;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

@ApplicationScoped
public class QuizServiceImpl implements QuizService {

  private static final Logger LOG = Logger.getLogger(QuizServiceImpl.class.getName());
  @PersistenceContext(unitName = "QuizPU")
  private EntityManager em;
  @Resource
  private UserTransaction utx;

  @Override
  public List<QuizResult> getAllResults() {
    try {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<QuizResult> cq = cb.createQuery(QuizResult.class);
      Root<QuizResult> quizRes = cq.from(QuizResult.class);
      cq.select(quizRes);
      TypedQuery<QuizResult> auctionQuery = em.createQuery(cq);
      return auctionQuery.getResultList();
    } catch (Exception e) {
      LOG.log(Level.SEVERE, e.getMessage());
    }
    return Collections.emptyList();

  }

  @Override
  public void save(QuizResult result, String remoteUser) {
    if (!result.isSaved()) {
      try {
        utx.begin();
        result.setUser(remoteUser);
        em.persist(result);
        result.setSaved(true);
        utx.commit();
      } catch (Exception ex) {
        LOG.log(Level.SEVERE, ex.getMessage());
        throw new RuntimeException(ex);
      }
    }
  }
}
