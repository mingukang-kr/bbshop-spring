package com.bbshop.bit.mapper;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbshop.bit.domain.GoodsQnaVO;
import com.bbshop.bit.domain.GoodsVO;
import com.bbshop.bit.domain.MoreDetailVO;
import com.bbshop.bit.domain.PagingVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class GoodsMapperTests {

	@Setter(onMethod_ = @Autowired)
	private GoodsMapper mapper;
	
//	@Test
	public void testGetList() {
//		mapper.getGoodsList_New(1).forEach(goods -> log.info(goods));

	}
	
//	@Test
	public void testPaging() {
		
		PagingVO pagingVO = new PagingVO();
		
		//8개씩 2페이지
		pagingVO.setPageNum(1);
		pagingVO.setAmount(18);
		
		//검색 조건 설정
		pagingVO.setType("N");
		pagingVO.setKeyword("이치로");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pagingVO", pagingVO);
		map.put("category", 1);
		map.put("sorting", "lowPrice");
		map.put("min_amount", 1000);
		map.put("max_amount", 500000);
		
		
		List<GoodsVO> goodsList = mapper.getGoodsList(map);
		
		goodsList.forEach(goods -> log.info(goods));
	}
	
//	@Test 
	public void testGetGoodsInfo() {
		GoodsVO g = new GoodsVO();
		g = mapper.getGoodsInfo(8);
		
		log.info(g);
	}
	
//	@Test
	public void testInsertGoodsQnaSelectKey() {
		GoodsQnaVO qna = new GoodsQnaVO();
		qna.setTitle("상품 문의 합니다");
		qna.setContent("상품 문의 합니다 상품 문의 합니다 상품 문의 합니다 상품 문의 합니다 상품 문의 합니다 상품 문의 합니다");
		qna.setAttached_file("");
		qna.setGoods_num(18l);
		
		
		mapper.insertGoodsQnaSelectKey(qna);
		
		log.info(qna);
	}
	
//	@Test
	public void testQnaList() {
		PagingVO pagingVO = new PagingVO();
		
		//8개씩 2페이지
		pagingVO.setPageNum(1);
		pagingVO.setAmount(6);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pagingVO", pagingVO);
		map.put("goods_num", 21l);
		
		List<GoodsQnaVO> qnaList = mapper.getQnaList(map);
		qnaList.forEach(qna -> log.info(qna));
	}
	
//	@Test
	public void testRecommend() {
		MoreDetailVO m = new MoreDetailVO();
		m.setBrand1("nike");
		m.setBrand2("adidas");
		m.setBrand3("brett");
		m.setPosition("투수");
		m.setTeam("lg");
		m.setUser_key(950131);
		
		List<GoodsVO> list = mapper.recommendGoodsList(m);
		list.forEach(goods -> log.info(goods));
	}
	
//	@Test
	public void testFineDetail() {
		long user_key = 950131l;
		
		MoreDetailVO md = mapper.findDetail(user_key);
		
		log.info(md);
		
	}
	
	@Test
	public void testRecommendBest() {
		
		List<GoodsVO> list = mapper.recommendBestList();
		list.forEach(goods -> log.info(goods));
		
	}
}
