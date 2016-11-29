package mBeans;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.Category;

@ManagedBean
@ViewScoped
public class CategoryBean {
	public List<Category> displayCategories() {
		return Arrays.asList(Category.values());

	}
}
