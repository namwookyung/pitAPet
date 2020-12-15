package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.ProdViewService;
import vo.ActionForward;
import vo.Product;

public class ProdViewAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProdViewService prodViewService = new ProdViewService();
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		Product prod = prodViewService.getProdView(p_id);
		request.setAttribute("product", prod);
		Cookie todayImageCookie = new Cookie("today" + p_id, prod.getP_image());
		todayImageCookie.setMaxAge(60*60*24);
		response.addCookie(todayImageCookie);
		ActionForward forward = new ActionForward("prodView.jsp", false);
		return forward;
	}

}
