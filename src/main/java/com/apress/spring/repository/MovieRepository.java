package com.apress.spring.repository;
/*
 * Created by jungbin on 2018. 5. 10.
 */

import java.util.Collection;
import java.util.List;

import com.apress.spring.domain.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    Movie findByTitle(@Param("title") String title);

    List<Movie> findByTitleLike(@Param("title") String title);

    @Query("MATCH (m:Movie)<-[r:ACTED_IN]-(a:Person) RETURN m,r,a LIMIT {limit}")
    Collection<Movie> graph(@Param("limit") int limit);
}
