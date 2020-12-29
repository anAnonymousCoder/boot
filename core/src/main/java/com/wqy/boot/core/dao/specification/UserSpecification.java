package com.wqy.boot.core.dao.specification;

import com.wqy.boot.core.domain.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wqy
 * @version 1.0 2020/12/28
 */
public class UserSpecification implements Specification<User> {

    private String username;

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> whereList = new LinkedList<>();

        if (!StringUtils.isEmpty(username)) {
            whereList.add(criteriaBuilder.equal(root.get("name"), username));
        }
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("createAt")));
        return criteriaBuilder.and(whereList.toArray(new Predicate[0]));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
