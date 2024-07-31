package in.co.rays.project_3.model;

import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * ModelFactory decides which model implementation run
 * 
 * @author Yash
 */
public final class ModelFactory {

	private static ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.project_3.bundle.system");
	private static final String DATABASE = rb.getString("DATABASE");

	private static ModelFactory mFactory = null;
	private static HashMap modelCache = new HashMap();

	private ModelFactory() {

	}

	public static ModelFactory getInstance() {
		if (mFactory == null) {
			mFactory = new ModelFactory();
		}
		return mFactory;
	}

	public MarksheetModelInt getMarksheetModel() {
		MarksheetModelInt marksheetModel = (MarksheetModelInt) modelCache.get("marksheetModel");
		if (marksheetModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				marksheetModel = new MarksheetModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				marksheetModel = new MarksheetModelJDBCImpl();
			}
			modelCache.put("marksheetModel", marksheetModel);
		}
		return marksheetModel;
	}

	public CollegeModelInt getCollegeModel() {
		CollegeModelInt collegeModel = (CollegeModelInt) modelCache.get("collegeModel");
		if (collegeModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				collegeModel = new CollegeModelHibImp();

			}
			if ("JDBC".equals(DATABASE)) {
				collegeModel = new CollegeModelJDBCImpl();
			}
			modelCache.put("collegeModel", collegeModel);
		}
		return collegeModel;
	}

	public RoleModelInt getRoleModel() {
		RoleModelInt roleModel = (RoleModelInt) modelCache.get("roleModel");
		if (roleModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				roleModel = new RoleModelHibImp();

			}
			if ("JDBC".equals(DATABASE)) {
				roleModel = new RoleModelJDBCImpl();
			}
			modelCache.put("roleModel", roleModel);
		}
		return roleModel;
	}

	public UserModelInt getUserModel() {

		UserModelInt userModel = (UserModelInt) modelCache.get("userModel");
		if (userModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				userModel = new UserModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				userModel = new UserModelJDBCImpl();
			}
			modelCache.put("userModel", userModel);
		}

		return userModel;
	}

	public StudentModelInt getStudentModel() {
		StudentModelInt studentModel = (StudentModelInt) modelCache.get("studentModel");
		if (studentModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				studentModel = new StudentModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				studentModel = new StudentModelJDBCImpl();
			}
			modelCache.put("studentModel", studentModel);
		}

		return studentModel;
	}

	public CourseModelInt getCourseModel() {
		CourseModelInt courseModel = (CourseModelInt) modelCache.get("courseModel");
		if (courseModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				courseModel = new CourseModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				courseModel = new CourseModelJDBCImpl();
			}
			modelCache.put("courseModel", courseModel);
		}

		return courseModel;
	}

	public TimetableModelInt getTimetableModel() {

		TimetableModelInt timetableModel = (TimetableModelInt) modelCache.get("timetableModel");

		if (timetableModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				timetableModel = new TimetableModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				timetableModel = new TimetableModelJDBCImpl();
			}
			modelCache.put("timetableModel", timetableModel);
		}

		return timetableModel;
	}

	public SubjectModelInt getSubjectModel() {
		SubjectModelInt subjectModel = (SubjectModelInt) modelCache.get("subjectModel");
		if (subjectModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				subjectModel = new SubjectModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				subjectModel = new SubjectModelJDBCImpl();
			}
			modelCache.put("subjectModel", subjectModel);
		}

		return subjectModel;
	}

	public FacultyModelInt getFacultyModel() {
		FacultyModelInt facultyModel = (FacultyModelInt) modelCache.get("facultyModel");
		if (facultyModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				facultyModel = new FacultyModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				facultyModel = new FacultyModelJDBCImpl();
			}
			modelCache.put("facultyModel", facultyModel);
		}

		return facultyModel;
	}

	public BankModelInt getBankModel() {

		BankModelInt bankModel = (BankModelInt) modelCache.get("bankModel");
		if (bankModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				bankModel = new BankModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("bankModel", bankModel);
		}

		return bankModel;
	}

	public EmployeeModelInt getEmployeeModel() {

		EmployeeModelInt EmployeeModel = (EmployeeModelInt) modelCache.get("EmployeeModel");
		if (EmployeeModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				EmployeeModel = new EmployeeModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("EmployeeModel", EmployeeModel);
		}

		return EmployeeModel;
	}

	public OrderModelInt getOrderModel() {

		OrderModelInt OrderModel = (OrderModelInt) modelCache.get("OrderModel");
		if (OrderModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				OrderModel = new OrderModelHipImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("OrderModel", OrderModel);
		}

		return OrderModel;
	}

	public LessionModelInt getLessionModel() {

		LessionModelInt LessionModel = (LessionModelInt) modelCache.get("LessionModel");
		if (LessionModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				LessionModel = new LessionModelHib();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("LessionModel", LessionModel);
		}

		return LessionModel;
	}

	public ProductModelInt getProductModel() {

		ProductModelInt ProductModel = (ProductModelInt) modelCache.get("ProductModel");
		if (ProductModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				ProductModel = new ProductModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("ProductModel", ProductModel);
		}

		return ProductModel;
	}

	public TypeModelInt getTypeModel() {

		TypeModelInt TypeModel = (TypeModelInt) modelCache.get("TypeModel");
		if (TypeModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				TypeModel = (TypeModelInt) new TypeModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("TypeModel", TypeModel);
		}
		return TypeModel;

	}

	public AddressModelInt getAddressModel() {

		AddressModelInt AddressModel = (AddressModelInt) modelCache.get("AddressModel");
		if (AddressModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				AddressModel = (AddressModelInt) new AddressModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("AddressModel", AddressModel);
		}
		return AddressModel;

	}

	public StatusModelInt getStatusModel() {

		StatusModelInt StatusModel = (StatusModelInt) modelCache.get("StatusModel");
		if (StatusModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				StatusModel = (StatusModelInt) new StatusModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("StatusModel", StatusModel);
		}
		return StatusModel;

	}

	public ClientModelInt getClientModel() {

		ClientModelInt ClientModel = (ClientModelInt) modelCache.get("ClientModel");
		if (ClientModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				ClientModel = (ClientModelInt) new ClientModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("ClientModel", ClientModel);
		}
		return ClientModel;

	}

	public PriorityModelInt getPriorityModel() {

		PriorityModelInt priorityModel = (PriorityModelInt) modelCache.get("priorityModel");
		if (priorityModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				priorityModel = (PriorityModelInt) new PriorityModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("priorityModel", priorityModel);
		}
		return priorityModel;

	}

	public DepartmentModelInt getDepartmentModel() {

		DepartmentModelInt departmentModel = (DepartmentModelInt) modelCache.get("departmentModel");
		if (departmentModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				departmentModel = (DepartmentModelInt) new DepartmentModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("departmentModel", departmentModel);
		}
		return departmentModel;

	}

	public PatientModeInt getPatientModel() {

		PatientModeInt patientModel = (PatientModeInt) modelCache.get("departmentModel");
		if (patientModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				patientModel = (PatientModeInt) new PatientModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("patientModel", patientModel);
		}
		return patientModel;

	}

	public DesceaseModeInt getDesceaseModel() {

		DesceaseModeInt DesceaseModel = (DesceaseModeInt) modelCache.get("DesceaseModel");
		if (DesceaseModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				DesceaseModel = (DesceaseModeInt) new DescaseModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("DesceaseModel", DesceaseModel);
		}
		return DesceaseModel;

	}

	public ProductDetailsModelInt getProductDetailsModel() {

		ProductDetailsModelInt productDetailsModel = (ProductDetailsModelInt) modelCache.get("productDetailsModel");
		if (productDetailsModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				productDetailsModel = (ProductDetailsModelInt) new ProductDetailsHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("productDetailsModel", productDetailsModel);
		}
		return productDetailsModel;

	}

	public CategoryModelInt getCategoryModel() {

		CategoryModelInt categoryModel = (CategoryModelInt) modelCache.get("categoryModel");
		if (categoryModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				categoryModel = (CategoryModelInt) new CategoryModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("categoryModel", categoryModel);
		}
		return categoryModel;

	}

	public InventoryModelInt getInventoryModel() {

		InventoryModelInt inventoryModel = (InventoryModelInt) modelCache.get("inventoryModel");
		if (inventoryModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				inventoryModel = (InventoryModelInt) new InventoryModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("inventoryModel", inventoryModel);
		}
		return inventoryModel;

	}

	public ProducttModelInt getPrducttModel() {

		ProducttModelInt producttModel = (ProducttModelInt) modelCache.get("producttModel");
		if (producttModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				producttModel = (ProducttModelInt) new ProductModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("producttModel", producttModel);
		}
		return producttModel;

	}

	public VechicleModelInt getVechicleModel() {

		VechicleModelInt vechicleModel = (VechicleModelInt) modelCache.get("vechicleModel");
		if (vechicleModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				vechicleModel = (VechicleModelInt) new VechicleModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("vechicleModel", vechicleModel);
		}
		return vechicleModel;

	}

	public ColourModelInt getColourModel() {

		ColourModelInt colourModel = (ColourModelInt) modelCache.get("colourModel");
		if (colourModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				colourModel = (ColourModelInt) new ColourModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("colourModel", colourModel);
		}
		return colourModel;

	}

	public TransportationModelInt getTransportationModel() {

		TransportationModelInt transportationModel = (TransportationModelInt) modelCache.get("colourModel");
		if (transportationModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				transportationModel = (TransportationModelInt) new TransportationModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("transportationModel", transportationModel);
		}
		return transportationModel;

	}

	public LoansModelInt getLoansModel() {

		LoansModelInt loansModel = (LoansModelInt) modelCache.get("colourModel");
		if (loansModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				loansModel = (LoansModelInt) new LoansModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("loansModel", loansModel);
		}
		return loansModel;

	}

	public LeadModelInt getLeadModel() {

		LeadModelInt LeadModel = (LeadModelInt) modelCache.get("LeadModel");
		if (LeadModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				LeadModel = (LeadModelInt) new LeadModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("LeadModel", LeadModel);
		}
		return LeadModel;

	}

	public SupplierModelInt getSupplierModel() {

		SupplierModelInt supplierModel = (SupplierModelInt) modelCache.get("supplierModel");
		if (supplierModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				supplierModel = (SupplierModelInt) new SupplierModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("supplierModel", supplierModel);
		}
		return supplierModel;

	}

	public VehicleTrackingModelInt getVehicleTrackingModel() {

		VehicleTrackingModelInt vehicleTrackingModel = (VehicleTrackingModelInt) modelCache.get("vehicleTrackingModel");
		if (vehicleTrackingModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				vehicleTrackingModel = new VehicleTrackingModelHibImp();
			}

			modelCache.put("vehicleTrackingModel", vehicleTrackingModel);
		}

		return vehicleTrackingModel;
	}

	public RouteModelInt getRouteModel() {

		RouteModelInt routeModel = (RouteModelInt) modelCache.get("routeModel");
		if (routeModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				routeModel = new RouteModelHibImp();
			}

			modelCache.put("routeModel", routeModel);
		}

		return routeModel;
	}

	/*
	 * public LoanModelInt getLoanModel() {
	 * 
	 * LoanModelInt loanModel = (LoanModelInt) modelCache.get("loanModel"); if
	 * (loanModel == null) { if ("Hibernate".equals(DATABASE)) { loanModel = new
	 * LoanModelHibImp(); }
	 * 
	 * modelCache.put("loanModel", loanModel); }
	 * 
	 * return loanModel; }
	 */
	
	  public OwnerModelInt getOwnerModel() {
	  
	  OwnerModelInt ownerModel = (OwnerModelInt) modelCache.get("ownerModel"); if
	  (ownerModel == null) { if ("Hibernate".equals(DATABASE)) { ownerModel = new
	  OwnerModelHibImp(); }
	  
	  modelCache.put("ownerModel", ownerModel); }
	  
	  return ownerModel;
	  
	  }
	  
	/*
	 * public ShoppingModelInt getShoppingModel() {
	 * 
	 * ShoppingModelInt shoppingModel = (ShoppingModelInt)
	 * modelCache.get("shoppingModel"); if (shoppingModel == null) { if
	 * ("Hibernate".equals(DATABASE)) { shoppingModel = new ShoppingModelHibImp(); }
	 * 
	 * modelCache.put("ownerModel", shoppingModel); }
	 * 
	 * return shoppingModel; }
	 * 
	 * public WishModelInt getWishModel() {
	 * 
	 * WishModelInt wishModel = (WishModelInt) modelCache.get("wishModel"); if
	 * (wishModel == null) { if ("Hibernate".equals(DATABASE)) { wishModel = new
	 * WishModelHibImp(); }
	 * 
	 * modelCache.put("wishModel", wishModel); }
	 * 
	 * return wishModel; }
	 * 
	 * public JobModelInt getJobModel() {
	 * 
	 * JobModelInt jobModel = (JobModelInt) modelCache.get("joblModel"); if
	 * (jobModel == null) { if ("Hibernate".equals(DATABASE)) { jobModel = new
	 * JobModelHibImp(); }
	 * 
	 * modelCache.put("jobModel", jobModel); }
	 * 
	 * return jobModel; }
	 */
	  
	  
	  public JobModelInt getJobModel() {
			
			  JobModelInt jobModel = (JobModelInt) modelCache.get("joblModel"); if
			  (jobModel == null) { if ("Hibernate".equals(DATABASE)) { jobModel = new
			  JobModelHibImp(); }
			  
			  modelCache.put("jobModel", jobModel); }
			 
			  return jobModel; }
}
