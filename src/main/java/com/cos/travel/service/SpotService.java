package com.cos.travel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cos.travel.model.Spot;
import com.cos.travel.repository.SpotRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SpotService {

	private final SpotRepository spotRepository;
	
	// 전체 관광지 목록 보기
	@Transactional(readOnly = true)
	public Page<Spot> list(Pageable pageable){
		return spotRepository.findAll(pageable);
	}
	
	// 공지사항 상세보기
		@Transactional(readOnly = true)
		public Spot detail(int id) {
			return spotRepository.findById(id)
					.orElseThrow(()->{
						return new IllegalArgumentException("상세보기 실패");
					});
		}
}
