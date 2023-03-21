package com.example.springredis.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springredis.domain.Member;

// Redis 에 JPA 처럼 작업을 할 수 있도록 해주는 Repository
// Proxy 패턴을 적용해서 SpringFramework 가 Bean을 생성해서 사용할 수 있도록 해줌.
public interface MemberRedisRepository extends CrudRepository<Member, String> {
}
