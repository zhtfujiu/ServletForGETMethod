package json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class TestOfDetailDataJSON {

	public static void main(String[] args) {

		ResultOfDetailData resultOfDetailData=new ResultOfDetailData();
		resultOfDetailData.setKey(1);
		List<DetailData> list=new ArrayList<DetailData>();
		resultOfDetailData.setDetails(list);
		
		DetailData data_1=new DetailData();
		data_1.setUserID("08133586");
		data_1.setTime("2016-4-3 10:29:34");
		data_1.setStoreID("jiubawu");
		data_1.setLocationID("sst");
		data_1.setScoreOfShangpin("3");
		data_1.setScoreOfFuwu("3");
		data_1.setComment("¼¦µ°ºÃ³Ô");
		list.add(data_1);
		
		Gson gson=new Gson();
		System.out.println(gson.toJson(resultOfDetailData));
	}

}
