package json;

import java.util.List;

public class ResultOfDetailData {

	private int Key;
	private List<DetailData> details;
	public int getKey() {
		return Key;
	}
	public void setKey(int key) {
		Key = key;
	}
	public List<DetailData> getDetails() {
		return details;
	}
	public void setDetails(List<DetailData> details) {
		this.details = details;
	}
}
