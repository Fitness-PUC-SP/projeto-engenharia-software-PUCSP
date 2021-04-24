package br.edu.pucsp.virtualtrainer.model.dto;

import br.edu.pucsp.virtualtrainer.model.entity.Category;

public class FieldDto {

    private String name;

    private CategoryDto category;

    private boolean certified;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public boolean isCertified() {
        return certified;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }
}
