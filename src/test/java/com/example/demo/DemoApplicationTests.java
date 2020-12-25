package com.example.demo;

import com.example.demo.dao.GoodsDao;
import com.example.demo.entry.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private GoodsDao goodsDao;
	@Test
	void contextLoads() {
		Goods goods = new Goods();
		goods.setName("手机");
		goods.setPic("phone.jpg");
		goods.setPrice("2000");
		int count = goodsDao.insert(goods);
	}
	/**
	 * 更新商品信息
	 */
	@Test
	void test_02() {
		Goods goods = new Goods();
		goods.setId(4L);
		goods.setName("手机");
		goods.setPic("phone.jpg");
		goods.setPrice("3000");
		int count = goodsDao.update(goods);
	}

	/**
	 * 获取商品信息
	 */
	@Test
	void test_03() {
		Goods goods = goodsDao.selectOne(3L);

		System.out.println(goods);
	}

	/**
	 * 删除商品
	 */
	@Test
	void test_04() {
		int count = goodsDao.delete(3L);//此处应为delete(1L)
	}

	/**
	 * 获取商品信息列表
	 */
	@Test
	void test_05() {
		List<Goods> goodsList = goodsDao.selectAll();
		System.out.println(goodsList.toString());
	}

}
