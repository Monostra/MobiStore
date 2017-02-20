package ua.com.internet_shop.editor;

import ua.com.internet_shop.service.EyesStoppersService;

import java.beans.PropertyEditorSupport;

public class EyesStoppersEditor extends PropertyEditorSupport {

    private final EyesStoppersService eyesStoppersService;

    public EyesStoppersEditor(EyesStoppersService eyesStoppersService) {
        this.eyesStoppersService = eyesStoppersService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(eyesStoppersService.findOne(Short.parseShort(text)));
    }
}
