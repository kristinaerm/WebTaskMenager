/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientmenager;

import model.Record;
import exceptions.InvalidRecordFieldException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import view.SimpleTaskManager;

/**
 *
 * @author USER
 */
public class Controller implements Serializable {

    private static ObjectInputStream in;
    private static ObjectOutputStream out;
    private static DefaultTableModel model;
    private static Record[] records;
    private static LinkedList<String> currentExposedList = new LinkedList();

    public static void setInputOutputStream(ObjectInputStream input, ObjectOutputStream output) {
        in = input;
        out = output;
    }

    public static void setTableModel(DefaultTableModel m) {
        model = m;
    }

    public static void setRecords(Record[] rec) {
        records = rec;
    }

    public static Record[] getRecords() {
        return records;
    }

    public static void addRecordToCurrentExposedList(String id) {
        currentExposedList.add(id);
    }

    public static boolean isExposed(String id) {
        return currentExposedList.contains(id);
    }

    public static void stopExposing(String id) {
        currentExposedList.remove(id);
    }

    public static void updateTable() throws IOException, ClassNotFoundException, InvalidRecordFieldException {
        out.writeChar('G');
        out.flush();
        int size = in.readInt();
        records = new Record[size];

        for (int i = 0; i < records.length; i++) {
            records[i] = (Record) in.readObject();
        }

        while (model.getRowCount() != 0) {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.removeRow(i);
            }
        }
        for (int i = 0; i < records.length; i++) {
            model.addRow(new Object[]{i, records[i].getName(), records[i].getTimeString(), records[i].getDescription(), records[i].getContacts()});
        }
        SimpleTaskManager.setReacords(records);
        SimpleTaskManager.updateNotification();
    }

    public static void addRecord(Record rec) throws IOException, ClassNotFoundException, InvalidRecordFieldException {
        out.writeChar('A');
        out.flush();
        out.writeObject(rec);
        out.flush();
        updateTable();

    }

    public static String changeRecord(Record rec) throws IOException, ClassNotFoundException, InvalidRecordFieldException {
        out.writeChar('C');
        out.flush();
        out.writeObject(rec);
        out.flush();
        String answer = in.readUTF();
        updateTable();
        if (answer.equals("OK")) {
            return "OK";
        } else {
            return answer;
        }

    }

    public static void deleteRecord(Record rec) throws IOException, ClassNotFoundException, InvalidRecordFieldException {
        out.writeChar('D');
        out.flush();
        out.writeObject(rec);
        out.flush();
        updateTable();
    }

    public static void saveTaskLog() throws IOException {
        out.writeChar('W');
        out.flush();
    }

}
