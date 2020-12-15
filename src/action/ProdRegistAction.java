package action;

import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import svc.ProdRegistService;
import vo.ActionForward;
import vo.Product;

public class ProdRegistAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProdRegistService ProdRegistService = new ProdRegistService();
		String realFolder = "";
		//파일 업로드될 서버 상의 물리적인 경로
		
		String saveFolder = "/img";
		String encType = "UTF-8";
		int maxSize = 5*1024*1024;
		//한 번에 업로드할 수 있는 파일의 크기
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("image");
		Product Prod = new Product(Integer.parseInt(multi.getParameter("p_id")), multi.getParameter("p_name"),
				Integer.parseInt(multi.getParameter("p_price")), multi.getParameter("p_option"), image, multi.getParameter("p_content"));
		boolean isRegistSuccess = ProdRegistService.registProduct(prod);
		ActionForward forward = null;
		
		if(isRegistSuccess) {
			forward = new ActionForward("prodList.prod", true);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert("등록실패");");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
