package com.kakao.itstudy.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
	private int itemid;
	private String itemname;
	private int price;
	private String description;
	private String pictureurl;
}
