package com.game.checkout.gamecheckout.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.game.checkout.gamecheckout.domain.Game;
import com.game.checkout.gamecheckout.domain.History;
import com.game.checkout.gamecheckout.domain.User;

@Service
public class HistoryService {

	@PersistenceContext 
	private EntityManager entityManager;
	
	public List <History> getHistoryByUser(User user) {
		return getHistoryByEntity(user, "user");
	}
	
	public List <History> getHistoryByGame(Game game) {
		return getHistoryByEntity(game, "game");
	}
	
	private List <History> getHistoryByEntity(Object entity, String attrib) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<History> query = builder.createQuery(History.class);
		Root<History> historyRoot = query.from(History.class);
		List<History> result = entityManager.createQuery(
							query.select(historyRoot)
							     .where(builder.equal(historyRoot.get(attrib), entity)))
				                 .getResultStream().collect(Collectors.toList());
		return result;
	}
	
}
