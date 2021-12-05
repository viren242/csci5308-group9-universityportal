package edu.dalhousie.business.RoommateFinder.business;

import edu.dalhousie.business.RoommateFinder.constants.StringConstants;
import edu.dalhousie.business.RoommateFinder.model.RoommateFinderObjectModel;

import java.util.ArrayList;
import java.util.List;

public class FilterRoommates implements IFilterRoommates {

    public List<String> filterData(RoommateFinderObjectModel roommateFinderObject, List<String> matches) {
        List<String> filteredMatches = new ArrayList<>();

        if(matches.contains(roommateFinderObject.getUserName())){
            System.out.println(roommateFinderObject.getUserName());
            matches.remove(roommateFinderObject.getUserName());
        }

        if (matches.isEmpty()) {
            filteredMatches.add(StringConstants.kNoBuddies);
        } else {
            for (String match : matches) {
                filteredMatches.add(match);
            }
        }

        return filteredMatches;
    }

}
