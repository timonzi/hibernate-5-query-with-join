package org.acme;

import java.util.HashSet;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@ApplicationScoped
public class QueryTestBean {

    @Inject
    EntityManager em;


    @Transactional
    void createEntity() {
        final var childEntity = new ChildEntity();
        childEntity.setMasterField("masterValue001");
        childEntity.setChildField("childValue001");

        RelatedEntity relatedEntity = new RelatedEntity();
        relatedEntity.setRelatedField("relatedValue001");
        relatedEntity.setChildEntity(childEntity);

        RelatedEntity relatedEntity2 = new RelatedEntity();
        relatedEntity2.setRelatedField("relatedValue002");
        relatedEntity2.setChildEntity(childEntity);

        HashSet<RelatedEntity> relatedEntityHashSet = new HashSet<>();
        relatedEntityHashSet.add(relatedEntity);
        relatedEntityHashSet.add(relatedEntity2);

        childEntity.setRelatedEntitySet(relatedEntityHashSet);

        em.persist(childEntity);
        em.persist(relatedEntity);
        em.persist(relatedEntity2);
    }


    @Transactional
    List<ChildPojo> getByQuery() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ChildPojo> query = cb.createQuery(ChildPojo.class);
        Root<ChildEntity> root = query.from(ChildEntity.class);

        query.multiselect(
                root.get("masterField"),
                root.get("childField")
        );

        TypedQuery<ChildPojo> result = em.createQuery(query);
        List<ChildPojo> resultList = result.getResultList();

        for (ChildPojo pojo : resultList) {
            System.out.println("found: " + pojo);
        }

        return resultList;
    }


    @Transactional
    List<ChildPojo> getByQueryWithAdditionalJoin() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ChildPojo> query = cb.createQuery(ChildPojo.class);
        Root<ChildEntity> root = query.from(ChildEntity.class);
        Join<ChildEntity, RelatedEntity> relatedEntityJoin = root.join("relatedEntitySet");

        query.multiselect(
                root.get("masterField"),
                root.get("childField"),
                relatedEntityJoin.get("relatedField")
        );

        TypedQuery<ChildPojo> result = em.createQuery(query);
        List<ChildPojo> resultList = result.getResultList();

        for (ChildPojo pojo : resultList) {
            System.out.println("found: " + pojo);
        }

        return resultList;
    }

}
