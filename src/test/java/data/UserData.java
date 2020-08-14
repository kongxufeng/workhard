package data;

import org.testng.annotations.DataProvider;
import utils.ReadExcel;

public class UserData {
	@DataProvider(name="auth")
	public static  Object[][] getUserInfo(){
		return new  Object[][]{
				// { "600022_system", "yw123456" },
				{ "kongxufeng", "KXFhao123" },
				// { "4510301_system", "yw123456" },
		};
	}

	@DataProvider(name = "auth1")
	public static Object[][] getUserInfo1() {
		return new Object[][] {
				// { "600022_system", "yw123456" },
				{ "600633_system", "yw123456" }
				//{ "4510301_system", "yw123456" },
				};
	}

	@DataProvider(name = "auth2")
	public static Object[][] getUserInfo2() {
		return new Object[][] {
				// { "600022_system", "yw123456" },
				//{ "600633_system", "yw123456" },};
				{ "4510302_system", "yw123456" }, };
	}

	@DataProvider(name = "auth3")
	public static Object[][] getUserInfo3() {
		return new Object[][] {
				// { "600022_system", "yw123456" },
				// { "600633_system", "yw123456" },
				{ "740116_system", "yw123456" }, };
	}

	@DataProvider(name = "link")
	public static Object[][] link() {
		return ReadExcel.getDataFromExcel("link.xlsx", "link");
		
	}
	@DataProvider(name = "pingguzhenduan")
	public static Object[][] pingguzhenduan() {
		return ReadExcel.getDataFromExcel("pingguzhenduan.xlsx", "开始评估");
		
	}

	@DataProvider(name = "addvido")
	public static Object[][] addvido() {
		return ReadExcel.getDataFromExcel("vido.xlsx", "add");
	}

	@DataProvider(name = "editvido")
	public static Object[][] editvido() {
		return ReadExcel.getDataFromExcel("vido.xlsx", "edit");
	}

}
