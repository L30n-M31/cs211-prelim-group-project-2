/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package list;

public class NestedList {
    private LinkedList<LinkedList<Object>> menu;

    public NestedList() {
        initializeMenuStructure();
    } // end of default constructor

    public void initializeMenuStructure() {
        menu = new LinkedList<>();

        LinkedList<Object> curriculumChecklist = new LinkedList<>();
        LinkedList<Object> transcriptOfRecords = new LinkedList<>();
        LinkedList<Object> mySchedule = new LinkedList<>();

        menu.add(curriculumChecklist);
        menu.add(transcriptOfRecords);
        menu.add(mySchedule);
    } // end of initializeMenuStructure method

    public LinkedList<Object> getCurriculumChecklist() {
        return menu.get(0);
    }

    public LinkedList<Object> getTranscriptOfRecords() {
        return menu.get(1);
    }

    public LinkedList<Object> getMySchedule() {
        return menu.get(2);
    }

    public LinkedList<LinkedList<Object>> getMenu() {
        return menu;
    } // end of getMenu method
} // end of NestedLinkedList class
