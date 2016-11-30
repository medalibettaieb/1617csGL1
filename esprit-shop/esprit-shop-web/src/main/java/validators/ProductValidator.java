package validators;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import entities.Product;
import mBeans.ProductBean;

@FacesValidator("pv")
public class ProductValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		ProductBean productBean = (ProductBean) context.getApplication().evaluateExpressionGet(context,
				"#{productBean}", ProductBean.class);
		List<Product> products = productBean.doFindAllProducts();
		for (Product p : products) {
			if (p.getName().equalsIgnoreCase(value.toString())) {
				FacesMessage msg = new FacesMessage("adding product failed.", "product name alrady exist");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);

			}
		}

	}
}
