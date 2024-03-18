package com.peisia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.peisia.dto.Dto;
import com.peisia.dto.GuestDto;
import com.peisia.mapper.GuestMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class GuestServiceImpl implements GuestService{

	@Setter(onMethod_ = @Autowired)
	private GuestMapper mapper;	

	@Override
	public Model getList(int currentPage, Model m) {
		log.info("비지니스 계층===========");
		Dto dto = new Dto();
		m.addAttribute("currentPage_for", currentPage); //현재 페이지 번호

		int totalPage = mapper.getTotalCount()/dto.getPAGE_LINK_AMOUNT();
		int totalBlock = (int)Math.ceil((double)totalPage/dto.getBLOCK_LINK_AMOUNT());
		int currentBlockNo = (int)Math.ceil((double)currentPage/ dto.getPAGE_LINK_AMOUNT());
		int startBlock = (int)Math.ceil((double)(currentBlockNo-1)*dto.getPAGE_LINK_AMOUNT()+1);
		int endPage = currentBlockNo*dto.getPAGE_LINK_AMOUNT();
        m.addAttribute("endPage", endPage); // 한 블럭에 보일 페이지 수
        m.addAttribute("startBlock", startBlock); // 한 블럭에 보일 페이지 수
		
//    	 m.addAttribute("PAGE_LINK_AMOUNT",dto.getPAGE_LINK_AMOUNT()); // 한 페이지에 보일 글 수
//        m.addAttribute("BLOCK_LINK_AMOUNT", dto.getBLOCK_LINK_AMOUNT()); // 한 블럭에 보일 페이지 수
	   	int PAGE_LINK_AMOUNT = dto.getPAGE_LINK_AMOUNT();
        int limitIndex = (currentPage-1) * dto.getPAGE_LINK_AMOUNT();
        
         dto.setPAGE_LINK_AMOUNT(PAGE_LINK_AMOUNT);		
         dto.setLimitIndex(limitIndex);
		m.addAttribute("list", mapper.getList(dto));  //[1] 글페이지 내 글 가져오기
		m.addAttribute("pageCount", mapper.getTotalCount());  //최대 글 수
		
//		return mapper.getList(limitIndex);
		return m;
	}
	@Override
	public void noRe() {
		mapper.noRe();
	}
	@Override
	public void noRe2() {
		mapper.noRe2();
	}
	
//	@Override
//	public int getTotalCount() {
//		return mapper.getTotalCount();
//	}
	
	@Override
	public GuestDto read(long bno) {
		return mapper.read(bno);
	}
	
	@Override
	public void del(long bno) {
		mapper.del(bno);
	}		
	
	@Override
	public void write(GuestDto dto) {
		mapper.write(dto);
	}	
	
	@Override
	public void modify(GuestDto dto) {
		mapper.modify(dto);
	}
	
}
