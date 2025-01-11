package TODOAPI;

public class TODOSoloTitle {
	private String title;
	private String _mock;

	public TODOSoloTitle(String title, String _mock) {
		this.title = title;
		this._mock = _mock;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getMock() {
		return _mock;
	}

	public void setMock(String _mock) {
		this._mock = _mock;
	}

	@Override
	public String toString() {
		return String.format("Todo [title=%s]", title);
	}
}
