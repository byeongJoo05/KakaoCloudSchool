package com.kakao.security.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "roleSet")
public class ClubMember extends BaseEntity {
    @Id
    private String mid;
    private String mpw;
    private String email;
    private String name;
    private boolean del;
    private boolean social;

    // 권한 - 여러 개의 권한을 소유
    // 여러 개의 권한을 소유한다했지만, ENUM 타입의 변수마다 1개씩 받아서 사용하는 것이니 List가 아닌 Set으로 사용해야한다.
    // 중복되서 가질 수 있다? List ,  없다? Set
    // ToString할 때 에러가 날 가능성이 있음. 관계를 맞게 되므로.
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<ClubMemberRole> roleSet = new HashSet<>();

    public void changePassword(String mpw) {
        this.mpw = mpw;
    }

    public void changeEmail(String email) {
        this.email = email;
    }

    public void changeDel(boolean del) {
        this.del = del;
    }

    // 권한 추가
    public void addRole(ClubMemberRole memberRole) {
        this.roleSet.add(memberRole);
    }

    // 권한 삭제
    public void clearRoles() {
        this.roleSet.clear();
    }

    public void changeSocial(boolean social) {
        this.social = social;
    }
}
