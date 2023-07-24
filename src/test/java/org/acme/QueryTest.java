package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import javax.inject.Inject;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class QueryTest {

    @Inject
    QueryTestBean testBean;

    @Test
    @Order(0)
    void testQuery() {
        testBean.createEntity();

        assertFalse(testBean.getByQuery().isEmpty());
    }


    @Test
    @Order(1)
    void testQueryWithAdditionalJoin() {
        assertFalse(testBean.getByQueryWithAdditionalJoin().isEmpty());
    }


}