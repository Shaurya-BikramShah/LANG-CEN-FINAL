package com.langcen.controller;

import com.langcen.model.LangCenModel;
import java.util.ArrayList;
import java.util.List;

public class LangCenController {
    private List<LangCenModel> studentSortList;

    public LangCenController() {
        studentSortList = new ArrayList<>();
    }

    /**
     * Sorts a list of LangCenModel objects by their Student ID in ascending or descending order.
     *
     * @param studentList the list of LangCenModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return the sorted list
     */
    public List<LangCenModel> sortByStudentId(List<LangCenModel> studentList, boolean isDesc) {
        this.studentSortList.clear();
        this.studentSortList.addAll(studentList);

        if (studentSortList == null || studentSortList.isEmpty()) {
            throw new IllegalArgumentException("Student list cannot be null or empty.");
        }

        for (int i = 0; i < studentSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(studentSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(studentSortList, i, extremumIndex);
            }
        }

        return studentSortList;
    }

    private int findExtremumIndex(List<LangCenModel> studentSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < studentSortList.size(); j++) {
            if (shouldSwap(studentSortList.get(j).getStudentId(), studentSortList.get(extremumIndex).getStudentId(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    private void swap(List<LangCenModel> studentSortList, int i, int j) {
        LangCenModel temp = studentSortList.get(i);
        studentSortList.set(i, studentSortList.get(j));
        studentSortList.set(j, temp);
    }
    public List<LangCenModel> sortByStudentIdDescending(List<LangCenModel> studentList) {
    for (int i = 1; i < studentList.size(); i++) {
        LangCenModel key = studentList.get(i);
        int j = i - 1;

        // Move elements of studentList[0..i-1], that are less than key, to one position ahead
        while (j >= 0 && studentList.get(j).getStudentId() < key.getStudentId()) {
            studentList.set(j + 1, studentList.get(j));
            j--;
        }
        studentList.set(j + 1, key);
    }
    return studentList;
    }
    public LangCenModel searchStudentById(List<LangCenModel> studentList, int studentId) {
        int left = 0;
        int right = studentList.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            LangCenModel midStudent = studentList.get(mid);

            if (midStudent.getStudentId() == studentId) {
                return midStudent; // Student found
            }

            if (midStudent.getStudentId() < studentId) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return null; // Student not found
    }
    public List<LangCenModel> mergeSortByCourse(List<LangCenModel> studentList) {
    if (studentList.size() <= 1) {
        return studentList;
    }

    int mid = studentList.size() / 2;

    // Split the list into two halves
    List<LangCenModel> left = new ArrayList<>(studentList.subList(0, mid));
    List<LangCenModel> right = new ArrayList<>(studentList.subList(mid, studentList.size()));

    // Recursively sort both halves
    left = mergeSortByCourse(left);
    right = mergeSortByCourse(right);

    // Merge the sorted halves
    return mergeByCourse(left, right);
}
private List<LangCenModel> mergeByCourse(List<LangCenModel> left, List<LangCenModel> right) {
    List<LangCenModel> merged = new ArrayList<>();
    int i = 0, j = 0;

    // Merge the lists based on course names
    while (i < left.size() && j < right.size()) {
        if (left.get(i).getCourse().compareToIgnoreCase(right.get(j).getCourse()) <= 0) {
            merged.add(left.get(i));
            i++;
        } else {
            merged.add(right.get(j));
            j++;
        }
    }

    // Add remaining elements from both lists
    while (i < left.size()) {
        merged.add(left.get(i));
        i++;
    }
    while (j < right.size()) {
        merged.add(right.get(j));
        j++;
    }

    return merged;
}
}
