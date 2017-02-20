package ua.com.internet_shop.editor;

import ua.com.internet_shop.service.GoodsService;

import java.beans.PropertyEditorSupport;

public class GoodsEditor extends PropertyEditorSupport{

	private final GoodsService goodsService;

	public GoodsEditor(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(goodsService.findOne(Integer.parseInt(text)));
	}
	
	

}
