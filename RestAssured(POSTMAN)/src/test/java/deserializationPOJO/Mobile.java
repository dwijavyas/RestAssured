package deserializationPOJO;

public class Mobile {
	
	//this is the grand child of grand parent getcourseresponse and child to courses class	
	//"mobile" [1]:[{"courseTitle":"Appium-Mobile Automation using Java","price":"50"}]},
	
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
