package TODOAPI;

import com.google.gson.annotations.SerializedName;

public class TODO {
	@SerializedName(value = "id", alternate = "_id")
	private String id;
	private String title;

	public TODO(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Todo [id=%s, title=%s]", id, title);
	}
}
