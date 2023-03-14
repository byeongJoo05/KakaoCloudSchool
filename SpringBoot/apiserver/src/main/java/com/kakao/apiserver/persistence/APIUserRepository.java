package com.kakao.apiserver.persistence;

import com.kakao.apiserver.domain.APIUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface APIUserRepository extends JpaRepository<APIUser, String> {
}
