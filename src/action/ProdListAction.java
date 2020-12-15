package action;

import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.ProdListService;
import vo.ActionForward;
import vo.Product;

public class ProdListAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<String> todayImageList = new ArrayList<String>();
		Cookie[] cookieArray = request.getCookies();
		
		if(cookieArray != null) {
			for (int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().startsWith("today")) {
					todayImageList.add(cookieArray[i].getValue());
				}
			}
		}
		
		ProdListService prodListService = new ProdListService();
		ArrayList<Product> prodList = prodListService.getProdList();
		request.setAttribute("prodList", prodList);
		request.setAttribute("todayImageList", todayImageList);
		ActionForward forward = new ActionForward("prod_list.jsp", false);
		return forward;
	}

}
