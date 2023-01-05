package com.kakao.itstudy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kakao.itstudy.domain.ItemEntity;
import com.kakao.itstudy.dto.ItemDTO;
import com.kakao.itstudy.persistence.ItemMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
//	@Autowired
	private final ItemMapper itemMapper;

	@Override
	public List<ItemDTO> allItem() {
		List<ItemDTO> list = new ArrayList<>();
		//Repository 메서드 호출
		List<ItemEntity> result = itemMapper.allItem();
		// 결과 변환
		for (ItemEntity entity : result) {
			list.add(entityToDTO(entity));
		}
		return list;
	}
	
}
