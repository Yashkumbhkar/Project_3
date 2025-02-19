package in.co.rays.project_3.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.VechicleDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.model.ColourModelInt;
import in.co.rays.project_3.model.InventoryModelInt;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.VechicleModelInt;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

@WebServlet(name = "VechicleListCtl", urlPatterns = { "/ctl/VechicleListCtl" })

public class VechicleListCtl extends BaseCtl {

	@Override
	protected void preload(HttpServletRequest request) {
		ColourModelInt model = ModelFactory.getInstance().getColourModel();
		VechicleModelInt bmodel = ModelFactory.getInstance().getVechicleModel();

		try {
			List list1 = model.list(0, 0);
			request.setAttribute("mt", list1);

		} catch (Exception e) {

		}
	}

	@Override
	protected BaseDTO populateDTO(HttpServletRequest request) {

		VechicleDTO dto = new VechicleDTO();

		dto.setNumber(DataUtility.getString(request.getParameter("number")));
		dto.setPurchaseDate(DataUtility.getDate(request.getParameter("purchaseDate")));

		// dto.setId(DataUtility.getLong(request.getParameter("ddob")));

		dto.setInsuranceAmount(DataUtility.getInt(request.getParameter("insuranceAmount")));
		dto.setColour(DataUtility.getString(request.getParameter("colour")));

		populateBean(dto, request);
		return dto;

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List list;
		List next;
		int pageNo = 1;
		int pageSize = DataUtility.getInt(PropertyReader.getValue("page.size"));
		VechicleDTO dto = (VechicleDTO) populateDTO(request);

		VechicleModelInt model = ModelFactory.getInstance().getVechicleModel();
		try {
			list = model.search(dto, pageNo, pageSize);

			ArrayList<VechicleDTO> a = (ArrayList<VechicleDTO>) list;

			next = model.search(dto, pageNo + 1, pageSize);
			ServletUtility.setList(list, request);
			if (list == null || list.size() == 0) {
				ServletUtility.setErrorMessage("No record found ", request);
			}
			if (next == null || next.size() == 0) {
				request.setAttribute("nextListSize", 0);

			} else {
				request.setAttribute("nextListSize", next.size());
			}
			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);
		} catch (ApplicationException e) {
			ServletUtility.handleException(e, request, response);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List list = null;
		List next = null;
		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;
		VechicleDTO dto = (VechicleDTO) populateDTO(request);
		String op = DataUtility.getString(request.getParameter("operation"));

		String[] ids = request.getParameterValues("ids");
		VechicleModelInt model = ModelFactory.getInstance().getVechicleModel();
		try {

			if (OP_SEARCH.equalsIgnoreCase(op) || "Next".equalsIgnoreCase(op) || "Previous".equalsIgnoreCase(op)) {

				if (OP_SEARCH.equalsIgnoreCase(op)) {

					pageNo = 1;

					if (request.getParameter("number").equals("") && request.getParameter("insuranceAmount").equals("")
							&& (request.getParameter("colour").equals("") && (request.getParameter("purchaseDate").equals("")
									&& (request.getParameter("purchaseDate").equals(""))))) {

						ServletUtility.setErrorMessage("Pleae fill at least one search  ", request);

					}
				} else if (OP_NEXT.equalsIgnoreCase(op)) {
					pageNo++;
				} else if (OP_PREVIOUS.equalsIgnoreCase(op) && pageNo > 1) {
					pageNo--;
				}

			} else if (OP_NEW.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.VECHICLE_CTL, request, response);
				return;
			} else if (OP_RESET.equalsIgnoreCase(op)) {

				ServletUtility.redirect(ORSView.VECHICLE_LIST_CTL, request, response);
				return;
			} else if (OP_DELETE.equalsIgnoreCase(op)) {
				pageNo = 1;
				if (ids != null && ids.length > 0) {
					VechicleDTO deletedto = new VechicleDTO();
					for (String id : ids) {
						deletedto.setId(DataUtility.getLong(id));
						model.delete(deletedto);
						ServletUtility.setSuccessMessage("Data Deleted Successfully", request);
					}
				} else {
					ServletUtility.setErrorMessage("Select at least one record", request);
				}
			}
			if (OP_BACK.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.VECHICLE_LIST_CTL, request, response);
				return;
			}
			dto = (VechicleDTO) populateDTO(request);
			list = model.search(dto, pageNo, pageSize);

			ServletUtility.setDto(dto, request);
			next = model.search(dto, pageNo + 1, pageSize);

			ServletUtility.setList(list, request);
			ServletUtility.setList(list, request);
			if (list == null || list.size() == 0) {
				if (!OP_DELETE.equalsIgnoreCase(op)) {
					ServletUtility.setErrorMessage("No record found ", request);
				}
			}
			if (next == null || next.size() == 0) {
				request.setAttribute("nextListSize", 0);

			} else {
				request.setAttribute("nextListSize", next.size());
			}
			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);

		} catch (ApplicationException e) {
			ServletUtility.handleException(e, request, response);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.VECHICLE_LIST_VIEW;
	}

}
