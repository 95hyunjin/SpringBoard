package com.itwillbs.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	
	// 서비스 객체 주입
	@Inject
	private BoardService bService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// 글쓰기GET : /board/register
	// http://localhost:8088/board/register
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception{
		logger.debug(" /board/register -> registerGET() 호출 ");
		logger.debug(" /baord/register.jsp 뷰 연결 ");
		
	}
	
	// 글쓰기POST : /board/register
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO vo) throws Exception{
		logger.debug(" /board/register.jsp (submit) -> registerPOST() 호출 ");
		
		// 한글처리 생략 -> 필터 처리 했음
		// 전달정보(글 정보) 저장
		logger.debug(" 전달정보 : " + vo);
		
		// 서비스 -> DAO 글쓰기 동작 호출
		bService.regist(vo);
		
		logger.debug(" 글쓰기 완료! -> 리스트 페이지로 이동 ");
		
		// 페이지 이동 (list)
		
		return "redirect:/board/list";
	}
	
	
	
	
	
	
	
} //BoardController