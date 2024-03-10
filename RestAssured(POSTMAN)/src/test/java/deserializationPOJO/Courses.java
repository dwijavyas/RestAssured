package deserializationPOJO;

import java.util.List;

public class Courses {
	
	//this is a child to the parent getcourseresponse
	//"courses"[3]:{
	//"webAutomation"[3]:[{"courseTitle":"Selenium Webdriver Java","price":"50"},
						//{"courseTitle":"Cypress","price":"40"},
						//{"courseTitle":"Protractor","price":"40"}],
	//"api" [2]:[{"courseTitle":"Rest Assured Automation using Java","price":"50"},
			//{"courseTitle":"SoapUI Webservices testing","price":"40"}],
	//"mobile" [1]:[{"courseTitle":"Appium-Mobile Automation using Java","price":"50"}]},
	
	private List<WebAutomation> webAutomation;
	private List<Api> api;
	private List<Mobile> mobile;
	
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<Api> getApi() {
		return api;
	}
	public void setApi(List<Api> api) {
		this.api = api;
	}
	public List<Mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}

}
