package com.kakao.board.persistence;

import com.kakao.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchBoardRepository {
    Board search1();

    // 검색을 위한 메서드
    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
