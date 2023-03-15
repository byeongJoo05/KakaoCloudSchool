package com.kakao.lango.sendmail.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Entity
public class Member {
	//    @Id
	//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	//    private Long mid;

	@Id
	private String memberName;

	private String password;

	public void changePassword(String password) {
		this.password = password;
	}
}
