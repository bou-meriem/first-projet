package com.l3.gl.view;

import com.l3.gl.model.Task;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MainView {

    private JFrame frame;
    private DefaultListModel<String> listModel;
    private JList<String> taskList;

    public MainView(List<Task> tasks,
                    Runnable onAdd,
                    Runnable onDelete,
                    Runnable onLogout) {

        frame = new JFrame("Task Manager");
        frame.setSize(500, 400);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        updateTasks(tasks);

        JButton addBtn = new JButton("Ajouter");
        JButton deleteBtn = new JButton("Supprimer");
        JButton logoutBtn = new JButton("Logout");

        addBtn.addActionListener(e -> onAdd.run());
        deleteBtn.addActionListener(e -> onDelete.run());
        logoutBtn.addActionListener(e -> {
            frame.dispose();
            onLogout.run();
        });

        JPanel btnPanel = new JPanel();
        btnPanel.add(addBtn);
        btnPanel.add(deleteBtn);
        btnPanel.add(logoutBtn);

        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.add(btnPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void updateTasks(List<Task> tasks) {
        listModel.clear();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        for (Task t : tasks) {
            listModel.addElement(
                    (t.isDone() ? "[X] " : "[ ] ")
                            + t.getDescription()
                            + " - " + f.format(t.getDateTime())
            );
        }
    }
}