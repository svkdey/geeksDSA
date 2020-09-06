package LeetCode;

import java.sql.Time;
import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode1396 {

	
	class UndergroundSystem {
		 class Trip{
		        int id;
		        String startStationName;
		        String endStationName;
		        int begin;
		        int end;
		        public Trip(int id, String startStationName, int begin){
		            this.id = id;
		            this.startStationName = startStationName;
		            this.begin = begin;
		            this.end = -1;
		            this.endStationName="";
		        }
				@Override
				public String toString() {
					return "Trip [id=" + id + ", startStationName=" + startStationName + ", endStationName="
							+ endStationName + ", begin=" + begin + ", end=" + end + "]";
				}
		        
		        
		    }
		  Map<String,List<Trip>> tripsByStationName;
		    Map<Integer,Trip> tripsById;

		    public UndergroundSystem() {
		        this.tripsByStationName = new HashMap<String,List<Trip>>();
		        this.tripsById = new HashMap<Integer,Trip>();
		    }
		    
		    public void checkIn(int id, String stationName, int t) {
		        Trip trip = new Trip(id,stationName,t);
		        tripsById.put(id,trip);
		        List<Trip> stationNameTripList = tripsByStationName.getOrDefault(stationName,new ArrayList<Trip>());
		        stationNameTripList.add(trip);
		        tripsByStationName.put(stationName,stationNameTripList);
		        
		    }
		    
		    public void checkOut(int id, String stationName, int t) {
		        Trip trip = tripsById.get(id);
		        trip.endStationName = stationName;
		        trip.end = t;
		        tripsById.put(id,trip);
		    }
		    
		    public double getAverageTime(String startStation, String endStation) {
		        double totalTime = 0.0;
		        double totalTrips = 0.0;
		        List<Trip> lst = tripsByStationName.get(startStation);
		        for(Trip t : lst){
		            if(!t.endStationName.equals(endStation))continue;
		            totalTime+=(t.end - t.begin);
		            totalTrips++;
		        }
		        if(totalTrips==0)return 0.0;
		        return totalTime/totalTrips;
		        
		    }
		    
	}
}
