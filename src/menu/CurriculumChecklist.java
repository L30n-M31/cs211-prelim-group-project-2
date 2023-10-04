/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package menu;

import academics.Course;
import list.NestedList;
import util.Export;

import java.io.IOException;

public class CurriculumChecklist implements MenuItem {
    private final NestedList sharedList;

    public CurriculumChecklist(NestedList sharedList) {
        this.sharedList = sharedList;
    } // end of constructor method

    @Override
    public int size() {
        return sharedList.getCurriculumChecklist().size();
    } // end of size method

    @Override
    public Object getData(Object data) {
        for (int i = 0; i < sharedList.getCurriculumChecklist().size(); i++) {
            if (sharedList.getCurriculumChecklist().get(i).equals(data))
                return sharedList.getCurriculumChecklist().get(i);
        }
        return null;
    } // end of getData method

    @Override
    public Object getData(int index) {
        for (int i = 0; i < sharedList.getCurriculumChecklist().size(); i++) {
            if (i == index)
                return sharedList.getCurriculumChecklist().get(i);

        }
        return null;
    } // end of getData method

    @Override
    public void addToList(Object data) {
        if (data instanceof Course course) {
            sharedList.getCurriculumChecklist().add(course);
        }
    } // end of addToList method

    @Override
    public void removeFromList(Object data) {
        Course course = (Course) getData(data);
        sharedList.getCurriculumChecklist().remove(course);
    } // end of removeFromList method

    @Override
    public void updateDetails(Object currentData, Object newData) {
        sharedList.getCurriculumChecklist().update(currentData, newData);
    } // end of updateDetails method

    @Override
    public void exportList(String filename) throws IOException {
        Export util = new Export();
        util.exportTo(sharedList.getCurriculumChecklist(), filename);
    } // end of exportList method
} // end of CurriculumChecklist class
