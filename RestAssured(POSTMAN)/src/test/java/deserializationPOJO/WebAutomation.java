package deserializationPOJO;

public class WebAutomation {

	//this is the grand child of grand parent getcourseresponse and child to courses class
	//"webAutomation"[3]:
			//[{"courseTitle":"Selenium Webdriver Java",
			//"price":"50"},
			//{"courseTitle":"Cypress",
			//"price":"40"},
			//{"courseTitle":"Protractor",
			//"price":"40"}],
	
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
