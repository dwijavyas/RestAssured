package deserializationPOJO;

public class Api {

	//this is the grand child of grand parent getcourseresponse and child to courses class
	//"api" [2]:[{"courseTitle":"Rest Assured Automation using Java","price":"50"},
				//{"courseTitle":"SoapUI Webservices testing","price":"40"}],
	
	String courseTitle;
	String Price;
	
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		this.Price = price;
	}
	
	
}
