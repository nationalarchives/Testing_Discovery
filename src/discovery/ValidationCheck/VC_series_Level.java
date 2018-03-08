package discovery.ValidationCheck;

import wrapper.Wrapper_methods;

public class VC_series_Level extends Wrapper_methods{
	
	@Override
	public void launchDriver(String URL, String browser) {
		// TODO Auto-generated method stub
		super.launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/C6486?_q=cvb&_sd=bvvb&_ed=&id=C6486&_ser=DV+5&path=r&name=Search", "chrome");
	}
	

}
