/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package menu;

import academics.Schedule;
import list.NestedList;
import util.Export;

import java.io.IOException;

public class MySchedule implements MenuItem {
    private final NestedList sharedList;

    public MySchedule(NestedList sharedList) {
        this.sharedList = sharedList;
    } // end of constructor

    @Override
    public int size() {
        return sharedList.getMySchedule().size();
    } // end of size method

    @Override
    public Object getData(Object data) {
        for (int i = 0; i < sharedList.getMySchedule().size(); i++) {
            if (sharedList.getMySchedule().get(i).equals(data))
                return sharedList.getMySchedule().get(i);
        }
        return null;
    } // end of getData method

    @Override
    public Object getData(int index) {
        for (int i = 0; i < sharedList.getMySchedule().size(); i++) {
            if (i == index)
                return sharedList.getMySchedule().get(i);

        }
        return null;
    } // end of getData method

    @Override
    public void addToList(Object data){
        if (data instanceof Schedule schedule) {
            sharedList.getMySchedule().add(schedule);
        }
    } // end of addToList method

    @Override
    public void removeFromList(Object data){
        Schedule schedule = (Schedule) getData(data);
        sharedList.getMySchedule().remove(schedule);
    } // end of removeFromList method

    @Override
    public void updateDetails(Object currentData, Object newData) {
        sharedList.getMySchedule().update(currentData, newData);
    } // end of updateDetails method

    @Override
    public void exportList(String filename) throws IOException {
        Export util = new Export();
        util.exportTo(sharedList.getMySchedule(), filename);
    } // end of exportList method
} // end of MySchedule class
