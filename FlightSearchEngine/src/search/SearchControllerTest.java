package search;

import user.*;
import java.util.*;

public class SearchControllerTest {
	
	

	public SearchControllerTest() {
	}
	
	
	public FlightModel[] getDataFromDataBase() {
	
	
	FlightManager connectdata = new FlightManager();
	connectdata.getFlightByDestination();
	connectdata.getReturnType().results;
		
	FlightModel[] flights = new FlightModel[results.size()];
	
	for(int i = 0; i < results.size(); i++) {
		flights[i] = results.get(i);
	}
	
	return flights;
	
	}
	
}
