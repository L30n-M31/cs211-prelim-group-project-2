/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package menu;

import academics.Grade;
import list.NestedList;
import util.Export;

import java.io.IOException;

public class TranscriptOfRecords implements MenuItem {
    private final NestedList sharedList;

    public TranscriptOfRecords(NestedList sharedList) {
        this.sharedList = sharedList;
    } // end of constructor

    @Override
    public int size() {
        return sharedList.getTranscriptOfRecords().size();
    } // end of size method

    @Override
    public Object getData(Object data) {
        for (int i = 0; i < sharedList.getTranscriptOfRecords().size(); i++) {
            if (sharedList.getTranscriptOfRecords().get(i).equals(data))
                return sharedList.getTranscriptOfRecords().get(i);
        }
        return null;
    } // end of getData method

    @Override
    public Object getData(int index) {
        for (int i = 0; i < sharedList.getTranscriptOfRecords().size(); i++) {
            if (i == index)
                return sharedList.getTranscriptOfRecords().get(i);

        }
        return null;
    } // end of getData method

    @Override
    public void addToList(Object data) {
        if (data instanceof Grade grade) {
            sharedList.getTranscriptOfRecords().add(grade);
        }
    } // end of addToList method

    @Override
    public void removeFromList(Object data) {
        Grade course = (Grade) getData(data);
        sharedList.getTranscriptOfRecords().remove(course);
    } // end of removeFromList method

    @Override
    public void updateDetails(Object currentData, Object newData) {
        sharedList.getTranscriptOfRecords().update(currentData, newData);
    } // end of updateDetails method

    @Override
    public void exportList(String filename) throws IOException {
        Export util = new Export();
        util.exportTo(sharedList.getTranscriptOfRecords(), filename);
    } // end of exportList method
} // end of TranscriptOfRecords class
